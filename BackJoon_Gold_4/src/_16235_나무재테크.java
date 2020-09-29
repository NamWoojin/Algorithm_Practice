import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class _16235_나무재테크 {
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][N];
		int[][] garden = new int[N][N];
		ArrayList<Integer>[][] trees = new ArrayList[N][N];
		Deque<Integer>[][] deque = new ArrayDeque[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			Arrays.fill(garden[i], 5);
			for (int j = 0; j < N; ++j) {
				A[i][j] = Integer.parseInt(st.nextToken());
				trees[i][j] = new ArrayList<>();
				deque[i][j] = new ArrayDeque<Integer>();
			}
		}
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			trees[r][c].add(age);
		}
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if(trees[i][j].size()==0)
					continue;
				
				trees[i][j].sort(null);
				Iterator iter = trees[i][j].iterator();
				while(iter.hasNext()) {
					deque[i][j].offer((int)iter.next());
				}
			}
		}
		while (--K >= 0) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					int energy = 0;
					int size = deque[i][j].size();
					while (--size >= 0) {
						int age = deque[i][j].poll();
						if (garden[i][j] >= age) {
							garden[i][j] -= age;
							deque[i][j].offer(age + 1);
						} else {
							energy +=( age / 2);
						}
					}
					garden[i][j] += energy;
				}
			}

			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					int size = deque[i][j].size();
					while (--size>=0) {
						int num = deque[i][j].poll();
						if (num % 5 == 0) {
							for (int k = 0; k < 8; ++k) {
								int rr = i + dr[k];
								int cc = j + dc[k];
								if (rr < 0 || cc < 0 || rr > N - 1 || cc > N - 1)
									continue;
								deque[rr][cc].push(1);
							}
						}
						deque[i][j].offer(num);
					}
					garden[i][j] += A[i][j];
				}
			}

		}
		int sum = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				sum += deque[i][j].size();
			}
		}
		System.out.println(sum);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _16234_인구이동 {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		while (true) {
			boolean find = false;
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (visited[i][j])
						continue;
					
					int sum = 0;
					int cnt = 0;
					Queue<Node> q = new LinkedList<>();
					Stack<Node> s = new Stack<>();
					q.add(new Node(i,j));
					s.add(new Node(i,j));
					visited[i][j] = true;
					while(!q.isEmpty()) {
						Node n = q.poll();
						sum += map[n.r][n.c];
						++cnt;
						for (int k = 0; k < 4; ++k) {
							int rr = n.r + dr[k];
							int cc = n.c + dc[k];
							if (rr < 0 || cc < 0 || rr >= N || cc >= N)
								continue;
							if(visited[rr][cc])
								continue;
							
							int diff = Math.abs(map[n.r][n.c] - map[rr][cc]);
							if(diff >= L && diff <= R) {
								visited[rr][cc] = true;
								q.add(new Node(rr,cc));
								s.add(new Node(rr,cc));
							}
						}
					}
					
					if(s.size()>1) {
						find = true;
					}
					while(!s.isEmpty()) {
						Node n = s.pop();
						map[n.r][n.c] = sum/cnt;
					}

				}
			}

			if (find) {
				++count;
			} else {
				break;
			}
			
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
		}
		System.out.println(count);
	}
}

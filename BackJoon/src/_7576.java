import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> next = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		boolean endFlag = false;
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int days = -1;
		int[][] box = new int[N][M];
		for (int i = 0; i < N; ++i) { // 입력
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; ++j) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean allRipe = true;
		
		end: for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (box[i][j] == 1) {
					next.offer(i);
					next.offer(j);
				} else if(box[i][j] == 0) {
					allRipe = false;
					int cant = 0;
					for (int k = 0; k < 4; ++k) {
						int r = i + dr[k];
						int c = j + dc[k];

						if (r < 0 || c < 0 || r >= N || c >= M) {
							++cant;
							continue;
						}
						if (box[r][c] == -1)
							++cant;
					}
					if (cant == 4) {
						days = -1;
						endFlag = true;
						break end;
					}
					else {
						
					}
				}
			}
		}
		if (allRipe) {
			days = 0;
			endFlag = true;
		}
		while (!endFlag) {
			int size = next.size()/2;
			if(size == 0) {
				out:for (int i = 0; i < N; ++i) {
					for (int j = 0; j < M; ++j) {
						if(box[i][j] == 0) {
							days = -1;
							break out;
						}
					}
				}
				break;
			}
			while (--size >= 0) {
				int r = next.poll();
				int c = next.poll();

				for (int k = 0; k < 4; ++k) {
					int rr = r + dr[k];
					int cc = c + dc[k];

					if (rr < 0 || cc < 0 || rr >= N || cc >= M)
						continue;
					if (box[rr][cc] == 0) {
						box[rr][cc] = 1;
						next.offer(rr);
						next.offer(cc);
					}
				}
			}
			++days;
		}
		
		System.out.println(days);	//마지막에 넣은 1도 확인하므로
	}
	
	
}

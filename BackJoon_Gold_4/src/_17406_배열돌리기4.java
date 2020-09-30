import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17406_배열돌리기4 {
	static int arr[][], N, M, K, rotation[][], order[], min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		rotation = new int[K][3];
		order = new int[K];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(in.readLine());
			rotation[i][0] = Integer.parseInt(st.nextToken()) - 1;
			rotation[i][1] = Integer.parseInt(st.nextToken()) - 1;
			rotation[i][2] = Integer.parseInt(st.nextToken());
		}

		makeOrder(0, 0);
		System.out.println(min);
	}

	private static void makeOrder(int idx, int choosen) {
		if (idx == K) {
			doRotation();
			return;
		}

		for (int i = 0; i < K; ++i) {
			if ((choosen & (1 << i)) == 0) {
				order[idx] = i;
				makeOrder(idx + 1, choosen | (1 << i));
			}
		}
	}

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	private static void doRotation() {
		int[][] tempArr = new int[N][];
		for (int i = 0; i < N; ++i) {
			tempArr[i] = arr[i].clone();
		}

		for (int i = 0; i < K; ++i) {
			int r = rotation[order[i]][0];
			int c = rotation[order[i]][1];
			int s = rotation[order[i]][2];
			int moveNum = 3;
			for (int j = 1; j <= s; ++j) {
				int rr = r - j;
				int cc = c - j;
				int temp = tempArr[rr][cc];
				int moveCnt = 1;
				int idx = 3;
				out: while (true) {
					tempArr[rr][cc] = tempArr[rr + dr[idx]][cc + dc[idx]];
					++moveCnt;
					rr += dr[idx];
					cc += dc[idx];
					if (moveCnt == moveNum) {
						switch (idx) {
						case 3:
						case 1:
						case 2:
							--idx;
							moveCnt = 1;
							continue;
						case 0:
							tempArr[rr - dr[idx]][cc - dc[idx]] = temp;
							break out;
						}
					}
				}
				moveNum += 2;

			}
		}
		int minSum = Integer.MAX_VALUE;

		for (int i = 0; i < N; ++i) {
			int sum = 0;
			for (int j = 0; j < M; ++j) {
				sum += tempArr[i][j];
			}
			minSum = Math.min(sum, minSum);
		}
		min = Math.min(min, minSum);
	}
}

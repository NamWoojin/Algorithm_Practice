import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569 {
	// 위 아래 왼쪽 오른쪽 앞 뒤
	static int[] dh = { 1, -1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, 0, 0, 1, -1 };
	static int[] dc = { 0, 0, -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> next = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		boolean endFlag = false;

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int days = -1;
		int[][][] box = new int[H][N][M];
		for (int k = 0; k < H; ++k) {
			for (int i = 0; i < N; ++i) { // 입력
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; ++j) {
					box[k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		boolean allRipe = true;
		for (int k = 0; k < H; ++k) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (box[k][i][j] == 1) {
						next.offer(k);
						next.offer(i);
						next.offer(j);
					} else if (box[k][i][j] == 0) {
						allRipe = false;
					}
				}
			}
		}

		if (allRipe) {
			days = 0;
			endFlag = true;
		}

		while (!endFlag) {
			int size = next.size() / 3;
			if (size == 0) {
				out: for (int k = 0; k < H; ++k) {
					for (int i = 0; i < N; ++i) {
						for (int j = 0; j < M; ++j) {
							if (box[k][i][j] == 0) {
								days = -1;
								break out;
							}
						}
					}
				}
				break;
			}
			while (--size >= 0) {
				int h = next.poll();
				int r = next.poll();
				int c = next.poll();

				for (int k = 0; k < 6; ++k) {
					int hh = h + dh[k];
					int rr = r + dr[k];
					int cc = c + dc[k];

					if (hh>=H|| hh<0 ||rr < 0 || cc < 0 || rr >= N || cc >= M)
						continue;
					if (box[hh][rr][cc] == 0) {
						box[hh][rr][cc] = 1;
						next.offer(hh);
						next.offer(rr);
						next.offer(cc);
					}
				}
			}
			++days;
		}

		System.out.println(days); // 마지막에 넣은 1도 확인하므로
	}

}

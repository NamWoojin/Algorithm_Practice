import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _20056_마법사상어와파이어볼 {
	static class fireBall {
		int m, d, s;

		fireBall(int m, int d, int s) {
			this.m = m;
			this.d = d;
			this.s = s;
		}
	}

	static int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int dir[][] = { { 0, 2, 4, 6 }, { 1, 3, 5, 7 } };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<fireBall>[][] queue = new LinkedList[N][N];
		int cnt[][] = new int[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				queue[i][j] = new LinkedList<>();
			}
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			queue[r][c].offer(new fireBall(m, d, s));
			++cnt[r][c];
		}

		for (int count = 0; count < K; ++count) {
			for (int i = 0; i < N; ++i) { // 이동하기
				for (int j = 0; j < N; ++j) {
					while (cnt[i][j] > 0) {
						--cnt[i][j];
						fireBall fb = queue[i][j].poll();
						int rr = i + dr[fb.d] * fb.s;
						int cc = j + dc[fb.d] * fb.s;

						while (rr < 0 || rr >= N) {
							if (rr < 0)
								rr += N;
							else if (rr >= N)
								rr -= N;
						}

						while (cc < 0 || cc >= N) {
							if (cc < 0)
								cc += N;
							else if (cc >= N)
								cc -= N;
						}
						queue[rr][cc].offer(fb);
					}
				}
			}

			for (int i = 0; i < N; ++i) { // 파이어볼 합치기,이번 턴 개수 세기
				for (int j = 0; j < N; ++j) {
					if (queue[i][j].size() > 1) {
						int size = queue[i][j].size();
						fireBall fb = queue[i][j].poll();
						int sumM = fb.m;
						int sumS = fb.s;
						boolean equalDir = true;
						boolean Dir = fb.d % 2 == 0; // false:홀, true:짝
						while (queue[i][j].size() > 0) {
							fb = queue[i][j].poll();
							sumM += fb.m;
							sumS += fb.s;
							if (equalDir && Dir != (fb.d % 2 == 0)) {
								equalDir = false;
							}
						}
						if (sumM / 5 != 0) {
							for (int k = 0; k < 4; ++k) {
								if (equalDir) {
									queue[i][j].offer(new fireBall(sumM / 5, dir[0][k], sumS / size));
								} else {
									queue[i][j].offer(new fireBall(sumM / 5, dir[1][k], sumS / size));
								}
							}
						}
					}
					cnt[i][j] = queue[i][j].size();
				}
			}
		}
		int totalM = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				while (queue[i][j].size() > 0) {
					totalM += queue[i][j].poll().m;
				}
			}
		}
		System.out.println(totalM);

	}
}

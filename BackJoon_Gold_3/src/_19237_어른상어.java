import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _19237_어른상어 {
	static class shark {
		int r, c, dir;

		shark(int r, int c, int dir) {
			this.dir = dir;
			this.r = r;
			this.c = c;
		}
	}

	static int N, M, k, time = 0;
	static int map[][][]; // [0] : 상어번호, [1] : 냄새 뭍혀진 시간
	static int dirPriority[][][]; // 상어별 방향별 우선순위
	static shark sharks[]; // 상어현황
	static Queue<Integer> list = new LinkedList<>(); // 상어개수
	static int dr[] = { 0, -1, 1, 0, 0 };
	static int dc[] = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[N][N][2];
		dirPriority = new int[M + 1][5][4];
		sharks = new shark[M + 1];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
				if (map[i][j][0] != 0) {
					sharks[map[i][j][0]] = new shark(i, j, 0);
					map[i][j][1] = k;
				}
			}
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= M; ++i) {
			sharks[i].dir = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= M; ++i) {
			list.add(i);
			for (int j = 1; j <= 4; ++j) {
				st = new StringTokenizer(in.readLine());
				for (int k = 0; k < 4; ++k) {
					dirPriority[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		while (list.size() > 1 && time <= 1000) {
			++time;

			int[][][] newMap = new int[N][N][2];
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (map[i][j][1] != time) { // 냄새가 사라질 자리가 아니면
						newMap[i][j] = map[i][j].clone();
					}
				}
			}

			int size = list.size();
			next: while (--size >= 0) {
				int sharkNum = list.poll();
				shark shark = sharks[sharkNum];

				// 아무냄새 없는곳 찾기
				for (int i = 0; i < 4; ++i) {
					int direction = dirPriority[sharkNum][shark.dir][i];
					int rr = shark.r + dr[direction];
					int cc = shark.c + dc[direction];

					if (rr < 0 || cc < 0 || rr >= N || cc >= N)
						continue;
					if (map[rr][cc][0] == 0 || map[rr][cc][1] < time) { // 냄새가 없거나, 냄새가 없어진 자리라면
						if (newMap[rr][cc][0] == 0) { // 앞선 번호의 상어가 먼저 차지한 자리가 아니면
							newMap[rr][cc][0] = sharkNum;
							newMap[rr][cc][1] = time + k;
							sharks[sharkNum] = new shark(rr, cc, direction);
							list.add(sharkNum);
						}
						continue next;
					}
				}

				// 내 냄새 있는 곳 찾기
				for (int i = 0; i < 4; ++i) {
					int direction = dirPriority[sharkNum][shark.dir][i];
					int rr = shark.r + dr[direction];
					int cc = shark.c + dc[direction];
					if (rr < 0 || cc < 0 || rr >= N || cc >= N)
						continue;

					if (map[rr][cc][0] == sharkNum) { // 내 냄새가 있는 자리라면
						newMap[rr][cc][0] = sharkNum;
						newMap[rr][cc][1] = time + k;
						sharks[sharkNum] = new shark(rr, cc, direction);
						list.add(sharkNum);
						continue next;
					}
				}
			}
			
			map = newMap;
			
		}
		System.out.println(time <= 1000 ? time : -1);
	}
}

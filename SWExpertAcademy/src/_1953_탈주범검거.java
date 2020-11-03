import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1953_탈주범검거 {
	static int[][] dir = new int[][] { { 0, 0 }, { 0, 0 }, { 0, 2 }, { 1, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][M];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int place = 0;
			boolean[][] visited = new boolean[N][M];
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(R, C));
			visited[R][C] = true;
			int time = 0;
			while (time < L) {
				int size = q.size();
				while (--size >= 0) {
					Node n = q.poll();
					++place;

					if (map[n.r][n.c] == 1) {
						for (int i = 0; i < 4; ++i) {
							int rr = n.r + dr[i];
							int cc = n.c + dc[i];
							if (rr < 0 || cc < 0 || rr >= N || cc >= M)
								continue;
							if (visited[rr][cc])
								continue;
							if (map[rr][cc] == 0)
								continue;
							
							boolean canGo = false;
							if (map[rr][cc] != 1) {
								for(int j =0; j<2;++j) {
									int direction  =dir[map[rr][cc]][j];
									if(direction%2 == i%2 &&  direction != i) {
										canGo = true;
										break;
									}
								}
							}else {
								canGo = true;
							}
							
							if(!canGo)
								continue;
							visited[rr][cc] = true;
							q.add(new Node(rr, cc));
						}
					} else {
						int idx = map[n.r][n.c];
						for (int i = 0; i < 2; ++i) {
							int rr = n.r + dr[dir[idx][i]];
							int cc = n.c + dc[dir[idx][i]];

							if (rr < 0 || cc < 0 || rr >= N || cc >= M)
								continue;
							if (visited[rr][cc])
								continue;
							if (map[rr][cc] == 0)
								continue;

							boolean canGo = false;
							if (map[rr][cc] != 1) {
								for(int j =0; j<2;++j) {
									int direction  =dir[map[rr][cc]][j];
									if(direction%2 == dir[idx][i]%2 &&  direction != dir[idx][i]) {
										canGo = true;
										break;
									}
								}
							}else {
								canGo = true;
							}
							
							if(!canGo)
								continue;

							visited[rr][cc] = true;
							q.add(new Node(rr, cc));
						}
					}
				}
				++time;
			}
			System.out.println("#" + tc + " " + place);
		}
	}
}

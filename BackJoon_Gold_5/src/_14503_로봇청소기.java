import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14503_로봇청소기 {
	static class Node {
		int r, c, dir;

		public Node(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		dir = dir % 2 == 1 ? (dir == 1 ? 3 : 1) : dir;
		Node robot = new Node(r, c, dir);
		boolean[][] map = new boolean[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = st.nextToken().equals("1");
			}
		}

		int count = 0;
		boolean[][] visited = new boolean[N][M];
		boolean back = false;
		next: while (true) {
			if (!back) {
				visited[robot.r][robot.c] = true;
				++count;
			}else {
				back = false;
			}
			for (int i = 1; i <= 4; ++i) {
				int newDir = (robot.dir + i) % 4;
				if (!map[robot.r + dr[newDir]][robot.c + dc[newDir]]
						&& !visited[robot.r + dr[newDir]][robot.c + dc[newDir]]) {
					robot.dir = newDir;
					robot.r += dr[newDir];
					robot.c += dc[newDir];
					continue next;
				}
			}

			if (map[robot.r - dr[robot.dir]][robot.c - dc[robot.dir]]) {
				break next;
			} else {
				robot.r -= dr[robot.dir];
				robot.c -= dc[robot.dir];
				back = true;
			}
		}
		System.out.println(count);
	}
}

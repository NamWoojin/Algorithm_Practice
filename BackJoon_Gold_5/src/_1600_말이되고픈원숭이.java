import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1600_말이되고픈원숭이 {
	static class Node {
		int r, c;
		int horse;
		int movement;

		Node(int r, int c, int horse, int movement) {
			this.horse = horse;
			this.r = r;
			this.c = c;
			this.movement = movement;
		}
	}

	static boolean[][][] isVisited;
	static int K;
	static int W;
	static int H;
	static int[] horse_dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] horse_dc = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		int[][] area = new int[H][W];
		isVisited = new boolean[H][W][K + 1];
		for (int i = 0; i < H; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < W; ++j) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		System.out.println(bfs(area));
	}

	private static int bfs(int[][] area) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0, 0, 0));
		isVisited[0][0][0] = true;

		while (!queue.isEmpty()) {
			Node n = queue.poll();

			if (n.r == H - 1 && n.c == W - 1)
				return n.movement;

			if (n.horse < K) {
				for (int i = 0; i < 8; ++i) {
					int rr = n.r + horse_dr[i];
					int cc = n.c + horse_dc[i];

					if (rr < 0 || cc < 0 || rr >= H || cc >= W)
						continue;
					
					if (!isVisited[rr][cc][n.horse + 1] && area[rr][cc] != 1) {
						queue.add(new Node(rr, cc, n.horse + 1, n.movement + 1));
						isVisited[rr][cc][n.horse + 1] = true;
					}
				}
			}

			for (int i = 0; i < 4; ++i) {
				int rr = n.r + dr[i];
				int cc = n.c + dc[i];

				if (rr < 0 || cc < 0 || rr >= H || cc >= W)
					continue;
				
				if (!isVisited[rr][cc][n.horse] && area[rr][cc] != 1) {
					queue.add(new Node(rr, cc, n.horse, n.movement + 1));
					isVisited[rr][cc][n.horse] = true;
				}
			}

		}

		return -1;
	}
}

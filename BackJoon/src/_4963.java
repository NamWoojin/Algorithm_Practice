import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4963 {
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int W;
	static int H;
	static Queue<Node> queue = new LinkedList<>();
	static int[][] map;

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	// bfs
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count = 1001;
		while (true) {
			st = new StringTokenizer(in.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W == 0 && H == 0)
				break;
			map = new int[H][W];
			for (int h = 0; h < H; ++h) {
				st = new StringTokenizer(in.readLine());
				for (int w = 0; w < W; ++w) {
					map[h][w] = Integer.parseInt(st.nextToken());
				}
			}

			count = 1001;
			for (int h = 0; h < H; ++h) {
				for (int w = 0; w < W; ++w) {
					if (map[h][w] == 1) {
						CountIsland(h, w, count);
						++count;
					}
				}
			}

			System.out.println(count - 1001);
		}

	}

	// 1인 점 찾은 경우
	private static void CountIsland(int r, int c, int count) {
		queue.offer(new Node(r, c));
		map[r][c] = count;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int rr,cc;
			for (int i = 0; i < 8; ++i) {
				rr = node.r + dr[i];
				cc = node.c + dc[i];
				if (rr < 0 || cc < 0 || rr >= H || cc >= W)
					continue;
				if (map[rr][cc] == 1) {
					queue.offer(new Node(rr, cc));
					map[rr][cc] = count;
				}
			}
		}
	}
}

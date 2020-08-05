import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2667 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int W;
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

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> array = new ArrayList<>();

		W = Integer.parseInt(in.readLine());
		map = new int[W][W];
		for (int h = 0; h < W; ++h) {
			String str = in.readLine();
			for (int w = 0; w < W; ++w) {
				map[h][w] = str.charAt(w) - '0';
			}
		}

		int danji=0;
		for (int h = 0; h < W; ++h) {
			for (int w = 0; w < W; ++w) {
				if (map[h][w] == 1) {

					int num = CountIsland(h, w, danji);
					++danji;
					array.add(num);
					array.sort(null);
				}
			}
		}

		System.out.println(danji);
		for (int i = 0; i < array.size(); ++i)
			System.out.println(array.get(i));

	}

	// 1인 점 찾은 경우
	private static int CountIsland(int r, int c, int count) {
		int number = 0;
		queue.offer(new Node(r, c));
		map[r][c] = count;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			++number;
			int rr, cc;
			for (int i = 0; i < 4; ++i) {
				rr = node.r + dr[i];
				cc = node.c + dc[i];
				if (rr < 0 || cc < 0 || rr >= W || cc >= W)
					continue;
				if (map[rr][cc] == 1) {
					queue.offer(new Node(rr, cc));
					map[rr][cc] = count;
				}
			}
		}
		return number;
	}
}

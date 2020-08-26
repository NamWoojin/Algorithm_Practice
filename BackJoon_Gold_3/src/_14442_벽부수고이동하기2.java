import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _14442_벽부수고이동하기2 {
	static class Node implements Comparable<Node> {
		int r, c;
		int crash;
		int movement;

		Node(int r, int c, int crash, int movement) {
			this.crash = crash;
			this.r = r;
			this.c = c;
			this.movement = movement;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.movement - o.movement;
		}

	}

	static boolean[][][] isVisited;
	static int N;
	static int M;
	static int K;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[][] area = new int[N][M];
		isVisited = new boolean[N][M][K + 1];
		for (int i = 0; i < N; ++i) {
			String str = in.readLine();
			for (int j = 0; j < M; ++j) {
				area[i][j] = str.charAt(j) - '0';
			}
		}

		System.out.println(bfs(area));
	}

	private static int bfs(int[][] area) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(0, 0, 0, 1));
		isVisited[0][0][0] = true;

		while (!queue.isEmpty()) {
			Node n = queue.poll();

			if (n.r == N - 1 && n.c == M - 1)
				return n.movement;

			for (int i = 0; i < 4; ++i) {
				int rr = n.r + dr[i];
				int cc = n.c + dc[i];

				if (rr < 0 || cc < 0 || rr >= N || cc >= M)
					continue;

				if (n.crash < K && !isVisited[rr][cc][n.crash + 1] && area[rr][cc] == 1) {
					queue.add(new Node(rr, cc, n.crash + 1, n.movement + 1));
					isVisited[rr][cc][n.crash + 1] = true;
				}
				if (!isVisited[rr][cc][n.crash] && area[rr][cc] == 0) {
					queue.add(new Node(rr, cc, n.crash, n.movement + 1));
					isVisited[rr][cc][n.crash] = true;
				}
			}

		}

		return -1;
	}
}

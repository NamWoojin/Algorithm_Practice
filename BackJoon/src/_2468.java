import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2468 {

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int[][] arr;
	static boolean[][] visited;
	static int N;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		int min = 100;
		int max = 0;
		int maxIsland = 0;
		int maxBorder = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine()); // 한 줄 읽기(띄어쓰기 단위로 자름)
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = min > arr[i][j] ? arr[i][j] : min; // 최솟값 찾기
				max = max < arr[i][j] ? arr[i][j] : max; // 최댓값 찾기
			}
		}
		if (min == max) {
			maxIsland = 1;
		} else {
			for (int border = min; border < max; ++border) {
				visited = new boolean[N][N];
				int countIsland = 0;
				for (int i = 0; i < N; ++i) {
					for (int j = 0; j < N; ++j) {
						if (!visited[i][j] && arr[i][j] > border) {
							countIsland++;
							CountIsland(i, j, border);
						}
					}
				}

				if (maxIsland <= countIsland) {
					maxIsland = countIsland;
					maxBorder = border;
				}
			}
		}

		System.out.println(maxIsland);

	}

	private static void CountIsland(int r, int c, int border) {
		Queue<Node> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.offer(new Node(r, c));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int rr, cc;
			for (int i = 0; i < 4; ++i) {
				rr = node.r + dr[i];
				cc = node.c + dc[i];
				if (rr < 0 || cc < 0 || rr >= N || cc >= N)
					continue;
				if (!visited[rr][cc] && arr[rr][cc] > border) {
					visited[rr][cc] = true;
					queue.offer(new Node(rr, cc));
				}
			}
		}
	}
}

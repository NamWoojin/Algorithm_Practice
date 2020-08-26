import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2573_빙산 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N;
	static int M;
	static int year = 0;

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		year = 0;
		calculate(map, 0);
		System.out.println(year);
	}

	private static void calculate(int[][] array, int count) {

		int[][] copyArray = new int[N][M];
		for (int i = 0; i < array.length; ++i) {
			for (int j = 0; j < array[i].length; ++j) {
				if (array[i][j] == 0) {
					copyArray[i][j] = 0;
					continue;
				}
				int num = array[i][j];
				for (int k = 0; k < 4; ++k) {
					int rr = i + dr[k];
					int cc = j + dc[k];

					if (array[rr][cc] == 0)
						--num;

					if (num <= 0)
						break;

				}
				copyArray[i][j] = num;
			}
		}

		if (bfs(copyArray)) {
			if(year == -1) {
				year = 0;
				return;
			}
			year = count + 1;
			return;
		}
		calculate(copyArray, count + 1);

	}

	private static boolean bfs(int[][] array) {
		boolean[][] isVisited = new boolean[N][M];
		boolean one = false;
		boolean allOne = true;
		for (int i = 1; i < N - 1; ++i) {
			for (int j = 1; j < M - 1; ++j) {

				if (!isVisited[i][j] && array[i][j] != 0) {
					allOne = false;
					if (one) {
						return true;
					}
					Queue<Node> queue = new LinkedList<>();
					queue.offer(new Node(i, j));
					isVisited[i][j] = true;
					while (queue.size() > 0) {
						Node n = queue.poll();

						for (int k = 0; k < 4; ++k) {
							int rr = n.r + dr[k];
							int cc = n.c + dc[k];

							if (!isVisited[rr][cc] && array[rr][cc] != 0) {
								queue.offer(new Node(rr, cc));
								isVisited[rr][cc] = true;
							}

						}
					}
					one = true;
				}
			}
		}
		if (allOne) {
			year = -1;
			return true;
		}
		return false;
	}

}

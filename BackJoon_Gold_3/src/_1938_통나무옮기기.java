import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1938_통나무옮기기 {
	// 가로 : hori = 1
	// 세로 : hori = 0
	static class Node implements Comparable<Node> {
		int r, c;
		int hori;
		int move;

		Node() {
		}

		Node(int r, int c, int hori, int move) {
			this.r = r;
			this.c = c;
			this.hori = hori;
			this.move = move;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.move - o.move;
		}

	}

	static char[][] arr;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new char[N][];
		for (int i = 0; i < N; ++i) {
			arr[i] = in.readLine().toCharArray();
		}
		// B와 E위치 찾기
		Node B = new Node();
		Node E = new Node();
		boolean findB = false;
		boolean findE = false;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!findB && arr[i][j] == 'B') {
					if (i + 1 < N && arr[i + 1][j] == 'B') {
						B = new Node(i + 1, j, 0, 0);
					} else {
						B = new Node(i, j + 1, 1, 0);
					}
					findB = true;
				} else if (!findE && arr[i][j] == 'E') {
					if (i + 1 < N && arr[i + 1][j] == 'E') {
						E = new Node(i + 1, j, 0, 0);
					} else {
						E = new Node(i, j + 1, 1, 0);
					}
					findE = true;
				}
			}
		}

		System.out.println(bfs(B, E));
	}

	private static int bfs(Node B, Node E) {
		boolean[][][] visited = new boolean[2][N][N];
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(B);
		visited[B.hori][B.r][B.c] = true;
		while (!queue.isEmpty()) {
			Node n = queue.poll();
//			System.out.println(n.r + " " + n.c + " " + n.hori);
			if (n.r == E.r && n.c == E.c && n.hori == E.hori) {
				return n.move;
			}

			// 상(U)
			if (((n.hori == 0 && n.r >= 2) || (n.hori == 1 && n.r >= 1)) && !visited[n.hori][n.r - 1][n.c]
					&& canMove(n.r, n.c, n.hori, 0)) {
				visited[n.hori][n.r - 1][n.c] = true;
				queue.offer(new Node(n.r - 1, n.c, n.hori, n.move + 1));
			}

			// 하(D)
			if (((n.hori == 0 && n.r <= N - 3) || (n.hori == 1 && n.r <= N - 2)) && !visited[n.hori][n.r + 1][n.c]
					&& canMove(n.r, n.c, n.hori, 1)) {
				visited[n.hori][n.r + 1][n.c] = true;
				queue.offer(new Node(n.r + 1, n.c, n.hori, n.move + 1));
			}

			// 좌(L)
			if (((n.hori == 0 && n.c >= 1) || (n.hori == 1 && n.c >= 2)) && !visited[n.hori][n.r][n.c - 1]
					&& canMove(n.r, n.c, n.hori, 2)) {
				visited[n.hori][n.r][n.c - 1] = true;
				queue.offer(new Node(n.r, n.c - 1, n.hori, n.move + 1));
			}

			// 우(R)
			if (((n.hori == 0 && n.c <= N - 2) || (n.hori == 1 && n.c <= N - 3)) && !visited[n.hori][n.r][n.c + 1]
					&& canMove(n.r, n.c, n.hori, 3)) {
				visited[n.hori][n.r][n.c + 1] = true;
				queue.offer(new Node(n.r, n.c + 1, n.hori, n.move + 1));
			}

			// 회전(T)
			if (!visited[n.hori == 0 ? 1 : 0][n.r][n.c] && canTurn(n.r, n.c, n.hori)) {
				visited[n.hori == 0 ? 1 : 0][n.r][n.c] = true;
				queue.offer(new Node(n.r, n.c, n.hori == 0 ? 1 : 0, n.move + 1));
			}

		}
		return 0;
	}

	private static boolean canTurn(int r, int c, int hori) {
		if (r <= 0 || c <= 0 || r >= N - 1 || c >= N - 1)
			return false;

		for (int i = r - 1; i <= r + 1; ++i) {
			for (int j = c - 1; j <= c + 1; ++j) {
				if (arr[i][j] == '1')
					return false;
			}
		}
		return true;
	}

	private static boolean canMove(int r, int c, int hori, int dir) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		if (hori == 0) {
			switch (dir) {
			case 0:
			case 1:
				return arr[r + dr[dir] * 2][c + dc[dir] * 2] != '1';

			case 2:
			case 3:
				for (int i = r - 1; i <= r + 1; ++i) {
					if (arr[i + dr[dir]][c + dc[dir]] == '1')
						return false;
				}
				return true;
			}
		} else {
			switch (dir) {
			case 2:
			case 3:
				return arr[r + dr[dir] * 2][c + dc[dir] * 2] != '1';

			case 0:
			case 1:
				for (int i = c - 1; i <= c + 1; ++i) {
					if (arr[r + dr[dir]][i + dc[dir]] == '1')
						return false;
				}
				return true;
			}
		}
		return false;
	}
}

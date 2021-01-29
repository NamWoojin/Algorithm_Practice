import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _20058_마법사상어와파이어스톰 {
	static int N, Q, size, sum, max;
	static int A[][], B[][], L[];
	static int orderRow[] = { 0, 0, 1, 1 }, orderCol[] = { 0, 1, 1, 0 };
	static int moveRow[] = { 0, 1, 0, -1 }, moveCol[] = { 1, 0, -1, 0 };
	static int dr[] = { -1, 1, 0, 0 }, dc[] = { 0, 0, -1, 1 };

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);
		A = new int[size][size];
		B = new int[size][size];
		L = new int[Q];
		for (int i = 0; i < size; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < size; ++j) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < Q; ++i) {
			L[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < Q; ++i) {
			int moveL = (int) Math.pow(2, L[i]);
			solve(2, moveL);
			reduceIce();

		}
		bfs();
		System.out.println(sum);
		System.out.println(max);

	}

	static void solve(int num, int moveL) {
		if (num > moveL) {
			return;
		}

		for (int r = 0; r < size; r += num) {
			for (int c = 0; c < size; c += num) {
				rotate(r, c, num / 2);
			}
		}

		A = B;
		B = new int[size][size];
		solve(num * 2, moveL);

	}

	static void rotate(int r, int c, int L) {
		for (int dir = 0; dir < 4; ++dir) {
			for (int i = r + orderRow[dir] * L; i < r + orderRow[dir] * L + L; ++i) {
				for (int j = c + orderCol[dir] * L; j < c + orderCol[dir] * L + L; ++j) {
//					System.out.println(i+" "+j+" "+(i+moveRow[dir]*L)+" "+(j+moveCol[dir]*L));
					B[i + moveRow[dir] * L][j + moveCol[dir] * L] = A[i][j];
				}
			}
		}
	}

	static void reduceIce() {
		int[][] check = new int[size][size];
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				if (A[i][j] == 0)
					continue;

				int iceCount = 0;
				for (int k = 0; k < 4; ++k) {
					int rr = i + dr[k];
					int cc = j + dc[k];

					if (rr < 0 || cc < 0 || rr >= size || cc >= size)
						continue;
					if (A[rr][cc] == 0)
						continue;

					++iceCount;
				}
				if (iceCount < 3)
					check[i][j] = 1;
			}
		}
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				A[i][j] -= check[i][j];
			}
		}
	}

	static void bfs() {
		boolean visited[][] = new boolean[size][size];
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				sum += A[i][j];
				if (A[i][j]!= 0 && !visited[i][j]) {
					Queue<Node> q = new LinkedList<>();
					q.add(new Node(i, j));
					visited[i][j] = true;
					int count = 0;
					while (!q.isEmpty()) {
						Node n = q.poll();
						++count;
						for (int k = 0; k < 4; ++k) {
							int rr = n.r + dr[k];
							int cc = n.c + dc[k];
							if (rr < 0 || cc < 0 || rr >= size || cc >= size)
								continue;
							if (A[rr][cc] == 0 || visited[rr][cc])
								continue;

							visited[rr][cc] = true;
							q.add(new Node(rr, cc));
						}
					}
					max = Math.max(count, max);
				}
			}
		}
	}
}

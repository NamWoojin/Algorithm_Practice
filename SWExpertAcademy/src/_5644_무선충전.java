import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5644_무선충전 {
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };

	static class BC {
		int r, c, area, power;

		public BC(int r, int c, int area, int power) {
			super();
			this.r = r;
			this.c = c;
			this.area = area;
			this.power = power;
		}

	}

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int M, A, moveA[], moveB[], map[][], max;
	static BC[] bcs;
	static Node nodeA, nodeB;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			moveA = new int[M + 1];
			moveB = new int[M + 1];
			map = new int[10][10];
			bcs = new BC[A];
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= M; ++i) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= M; ++i) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < A; ++i) {
				st = new StringTokenizer(in.readLine());
				int c = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				int area = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bcs[i] = new BC(r, c, area, p);
				for (int j = -area; j <= area; ++j) {
					for (int k = -area + Math.abs(j); k <= area - Math.abs(j); ++k) {
						int rr = r + j;
						int cc = c + k;
						if (rr < 0 || cc < 0 || rr >= 10 || cc >= 10)
							continue;
						map[rr][cc] |= (1 << i);
					}
				}
			}


			int sum = 0;
			nodeA = new Node(0, 0);
			nodeB = new Node(9, 9);
			for (int i = 0; i <= M; ++i) {
				nodeA.r += dr[moveA[i]];
				nodeA.c += dc[moveA[i]];
				nodeB.r += dr[moveB[i]];
				nodeB.c += dc[moveB[i]];

				used = new boolean[A];
				max = 0;
				findMaxA(0);
				findMaxB(0, 0);
				sum += max;
			}

			System.out.println("#" + tc + " " + sum);
		}
	}

	static boolean used[];

	private static void findMaxA(int idx) {
		if (idx == A) {
			return;
		}

		findMaxA(idx + 1);
		if ((map[nodeA.r][nodeA.c] & (1 << idx)) > 0) { // 접속 가능
			max = Math.max(max, bcs[idx].power);
			used[idx] = true;
			findMaxB(0, bcs[idx].power);
			used[idx] = false;
		}
	}

	private static void findMaxB(int idx, int powerA) {
		if (idx == A) {
			return;
		}
		findMaxB(idx + 1, powerA);
		if ((map[nodeB.r][nodeB.c] & (1 << idx)) > 0) { // 접속 가능
			if (used[idx]) {
				max = Math.max(max, powerA);
			} else {
				max = Math.max(max, powerA + bcs[idx].power);
			}
		}
	}
}

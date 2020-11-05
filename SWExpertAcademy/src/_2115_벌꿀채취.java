import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2115_벌꿀채취 {
	static int N, M, C, map[][], max;

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			max = 0;
			map = new int[N][N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			choicePlace1();
			System.out.println("#" + tc + " " + max);
		}
	}

	private static void choicePlace1() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j <= N - M; ++j) {
				choicePlace2(new Node(i, j));
			}
		}
	}

	static int max1, max2;

	private static void choicePlace2(Node one) {
		for (int j = one.c + M; j <= N - M; ++j) {
			max1 = 0;
			max2 = 0;
			calculatePlace(true, one, 0, 0, 0);
			calculatePlace(false, new Node(one.r, j), 0, 0, 0);
			max = Math.max(max, max1+max2);
		}

		for (int i = one.r + 1; i < N; ++i) {
			for (int j = 0; j <= N - M; ++j) {
				max1 = 0;
				max2 = 0;
				calculatePlace(true, one, 0, 0, 0);
				calculatePlace(false, new Node(i, j), 0, 0, 0);
				max = Math.max(max, max1+max2);
			}
		}
	}

	private static void calculatePlace(boolean one, Node n, int idx, int sum, int ans) {
		if (sum > C)
			return;
		if (idx == M) {
			if (one)
				max1 = Math.max(max1, ans);
			else
				max2 = Math.max(max2, ans);
			return;
		}

		int num = map[n.r][n.c + idx];
		calculatePlace(one, n, idx + 1, sum + num, ans + num*num);
		calculatePlace(one, n, idx + 1, sum, ans);

	}
}

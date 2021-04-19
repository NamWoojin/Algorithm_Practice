import java.io.IOException;
import java.util.Scanner;

public class _4062_LargestEmptySquare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.next());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(sc.next());
			int[][] map = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				String str = sc.next();
				for (int j = 1; j <= N; j++) {
					map[i][j] = str.charAt(j - 1) - '0';
					if (map[i][j] == 0)
						map[i][j] = 1;
					else
						map[i][j] = 0;
				}
			}

			int[][] DP = new int[N + 1][N + 1];
			int answer = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == 1) {
						DP[i][j] = Math.min(DP[i - 1][j], Math.min(DP[i][j - 1], DP[i - 1][j - 1])) + 1;
						answer = Math.max(answer, DP[i][j]);
					}
				}
			}

			System.out.print("#" + tc + " ");
			System.out.println(answer);
		}
	}

}

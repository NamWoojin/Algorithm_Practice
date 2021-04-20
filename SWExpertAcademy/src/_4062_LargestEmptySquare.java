import java.util.Scanner;

public class _4062_LargestEmptySquare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; ++tc) {
			int N = sc.nextInt();
			int[][] dp = new int[N + 1][N + 1];
			int answer = 0;
			for (int i = 1; i <= N; ++i) {
				char[] chars = sc.next().toCharArray();
				for (int j = 1; j <= N; ++j) {
					if (chars[j - 1] == '0') {
						dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
						answer = Math.max(answer, dp[i][j]);
					}

				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}

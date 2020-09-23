import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 숫자 3개, 4자리
 * dp[4][3][flag]
 * 첫째자리 1 => dp[0][1][010] = 1
 * 첫째자리 0은 안됨 => dp[0][0][001] = 0
 * 첫째자리 2 => dp[0][2][100] = 1
 * 두번째자리 0 => dp[1][0][이전것의 0자리 비트마스킹 1바꾸기]
 * dp[1][0][001] += dp[0][0][001]
 * dp[1][0][011] += dp[0][1][010]
 * dp[1][0][
 */
public class _7393_대규의팬덤활동 {
	static final int MOD = 1_000_000_000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(in.readLine());
//		for (int tc = 1; tc <= T; ++tc) {

		int N = Integer.parseInt(in.readLine());

		int[][][] dp = new int[N + 1][10][1 << 10];
		for (int i = 1; i < 10; ++i) {
			dp[1][i][1 << i] = 1;
		}
		// 각 자리수 별로
		for (int i = 2; i <= N; ++i) {
			for (int j = 0; j <= 9; ++j) {
				for (int k = 0; k < 1024; ++k) {
					// k | (1<<j)
					if (j == 0) {
						dp[i][j][k | (1 << j)] += dp[i - 1][j + 1][k];
						dp[i][j][k | (1 << j)] %= MOD;
					} else if (j == 9) {
						dp[i][j][k | (1 << j)] += dp[i - 1][j - 1][k];
						dp[i][j][k | (1 << j)] %= MOD;
					} else {
						dp[i][j][k | (1 << j)] += dp[i - 1][j + 1][k];
						dp[i][j][k | (1 << j)] %= MOD;
						dp[i][j][k | (1 << j)] += dp[i - 1][j - 1][k];
						dp[i][j][k | (1 << j)] %= MOD;
					}

					// 만약 j가 0이라면 j+1만, j가 9라면 j-1만, 둘다 아니라면 j+1,j-1에 대해서
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < 10; ++i) {
			ans += dp[N][i][1023];
			ans %= MOD;
		}
//			System.out.println("#" + tc + " " + ans);
		System.out.println(ans);

//		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1003_피보나치함수 {
	static int dp[][] = new int[41][2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(in.readLine());
			fibonacci(N);
			sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
		}
		System.out.println(sb);
	}

	private static void fibonacci(int num) {
		if (dp[num][0] == 0 && dp[num][0] == 0) {
			if (num == 0) {
				dp[num][0] = 1;
			} else if (num == 1) {
				dp[num][1] = 1;
			} else {
				fibonacci(num - 1);
				fibonacci(num - 2);
				dp[num][0] = dp[num-1][0] + dp[num-2][0];
				dp[num][1] = dp[num-1][1] + dp[num-2][1];
			}
		}
	}
}

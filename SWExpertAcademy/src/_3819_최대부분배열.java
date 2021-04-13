
import java.util.Scanner;

public class _3819_최대부분배열 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; ++tc) {
			int N = sc.nextInt();
			int[] dp = new int[N];
			dp[0] = sc.nextInt();
			int max = dp[0];
			for (int i = 1; i < N; ++i) {
						//음수 거르기.
				dp[i] = Math.max(dp[i-1], 0) + sc.nextInt();
				max = Math.max(max, dp[i]);
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}

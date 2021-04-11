import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579_계단오르기 {
	static int N,max;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		max = 0;
		dp = new int[N+1][3];
		for(int i = 1; i<=N;++i) {
			int stair = Integer.parseInt(in.readLine());
			//0 : i번째를 안밟음
			//1 : i번째를 처음 밟음
			//2 : i번째를 연속해서 밟음(i-1번째도 밟음)
			dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = dp[i-1][0] + stair;
			dp[i][2] = dp[i-1][1] + stair;
		}
		System.out.println(Math.max(dp[N][1],dp[N][2]));
	}
	
}

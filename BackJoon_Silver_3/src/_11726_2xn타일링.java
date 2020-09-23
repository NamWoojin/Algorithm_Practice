import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11726_2xn타일링 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		if(N == 1) {
			System.out.println(1);
		}
		else if(N==2) {
			System.out.println(2);
		}
		else {
			int[] dp = new int[N+1];
			dp[1] = 1;
			dp[2]  =2;
			for(int i = 3;i<N+1;++i) {
				dp[i] = dp[i-1] % 10007 +dp[i-2] % 10007;
			}
			System.out.println(dp[N]% 10007);
		}
	}
}

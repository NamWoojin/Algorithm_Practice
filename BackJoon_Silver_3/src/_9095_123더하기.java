import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095_123더하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			int N = Integer.parseInt(in.readLine());
			
			if(N==1)
				System.out.println(1);
			else if(N==2)
				System.out.println(2);
			else if(N==3)
				System.out.println(4);
			else {
				int[] dp= new int[N+1];
				dp[1] = 1;
				dp[2] = 2;
				dp[3] = 4;
				for(int i = 4;i<N+1;++i) {
					dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
				}
				System.out.println(dp[N]);
			}
			
			
		}
	}
}

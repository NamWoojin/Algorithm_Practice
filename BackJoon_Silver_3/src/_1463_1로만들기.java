import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1463_1로만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in  =new BufferedReader(new InputStreamReader(System.in));
		int N  =Integer.parseInt(in.readLine());
		
		if(N == 1)
			System.out.println(0);
		else if(N==2)
			System.out.println(1);
		else if(N==3)
			System.out.println(1);
		else {
			int[] dp = new int[N+1];
			dp[2] = 1;
			dp[3] = 1;
			for(int i = 4;i<N+1;++i) {
				int min = Integer.MAX_VALUE;
				if(i%3==0)
					min = dp[i/3]+1;
				if(i%2==0)
					min = Math.min(min, dp[i/2]+1);
				min = Math.min(min, dp[i-1]+1);
				dp[i] = min;
			}
			System.out.println(dp[N]);
		}
	}
}

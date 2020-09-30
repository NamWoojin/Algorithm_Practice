import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14501_퇴사 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int T[] = new int[N];
		int P[] = new int[N];
		int dp[] = new int[N+1];
		StringTokenizer st;
		for(int i =0;i<N;++i) {
			st = new StringTokenizer(in.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = N-1;i>=0;--i) {
			int next = i + T[i];
			if(next<=N) {
				dp[i] = P[i];
				int max = 0;
				for(int j = next;j<N;++j) {
					max = Math.max(dp[j], max);
				}
				dp[i] += max; 
				dp[i] = Math.max(dp[i], dp[i+1]);
			}else {
				dp[i] = dp[i+1];
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[0]);
	}
}

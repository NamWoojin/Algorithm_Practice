import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1149_RGB거리 {
	static int N;
	static int min;
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		arr = new int[N][3];
		dp = new int[N][3];
		for(int i =0; i<N;++i) {
			st =new StringTokenizer(in.readLine());
			for(int j = 0; j<3;++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min =1000001;
		color(1,0,arr[0][0]);
		color(1,1,arr[0][1]);
		color(1,2,arr[0][2]);
		
		System.out.println(min);
	}
	//0 : 빨강, 1: 초록, 2: 파랑
	private static void color(int n,int color,int sum) {
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		for(int i = 1; i<N;++i) {
			dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + arr[i][0];
			dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + arr[i][2];
		}
		
		min = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
		
	}
}

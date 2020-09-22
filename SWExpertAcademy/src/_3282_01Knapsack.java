import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3282_01Knapsack {
	static class thing{
		int volume;
		int price;
		thing(int volume, int price){
			this.volume = volume;
			this.price = price;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in  =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			thing things[] = new thing[N];
			for(int i = 0; i<N;++i) {
				st = new StringTokenizer(in.readLine());
				things[i] = new thing(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			int[][] dp = new int[N+1][K+1];
			for(int i = 1; i<N+1;++i) {
				for(int j = 1;j<K+1;++j) {
					if(things[i-1].volume > j)
						dp[i][j] = dp[i-1][j];
					else {
						dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-things[i-1].volume]+things[i-1].price);
					}
				}
			}
			System.out.println("#"+tc+" "+dp[N][K]);
		}
	}
}

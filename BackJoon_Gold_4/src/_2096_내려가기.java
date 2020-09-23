import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2096_내려가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][]dp_max = new int[2][3];
		int[][]dp_min = new int[2][3];
		StringTokenizer st =new StringTokenizer(in.readLine());
		for(int i = 0; i<3;++i) {
			dp_max[0][i] = Integer.parseInt(st.nextToken());
			dp_min[0][i] = dp_max[0][i];
		}
		for(int i =1; i<N;++i) {
			st =new StringTokenizer(in.readLine());
			for(int j=0;j<3;++j) {
				int max = 0;
				int min = Integer.MAX_VALUE;
				
				for(int k = -1;k<2;++k) {
					if(j+k < 0 || j+k>=3)
						continue;
					max = Math.max(max, dp_max[0][j+k]);
					min = Math.min(min, dp_min[0][j+k]);
				}
				int num  =Integer.parseInt(st.nextToken());
				dp_max[1][j] = max+num;
				dp_min[1][j] = min+num;
			}
			dp_max[0]=dp_max[1].clone();
			dp_min[0]=dp_min[1].clone();
		}
		System.out.print(Math.max(Math.max(dp_max[0][0], dp_max[0][1]),dp_max[0][2]));
		System.out.print(" ");
		System.out.print(Math.min(Math.min(dp_min[0][0], dp_min[0][1]),dp_min[0][2]));
	}
}

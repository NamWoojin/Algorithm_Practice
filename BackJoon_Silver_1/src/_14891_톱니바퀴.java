import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14891_톱니바퀴 {
	static boolean[][] magnets;
	static int[] idxs;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(in.readLine());
//		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st;
			
			magnets = new boolean[4][8];
			idxs = new int[4];

			for (int i = 0; i < 4; ++i) {
//				st = new StringTokenizer(in.readLine());
				String str = in.readLine();
				for (int j = 0; j < 8; ++j) {
//					magnets[i][j] = st.nextToken().equals("1");
					magnets[i][j] = str.charAt(j) == '1';
				}
			}
			int K = Integer.parseInt(in.readLine());
			for (int i = 0; i < K; ++i) {
				st = new StringTokenizer(in.readLine());
				int num = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				rotate(num, dir, 0);
			}
			
			int sum = 0;
			for(int i = 0 ;i<4;++i) {
				sum += magnets[i][idxs[i]]? Math.pow(2,i): 0;
			}
//			System.out.println("#"+tc+" "+sum);
			System.out.println(sum);
		}
//	}

	public static void rotate(int idx, int rotationDir, int dir) {
		
		if(dir != -1 && idx+1 <4 && magnets[idx][(idxs[idx]+2)%8] != magnets[idx+1][(idxs[idx+1]+6)%8]) {
			rotate(idx+1,rotationDir== 1 ? -1 : 1,1);
		}
		if(dir != 1 && idx-1 >=0 && magnets[idx][(idxs[idx]+6)%8] != magnets[idx-1][(idxs[idx-1]+2)%8]) {
			rotate(idx-1,rotationDir== 1 ? -1 : 1,-1);
		}
		
		idxs[idx] -= rotationDir;
		if(idxs[idx]<0)idxs[idx] = 7;
		else if(idxs[idx]>7)idxs[idx] = 0;
	}
}

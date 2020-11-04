import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _4013_특이한자석 {
	static boolean[][] magnets;
	static int[] idxs;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st;
			int K = Integer.parseInt(in.readLine());
			magnets = new boolean[4][8];
			idxs = new int[4];

			for (int i = 0; i < 4; ++i) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 8; ++j) {
					magnets[i][j] = st.nextToken().equals("1");
				}
			}

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
			System.out.println("#"+tc+" "+sum);
		}
	}
							//톱니인덱스, 회전방향,  톱니선택방향
	public static void rotate(int idx, int rotationDir, int dir) {
		// 오른쪽
		if(dir != -1 && idx+1 <4 && magnets[idx][(idxs[idx]+2)%8] != magnets[idx+1][(idxs[idx+1]+6)%8]) {
			rotate(idx+1,rotationDir== 1 ? -1 : 1,1);
		}
		//왼쪽
		if(dir != 1 && idx-1 >=0 && magnets[idx][(idxs[idx]+6)%8] != magnets[idx-1][(idxs[idx-1]+2)%8]) {
			rotate(idx-1,rotationDir== 1 ? -1 : 1,-1);
		}
		
		//회전시키기
		idxs[idx] -= rotationDir;
		if(idxs[idx]<0)idxs[idx] = 7;
		else if(idxs[idx]>7)idxs[idx] = 0;
	}
}

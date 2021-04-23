import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; ++tc) {
			N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			StringTokenizer st;
			for(int i = 0; i<N;++i) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j<N;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			DownBottom(map);
			DownRight(map);
			int bottom = 0;
			int right = 0;
			for(int i = 0; i<N;++i) {
				bottom += map[N-1][i];
				right += map[i][N-1];
			}
			System.out.println("#"+tc+" "+bottom+" "+right);
//			for(int i = 0; i<N;++i) {
//				for(int j = 0; j<N;++j) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
		}
	}
	
	private static void DownBottom(int[][] map) {
		for(int i = 0; i<N;++i) {
			if(map[0][i] > 0) {
				float nowWeight = 1;
				int count = 1;
				int j = 1;
				for(j = 1;j<N;++j) {
					if(map[j][i] >0) {
						int newWeight = 0;
						int k = j;
						while(k<N && map[k][i]>0) {
							++newWeight;
							++k;
						}
						if(nowWeight > newWeight) {
							//초과하는 하강력
							count += newWeight;
							nowWeight += newWeight;
							j = k-1;
						}
						else {
							//더이상 못 내려가는 하강력
							break;
						}
					}else {
						nowWeight *= 1.9;
					}
				}
				
				for(j -= 1;j>=0;--j) {
					if(count>0) {
						map[j][i] = 1;
						--count;
					}else {
						map[j][i] = 0;
					}
				}
			}
		}
	}
	
	private static void DownRight(int[][] map) {
		for(int i = 0; i<N;++i) {
			if(map[i][0] > 0) {
				float nowWeight = 1;
				int count = 1;
				int j = 1;
				for(j = 1;j<N;++j) {
					if(map[i][j] >0) {
						int newWeight = 0;
						int k = j;
						while(k<N && map[i][k]>0) {
							++newWeight;
							++k;
						}
						if(nowWeight > newWeight) {
							//초과하는 하강력
							count += newWeight;
							nowWeight += newWeight;
							j = k-1;
						}
						else {
							//더이상 못 내려가는 하강력
							break;
						}
					}else {
						nowWeight *= 1.9;
					}
				}
				
				for(j -= 1;j>=0;--j) {
					if(count>0) {
						map[i][j] = 1;
						--count;
					}else {
						map[i][j] = 0;
					}
				}
			}
		}
	}
}

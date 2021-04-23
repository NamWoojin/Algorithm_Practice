import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1 {
	static int map1[][], map2[][], map3[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(in.readLine());
			map1 = new int[N][N];
			map2 = new int[N][N];
			map3 = new int[N][N];
			//입력
			StringTokenizer st;
			for(int i = 0; i<N;++i) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j<N;++j) {
					map1[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i<N;++i) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j<N;++j) {
					map2[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i<N;++i) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j<N;++j) {
					map3[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int turn = 1;
			while(true) {
				
				turn = (turn+1)%3;
			}
		}
	}
	
	private static void attack(int[][] map1, int[][] map2, int turn) {
		
	}
}

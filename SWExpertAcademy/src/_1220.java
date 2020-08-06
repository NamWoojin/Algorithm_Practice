import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1220 {
	static class Position{
		int r; int c;
		public Position(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		for(int tc =1;tc<=10;++tc) {
			int N = Integer.parseInt(in.readLine());
			int[][] table = new int[N][N];
			for(int i = 0; i<N;++i) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j<N;++j) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count =0;
			for(int j = 0; j<100;++j) {
				int prev = 0;
				for(int i = 0; i<100;++i) {
					if(table[i][j] != 0) {
						if(prev == 1 && table[i][j] == 2) {
							++count;
						}
						prev = table[i][j];
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(count);
			
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
	
}

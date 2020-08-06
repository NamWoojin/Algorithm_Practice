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
		for(int tc =1;tc<=10;++tc) {
			int N = Integer.parseInt(in.readLine());
			char[][] table = new char[N][N];
			for(int i = 0; i<N;++i) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j<N;++j) {
					table[i][j] = st.nextToken().charAt(0);
				}
			}
			
			for(int j = 0; j<100;++j) {
				for(int i = 0; i<100;++i) {
					
				}
			}
		}
	}
	
}

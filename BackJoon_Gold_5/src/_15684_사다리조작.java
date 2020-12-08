import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15684_사다리조작 {
	static int N,M,H,ladders[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ladders = new int[H+1][N+1];
		
		for(int i = 0; i< M;++i) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladders[a][b] = 1;
			ladders[a][b+1] = -1;
		}
		
		int lines = -1;
		for(lines = 0; lines<=3;++lines) {
			if(powerSet(1,0,lines))
				break;
		}
		System.out.println(lines>3?-1:lines);
	}
	
	static boolean powerSet(int x,int count,int lines) {
		if(count == lines) {
			return solve();
		}
		for(int i = x; i <= H;++i) {
			for(int j = 1; j<N;++j) {
			if(ladders[i][j] != 0 || ladders[i][j+1] != 0)
				continue;
			
			ladders[i][j] = 1;
			ladders[i][j+1] = -1;
			if(powerSet(i,count+1,lines))
				return true;
			ladders[i][j] = 0;
			ladders[i][j+1] = 0;
			}
		}
		return false;
	}
	
	static boolean solve() {
		for(int i = 1; i<=N;++i) {
			int Hidx = 1;
			int Nidx = i;
			while(Hidx <= H) {
				Nidx += ladders[Hidx][Nidx];
				++Hidx;
			}
			if(i != Nidx)
				return false;
		}
		return true;
	}
}

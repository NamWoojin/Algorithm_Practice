import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1010_다리놓기 {
	static int[][] comb = new int[31][31];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T  = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			System.out.println(nCm(M,N));
		}
	}
	
	private static int nCm(int n,int m) {
		if(n==m || m == 0)
			return 1;
		if(comb[n][m] != 0) return comb[n][m];
		return comb[n][m] = nCm(n-1,m-1) + nCm(n-1,m);
	}
	
}

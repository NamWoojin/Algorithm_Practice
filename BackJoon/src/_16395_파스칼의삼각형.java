import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16395_파스칼의삼각형 {
	static int[][] comb = new int[31][31];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		System.out.println(nCr(N-1,K-1));
	}
	
	private static int nCr(int n, int r) {
		if(n==r || r == 0) {
			return 1;
		}
		if(comb[n][r] != 0) return comb[n][r];
		return comb[n][r] = nCr(n-1,r)+nCr(n-1,r-1);
		
	}
}

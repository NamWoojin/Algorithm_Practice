import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11403_경로찾기 {
	static boolean[][] arr;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new boolean[N][N];
		StringTokenizer st;
		for(int i = 0; i<N;++i) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<N;++j) {
				arr[i][j] = st.nextToken().equals("1");
			}
		}
		
	}
	
	private static void dfs(int r) {
		
		for(int i =0; i<N;++i) {
			if(arr[r][i]) {
				dfs(i);
			}
		}
	}
}

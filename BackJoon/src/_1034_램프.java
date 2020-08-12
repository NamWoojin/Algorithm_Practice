import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class _1034_램프 {
	static int N;
	static int M;
	static int K;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; ++i) {
			String str = in.readLine();
			for (int j = 0; j < M; ++j) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		min = N*M;
		K = Integer.parseInt(st.nextToken());
		
		bfs(0,arr);
	}
	
	private static void bfs(int k,int[][] arr) {
		if(k == K) {
			int count = 0;
			for(int i = 0; i<N;++i) {
				int num = 0;
				for(int j = 0; j<M;++j) {
					num += arr[i][j];
				}
				if(num == M)
					++count;
			}
			min = Math.min(count, min);
		}
		for(int i = 0; i<M;++i) {
			for(int j =0; j<N;++j) {
				
			}
		}
	}

}

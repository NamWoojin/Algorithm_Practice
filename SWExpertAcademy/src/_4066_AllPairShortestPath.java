import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4066_AllPairShortestPath {
	static int N, M, matrix[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			matrix = new int[N + 1][N + 1];
			for(int i = 1; i<=N;++i) {
				for(int j = 1; j<=N;++j) {
					matrix[i][j] = 60000000;
				}
			}
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				matrix[a][b] = c;
				matrix[b][a] = c;
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 1; i <= N; ++i) {
				sb.append(Daijkstra(i));
			}
		}
	}
	
	private static String Daijkstra(int start) {
		StringBuilder sb = new StringBuilder();
		int[] daijk = new int[N+1];
		boolean[] visited = new boolean[N+1];
		for(int i = 1; i <= N;++i) {
			daijk[i] = 60000000;
		}
		daijk[start] = 0;
		
		return sb.toString();
	}
}

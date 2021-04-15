import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3947_가장짧은길전부청소하기 {
	private static int[][] arr;
	private static int N, dist[];
	private static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			dist = new int[N];
			for (int i = 1; i < N; ++i) {
				dist[i] = Integer.MAX_VALUE;
			}
			visited = new boolean[N];
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(in.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				arr[n1 - 1][n2 - 1] = w;
				arr[n2 - 1][n1 - 1] = w;
			}
			visited[0] = true;
			dist[0] = 0;
			int next = 0;
			int max = 1;
			int queue[] = new int[N];
		
			
			while(next != N || next == max) {
				int idx = queue[next++];
				for (int i = 0; i < N; ++i) {
					if (arr[idx][i] != 0) {
						// 현재 위치에서 갈 수 있는 노드이면
						dist[i] = Math.min(dist[i], arr[idx][i]);
					}
				}
			}
			
			calculateDist(0);
			int sum = 0;
			for(int i = 0; i<N;++i) {
				sum += dist[i];
			}
			System.out.println(sum);
		}
	}
	
	

	private static void calculateDist(int idx) {
		for (int i = 0; i < N; ++i) {
			if (arr[idx][i] != 0 && dist[i] != Integer.MIN_VALUE) {
				// 현재 위치에서 갈 수 있는 노드이면
				dist[i] = Math.min(dist[i], arr[idx][i]);
			}
		}
		visited[idx] = true;
		for (int i = 0; i < N; ++i) {
			if (!visited[i] && arr[idx][i] != 0) {
				// 다음 노드가 방문하지 않은 노드이면서, 현재 위치에서 갈 수 있는 노드이면
				calculateDist(i);
			}
		}
	}
}

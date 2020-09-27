import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1520_내리막길 {
	static int N, M, arr[][];
	static int visited[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0, 0));

	}

	private static int dfs(int r, int c) {
		if (r == N - 1 && c == M - 1) {
			return 1;
		}

		if (visited[r][c] == -1) {
			visited[r][c] = 0;
			for (int i = 0; i < 4; ++i) {
				int rr = r + dr[i];
				int cc = c + dc[i];

				if (rr < 0 || cc < 0 || rr > N - 1 || cc > M - 1)
					continue;

				if (arr[r][c] > arr[rr][cc]) {
					visited[r][c] += dfs(rr, cc);

				}
			}
		}
		return visited[r][c];
	}
}

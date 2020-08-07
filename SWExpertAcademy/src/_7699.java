import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7699 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[] visited;
	static char[][] map;
	static int R,C;
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			visited = new boolean[26];
			map = new char[R][C];
			max =0;
			for (int i = 0; i < R; ++i) {
				map[i] = in.readLine().toCharArray();
			}
			visited[map[0][0]-'A'] = true;
			dfs(0, 0,1);
			sb.append("#").append(tc).append(" ").append(max);
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}

	private static void dfs(int r, int c,int count) {
		int cant = 0;
		
		for (int i = 0; i < 4; ++i) {
			int rr = r + dr[i];
			int cc = c + dc[i];
			if (rr < 0 || cc < 0 || rr >= R || cc >= C) {
				++cant;
				continue;
			}

			if (!visited[map[rr][cc] - 'A']) {
				visited[map[rr][cc] - 'A'] = true;
				dfs(rr, cc,count+1);
				visited[map[rr][cc] - 'A'] = false;
			} else {
				++cant;
			}
		}
		if (cant == 4) {
			max = count > max ? count: max;
			return;
		}
		return;

	}
}

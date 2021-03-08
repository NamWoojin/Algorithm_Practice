import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11404_플로이드 {
	static int n, m;
	static int[][] values;
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();
	static final int INF = 987654321;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		m = Integer.parseInt(in.readLine());
		values = new int[n + 1][n + 1];
		for (int i = 1; i <= n; ++i) {
			Arrays.fill(values[i], INF);
			values[i][i] = 0;
		}
		StringTokenizer st;
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			values[a][b] = Math.min(c, values[a][b]);
		}

		for (int i = 1; i <= n; ++i) { // i를 거치는 경우
			for (int j = 1; j <= n; ++j) { // 시작
				for (int k = 1; k <= n; ++k) { // 끝
					values[j][k] = Math.min(values[j][k], values[j][i] + values[i][k]);
				}
			}
		}
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (j == i)
					sb.append("0 ");
				else
					sb.append(values[i][j] + " ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}

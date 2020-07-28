import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer result = new StringBuffer();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] array = new int[N][N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; ++j) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = 0;
			for (int i = 0; i <= N - M; ++i) {
				for (int l = 0; l <= N - M; ++l) {
					int num = 0;
					for (int j = 0; j < M; ++j)
						for (int k = 0; k < M; ++k)
							num += array[j + i][k + l];

					if (num > max)
						max = num;
				}
			}

			result.append("#").append(tc).append(" ").append(max);
			System.out.println(result);
			result.setLength(0);
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[N][M];
		for (int i = 0; i < N; ++i) {
			String str = in.readLine();
			for (int j = 0; j < M; ++j) {
				arr[i][j] = str.charAt(j) == 'W' ? true : false;
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N - 8 + 1; ++i) {
			for (int j = 0; j < M - 8 + 1; ++j) {
				int cnt = 0;
				out1:for (int k = 0; k < 8; ++k) {
					for (int l = 0; l < 8; ++l) {
						if (((k + l) % 2 == 0 && !arr[i + k][j + l]) || ((k + l) % 2 == 1 && arr[i + k][j + l]))
							++cnt;
						if(cnt > min)
							break out1;
					}
				}
				min = Math.min(cnt, min);
				cnt = 0;
				out2:for (int k = 0; k < 8; ++k) {
					for (int l = 0; l < 8; ++l) {
						if (((k + l) % 2 == 0 && arr[i + k][j + l]) || ((k + l) % 2 == 1 && !arr[i + k][j + l]))
							++cnt;
						if(cnt>min)
							break out2;
					}
				}
				min = Math.min(cnt, min);
			}
		}
		System.out.println(min);
	}
}

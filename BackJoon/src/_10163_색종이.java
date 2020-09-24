import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10163_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] arr = new int[102][102];
		StringTokenizer st;
		for (int k = 1; k < N + 1; ++k) {
			st = new StringTokenizer(in.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + h; ++i) {
				for (int j = y; j < y + w; ++j) {
					arr[i][j] = k;
				}
			}
		}
		int[] count = new int[N + 1];
		for (int i = 0; i < 102; ++i) {
			for (int j = 0; j < 102; ++j) {
				++count[arr[i][j]];
			}
		}
		for (int i = 1; i < N + 1; ++i) {
			System.out.println(count[i]);
		}
	}
}

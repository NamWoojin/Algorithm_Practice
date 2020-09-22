import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(in.readLine());
		boolean[][] board = new boolean[100][100];
		StringTokenizer st;
		int count = 0;
		for (int i = 0; i < cnt; ++i) {
			st = new StringTokenizer(in.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			r = 100-r-10;
			for (int j = r; j <r+10; ++j) {
				for (int k = c; k < c + 10; ++k) {
					if (!board[j][k]) {
						++count;
						board[j][k] = true;
					}
				}
			}
		}
		System.out.println(count);
	}
}

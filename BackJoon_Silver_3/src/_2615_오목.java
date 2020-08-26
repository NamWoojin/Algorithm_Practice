import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2615_오목 {
	static int[] dr = { 1, -1, 0, 1};
	static int[] dc = { 0, 1, 1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader in  =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = 19;
		int[][] board = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean endFlag = false;
		out:for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (board[i][j] != 0) {
					int color = board[i][j];
					for (int k = 0; k < 4; ++k) {
						int r = i + dr[k];
						int c = j + dc[k];
						if (r < 0 || c < 0 || r >= N || c >= N)
							continue;
						if (board[r][c] == color) {
							int count = 2;
							for (int l = 0; l < 4; ++l) {
								r += dr[k];
								c += dc[k];
								if (!(r < 0 || c < 0 || r >= N || c >= N)) {
									if (board[r][c] != color)
										break;
									else {
										++count;
									}
								}
								else
									break;
							}
							if (count == 5) {
								int reR = i - dr[k];
								int reC = j - dc[k];

								if(!(reR < 0 || reC < 0 || reR >= N || reC >= N) && board[i - dr[k]][j - dc[k]] == color)
									continue;
								
								System.out.println(color);
								System.out.println((i + 1) + " " + (j + 1));
								endFlag = true;
								break out;

							}
						}
					}
				}
			}

		}
		if (!endFlag) {
			System.out.println(0);
		}
	}

}

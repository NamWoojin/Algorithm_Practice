import java.util.Scanner;

public class Solution {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer result = new StringBuffer();
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; ++tc) {
			int N = sc.nextInt();
			int[][] array = new int[N][N];
			int num = 1;
			for (int i = 0; i < N; i++) {
				array[0][i] = num;
				++num;
			}
			if (N != 1) {
				int K = N - 1;
				int dirNum = 1;
				int r = 0;
				int c = N - 1;
				boolean flag = false;
				while (!flag) {
					for (int i = 0; i < 2; ++i) {
						for (int j = 0; j < K; ++j) {
							r = r + dr[dirNum % 4];
							c = c + dc[dirNum % 4];
							array[r][c] = num++;
							if (num > N * N) {
								flag = true;
								break;
							}
						}
						if (flag)
							break;
						++dirNum;
					}
					--K;
				}
			}

			result.append("#");
			result.append(tc);
			System.out.println(result);
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j)
					System.out.print(array[i][j] + " ");
				System.out.println();
			}
			result.setLength(0);
		}
		sc.close();
	}

}

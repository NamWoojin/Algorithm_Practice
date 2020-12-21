import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1080_행렬 {
	static int N, M, min = Integer.MAX_VALUE;
	static char[][] A, B;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new char[N][];
		B = new char[N][];
		for (int i = 0; i < N; ++i) {
			A[i] = in.readLine().toCharArray();
		}
		for (int i = 0; i < N; ++i) {
			B[i] = in.readLine().toCharArray();
		}
		check = new boolean[N][M];

		for (int i = 0; i < N; ++i) { // 두 배열 비교. 다르면 True
			for (int j = 0; j < M; ++j) {
				check[i][j] = A[i][j] != B[i][j];
			}
		}
		int count = 0;
		if (N < 3 || M < 3) {
			out: for (int i = 0; i < N; ++i) { // 두 배열 비교. 다르면 True
				for (int j = 0; j < M; ++j) {
					if (check[i][j]) {
						count = -1;
						break out;
					}

				}
			}
			System.out.println(count);
		} else {

			out: for (int i = 0; i <= N - 3; ++i) {
				for (int j = 0; j <= M - 3; ++j) {
					if (check[i][j]) {
						++count;
						change(i, j);
					}

					if (i == N - 3) { // 아래쪽 남은 끝 2칸 확인
						if (check[i + 1][j] || check[i + 2][j]) {
							count = -1;
							break out;
						}
					}
					if (j == M - 3) { // 오른쪽 남은 끝 2칸 확인
						if (check[i][j + 1] || check[i][j + 2]) {
							count = -1;
							break out;
						}
					}
				}
			}

			if (check[N - 2][M - 2] || check[N - 1][M - 2] || check[N - 2][M - 1] || check[N - 1][M - 1])
				count = -1;

			System.out.println(count);
		}
	}

	static void change(int i, int j) {
		for (int r = i; r < i + 3; ++r) {
			for (int c = j; c < j + 3; ++c) {
				check[r][c] = !check[r][c];
			}
		}
	}

}

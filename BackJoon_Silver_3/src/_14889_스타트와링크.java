import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14889_스타트와링크 {
	static int N;
	static int min;
	static int[][] array;
	static int[] choice;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(in.readLine());
//		for (int tc = 1; tc <= 10; ++tc) {
			N = Integer.parseInt(in.readLine());
			array = new int[N][N];
			choice = new int[N];
			StringTokenizer st;
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; ++j) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min =Integer.MAX_VALUE;
			choiceA(0, 0);
			StringBuilder sb = new StringBuilder();
//			sb.append("#").append(tc).append(" ").append(min);
			sb.append(min);
			System.out.println(sb.toString());
//		}
	}

	private static void choiceA(int idx, int c_idx) {
		if (c_idx == N / 2) {
			compare();
			return;
		}
		if (idx == N)
			return;

		choiceA(idx + 1, c_idx);
		choice[idx] = 1;
		choiceA(idx + 1, c_idx + 1);
		choice[idx] = 0;
	}

	private static void compare() {
		int sumA = 0, sumB = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if(i == j)
					continue;
				
				if (choice[i] == choice[j]) {
					if (choice[i] == 1)
						sumA += array[i][j];
					else
						sumB += array[i][j];

				}
			}

		}

		min = min > Math.abs(sumA - sumB) ? Math.abs(sumA - sumB) : min;
		return;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3814_평등주의 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int minNum = 0;
			int maxNum = (int) Math.pow(10, 9);
			while (true) {
				int num = (minNum + maxNum) / 2;
				if (ParametricSearch(num, arr.clone(), K)) {
					maxNum = num;
				} else {
					minNum = num + 1;
				}

				if (minNum == maxNum) {
					break;
				}
			}
			System.out.println("#" + tc + " " + minNum);
		}
	}

	private static boolean ParametricSearch(int num, int[] arr, int K) {
		int count = 0;
		for (int i = 0; i < arr.length - 1; ++i) {
			int gap = arr[i + 1] - arr[i];
			if ( gap > num) {
				count += (gap - num);
				arr[i + 1] -= (gap - num);

			}
		}

		for (int i = arr.length - 1; i > 0; --i) {
			int gap = arr[i - 1] - arr[i];
			if (gap > num) {
				count += (gap - num);
				arr[i +-1] -= (gap - num);
			}
		}

		if (count > K) {
			return false;
		}
		return true;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5585_거스름돈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[] { 500, 100, 50, 10, 5, 1 };
		int K = 1000 - N;
		int count = 0;
		for (int i = 0; i <= 6; ++i) {
			if (arr[i] <= K) {
				while (K >= arr[i]) {
					++count;
					K -= arr[i];
				}
			}
			if (K == 0)
				break;
		}
		System.out.println(count);
	}
}

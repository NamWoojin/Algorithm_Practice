import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11047_동전0 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(arr);
		int count = 0;
		for (int i = N-1; i >=0; --i) {
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

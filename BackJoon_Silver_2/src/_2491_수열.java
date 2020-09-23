import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2491_수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		int[][] cal = new int[N][2];
		for (int i = 1; i < N; ++i) {
			if (arr[i - 1] < arr[i])
				cal[i][0] = cal[i - 1][0] + 1;
			else if (arr[i - 1] == arr[i]) {
				cal[i][0] = cal[i - 1][0] + 1;
				cal[i][1] = cal[i - 1][1] + 1;
			} else
				cal[i][1] = cal[i - 1][1] + 1;
			
			max = Math.max(Math.max(cal[i][0], cal[i][1]),max);
		}

		System.out.println(max+1);
	}
}

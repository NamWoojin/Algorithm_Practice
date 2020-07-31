import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15649 {
	static int N = 0;
	static int M = 0;
	static boolean[] isUsed;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isUsed = new boolean[N];
		arr = new int[M];
		perm(0);
	}

	private static void perm(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; ++i) {
				System.out.print(arr[i]);
				System.out.print(" ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; ++i) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				arr[idx] = i+1;
				perm(idx + 1);
				isUsed[i] = false;
			}
		}
	}

}

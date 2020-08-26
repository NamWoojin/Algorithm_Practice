import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10972_다음순열 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if (!nextPermutation(arr))
			System.out.println("-1");
		else
			for (int i = 0; i < N; ++i)
				System.out.print(arr[i] + " ");
	}

	private static boolean nextPermutation(int[] arr) {
		int i = N - 1;
		while (i>0&&arr[i - 1] >= arr[i]) --i;
		if (i == 0)return false;
		

		int j = N - 1;
		while (arr[i - 1] >= arr[j]) 
			--j;
		

		swap(arr, i - 1, j);

		int k = N - 1;
		while (i<k) {
			swap(arr, i++, k--);
			
		}

		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		arr[i] ^= arr[j];
		arr[j] ^= arr[i];
		arr[i] ^= arr[j];
	}
}


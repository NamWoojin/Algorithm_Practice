import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1859 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N];
			int money = 0;
			int count = 0;
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i <= N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (i == N) {
					if (count != 0) {
						money += arr[i] * count;
						count = 0;
					}
				} else {
					if (arr[i] <= arr[i + 1]) {
						money -= arr[i];
						++count;

					} else {
						if (count != 0) {
							money += arr[i] * count;
							count = 0;
						}
					}
				}
			}

			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(money);
		}

	}

}

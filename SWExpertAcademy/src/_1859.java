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
			long max = 0;
			long money = 0;
			int count = 0;
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i =0 ; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = N-1;i>=0;--i) {
				if(arr[i] > max) {
					if(count != 0) {
						money += max*count;
					}
					max = arr[i];
					count = 0;
				}
				else {
					money -= arr[i];
					++count;
				}
			}
			if(count != 0) {
				money += max*count;
			}

			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(money);
		}

	}

}

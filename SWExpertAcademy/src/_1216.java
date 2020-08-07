import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1216 {
	private static char[][] arr;
	private static int N;
	private static int S = 100;
	private static int num = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		for (int tc = 1; tc <= 10; ++tc) {
			arr = new char[S][S];
			N = Integer.parseInt(in.readLine());
			for (int i = 0; i < S; ++i)
				arr[i] = new StringTokenizer(in.readLine()).nextToken().toCharArray();
			
			num = -1;
			out:for (int k = S; k != 0; --k) {
				for (int i = 0; i < S; ++i) {
					for (int j = 0; j < S - k + 1; ++j) {
						palindrome(0, i, j,k, true);
						palindrome(0, i, j,k, false);
						if(num != -1) {
							break out;
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(num);
			out.write(sb.toString());
			out.newLine();
			out.flush();
			sb.setLength(0);
		}
	}

	private static void palindrome(int idx, int standard, int startIdx,int N, boolean horizontal) {
		if (idx == N / 2) {
			num = N;
			return;
		}

		if (horizontal && arr[standard][startIdx + idx] == arr[standard][startIdx + N - 1 - idx]
				|| !horizontal && arr[startIdx + idx][standard] == arr[startIdx + N - 1 - idx][standard]) {
			palindrome(idx + 1, standard, startIdx,N, horizontal);
		} else {
			return;
		}
	}

}

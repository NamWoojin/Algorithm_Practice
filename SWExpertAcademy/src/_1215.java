import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1215 {
	private static char[][] arr;
	private static int count;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		for (int tc = 1; tc <= 10; ++tc) {
			arr = new char[8][8];
			count = 0;
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 8; ++i)
				arr[i] = new StringTokenizer(in.readLine()).nextToken().toCharArray();

			for (int i = 0; i < 8; ++i) {
				for (int j = 0; j <= 8 - N; ++j) {
					palindrome(0, i, j, true);
					palindrome(0, i, j, false);
				}
			}
			sb.append("#").append(tc).append(" ").append(count);
			out.write(sb.toString());
			out.newLine();
			out.flush();
			sb.setLength(0);
		}
	}

	private static void palindrome(int idx, int standard, int startIdx, boolean horizontal) {
		if (idx == N/2) {
			++count;
			return;
		}

		if (horizontal && arr[standard][startIdx + idx] == arr[standard][startIdx + N - idx] ||
				!horizontal && arr[startIdx + idx][standard] == arr[startIdx + N - idx][standard]) {
			palindrome(idx+1,standard,startIdx,horizontal);
		}
	}

}

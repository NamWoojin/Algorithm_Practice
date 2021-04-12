import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3816_아나그램 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			char[] s1 = st.nextToken().toCharArray();
			char[] s2 = st.nextToken().toCharArray();
			int[] arr1 = new int[26];
			int[] arr2 = new int[26];
			int answer = 0;
			for (int i = 0; i < s1.length; ++i) {
				++arr1[s1[i] - 'a'];
				++arr2[s2[i] - 'a'];
			}

			for (int i = s1.length; i <= s2.length; ++i) {
				answer += CheckEqual(arr1, arr2);
				if(i == s2.length)
					break;
				--arr2[s2[i - s1.length] - 'a'];
				++arr2[s2[i] - 'a'];
			}
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static int CheckEqual(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; ++i) {
			if (arr1[i] != arr2[i]) {
				return 0;
			}
		}
		return 1;
	}
}

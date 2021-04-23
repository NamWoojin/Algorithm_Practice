import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9251_LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] s1 = in.readLine().toCharArray();
		char[] s2 = in.readLine().toCharArray();
		int[][] lcs = new int[s1.length+1][s2.length+1];
		for(int i = 1; i<= s1.length;++i) {
			for(int j = 1; j<=s2.length;++j) {
				if(s1[i-1] == s2[j-1]) {
					//이번 문자가 같을 경우, 이전 경우의 수 +1
					lcs[i][j] = lcs[i-1][j-1]+1;
				}
				else {
					//이번 문자가 다를 경우, s1수열의 이전값과 s2수열의 이전 값 비교
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		System.out.println(lcs[s1.length][s2.length]);
	}
}

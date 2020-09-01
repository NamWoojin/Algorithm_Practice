import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _1786_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str1 = in.readLine();
		String str2 = in.readLine();
		int[] fail = new int[str2.length()];

		int i = 1;
		int j = 0;

		for(i =1; i<str2.length();++i) {
			while(j>0 && str2.charAt(i) != str2.charAt(j))	//j가 i와 맞을 때까지 반복
				j = fail[j - 1];
			if(str2.charAt(i) == str2.charAt(j)){
				fail[i] = ++j;
			}
		}
//		System.out.println(Arrays.toString(fail));

		j = 0;
		int count = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		for (i = 0; i < str1.length(); ++i) {
			while(j>0 && str1.charAt(i) != str2.charAt(j))
				j = fail[j - 1];
			if(str1.charAt(i) == str2.charAt(j))
				++j;

			if (j == str2.length()) {
				++count;
				ans.add(i - str2.length() + 2);	//i+1, 길이+1 => 2
				j = fail[--j];
			}
		}

		System.out.println(count);
		for (int k = 0; k < ans.size(); ++k) {
			System.out.print(ans.get(k));
			System.out.print(" ");
		}
//		System.out.println(i);
	}
}

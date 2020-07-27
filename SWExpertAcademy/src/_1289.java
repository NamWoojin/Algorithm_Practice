import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1289 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer result = new StringBuffer();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<= T;++tc) {
			char[] num = in.readLine().toCharArray();
			char number  = '0';
			int count = 0;
			for(int i =0; i<num.length; ++i) {
				if(num[i] != number) {
					++count;
					number= num[i];
				}
			}
			result.append("#").append(tc).append(" ").append(count);
			System.out.println(result);
			result.setLength(0);
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _1223 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for (int tc = 1; tc <= 10; ++tc) {
			ArrayList<Character> arr = new ArrayList<>();
			in.readLine();
			String str = in.readLine();
			for(int i = 0; i< str.length();++i) {
				arr.add(str.charAt(i));
			}
			
			for(int i = 0; i<arr.size();++i) {
				if(arr.get(i) == '*') {
					arr.set(i, (char)(((arr.get(i-1)-'0') *(arr.get(i+1)-'0'))+'0' )); 
				}
			}
		}
	}
}

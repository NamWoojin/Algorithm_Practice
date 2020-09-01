import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2902_KMP는왜KMP일까 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str =in.readLine();
		
		StringBuffer out = new StringBuffer();
		for(int i =0; i<str.length();++i) {
			if(Character.isUpperCase(str.charAt(i)))
				out.append(str.charAt(i));
			
		}
		System.out.println(out.toString());
	}
}

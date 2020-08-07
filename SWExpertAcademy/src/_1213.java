import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb=  new StringBuffer();
		for(int tc =1;tc<= 10;++tc) {
			in.readLine();
			String search = in.readLine();
			String sentence = in.readLine();
			int count = 0;
			for(int i = 0; i<sentence.length()-search.length()+1;++i) {
				if(search.equals(sentence.substring(i,i+search.length()))) {
					++count;
				}
			}
			sb.append("#").append(tc).append(" ").append(count);
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
}

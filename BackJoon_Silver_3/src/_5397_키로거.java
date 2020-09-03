import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _5397_키로거 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T;++tc) {
			char[] chars = in.readLine().toCharArray();
			ArrayList<Character> array = new ArrayList<>();
			int cursor = 0;
			for (int i = 0; i <chars.length; ++i) {
				switch(chars[i]) {
				case '-':
					if(cursor >0)
						array.remove(--cursor);
					break;
				case '<':
					if(cursor>0)
						--cursor;
					break;
				case '>':
					if(cursor<array.size())
						++cursor;
					break;
				default:
					array.add(cursor++,chars[i]);
					break;
				}
				
			}
			
			for(char c : array)
				sb.append(c);
			
			out.write(sb.toString());
			sb.setLength(0);
			out.flush();
		}
		out.close();
	}
}

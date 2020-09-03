import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class _5397_키로거_덱 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T;++tc) {
			char[] chars = in.readLine().toCharArray();
			Deque<Character> preDeque = new ArrayDeque<>();
			Deque<Character> postDeque = new ArrayDeque<>();
			
			for (int i = 0; i < chars.length; i++) {
				switch(chars[i]) {
				case '-':
					if(!preDeque.isEmpty())
						preDeque.pollLast();
					break;
				case '<':
					if(!preDeque.isEmpty())
						postDeque.addFirst(preDeque.pollLast());
					break;
				case '>':
					if(!postDeque.isEmpty())
						preDeque.addLast(postDeque.pollFirst());
					break;
				default:
					preDeque.add(chars[i]);
					break;
				}
			}
			
			while(!preDeque.isEmpty())
				sb.append(preDeque.removeFirst());
			while(!postDeque.isEmpty())
				sb.append(postDeque.removeFirst());
			
			out.write(sb.toString());
			out.newLine();
			out.flush();
			sb.setLength(0);
		}
		out.close();
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class _1223 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for (int tc = 1; tc <= 10; ++tc) {
			Stack<Integer> stack = new Stack<>();
			
			in.readLine();
			String str = in.readLine();
			for(int i = 0; i< str.length();++i) {
				switch(str.charAt(i)) {
				case '*':
					stack.push(stack.pop() * (str.charAt(++i)-'0'));
					break;
				case '+':
					break;
				default:
					stack.push(str.charAt(i) - '0');
					break;
				}
			}
			int sum = 0;
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}
			sb.append("#").append(tc).append(" ").append(sum);
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class _1224 {
	static int idx = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for (int tc = 1; tc <= 10; ++tc) {
			in.readLine();
			String str = in.readLine();
			int sum = 0;
			idx = 0;
			sum = calculate(str);
			
			
			
			sb.append("#").append(tc).append(" ").append(sum);
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
	
	private static int calculate(String str) {
		Stack<Integer> stack = new Stack<>();
		out:for( ;idx< str.length();++idx) {
			switch(str.charAt(idx)) {
			case '(':
				++idx;
				stack.push(calculate(str));
				break;
			case ')':
				break out;
			case '*':
				int ans = 0;
				if(str.charAt(++idx) == '(') {
					++idx;
					ans= calculate(str);
				}
				else {
					ans = str.charAt(idx)-'0';
				}
				stack.push(stack.pop() * ans);
				break;
			case '+':
				break;
			default:
				stack.push(str.charAt(idx) - '0');
				break;
			}
		}
		
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;
	}
}

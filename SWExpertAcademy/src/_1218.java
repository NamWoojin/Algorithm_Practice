import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1218 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		for(int tc = 1; tc<= 10; ++tc) {
			int N = Integer.parseInt(in.readLine());
			Stack<Character> stack = new Stack<>();
			String str = in.readLine();
			sb.append("#").append(tc).append(" ");
			boolean flag = true;
			out:for(int i =0; i<N;++i) {
				if(str.charAt(i) == '('||str.charAt(i) == '['||str.charAt(i) == '{'||str.charAt(i) == '<')
					stack.push(str.charAt(i));
				else {
					switch(str.charAt(i)) {
					case ')':
						if(stack.peek()!='(') {
							flag =false;
							break out;
						}
						break;
					case ']':
						if(stack.peek()!='[') {
							flag =false;
							break out;
						}
						break;
					case '}':
						if(stack.peek()!='{') {
							flag =false;
							break out;
						}
						break;
					case '>':
						if(stack.peek()!='<') {
							flag =false;
							break out;
						}
						break;
					}
					stack.pop();
				}
			}
			
			if(!stack.isEmpty())
				flag = false;
			
			if(flag)
				sb.append(1);
			else
				sb.append(0);
			
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
}

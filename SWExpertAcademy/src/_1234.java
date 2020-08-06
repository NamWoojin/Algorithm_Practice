import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _1234 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb =new StringBuffer();
		for(int tc = 1;tc<=10;++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			String str = st.nextToken();
			Stack<Integer> leftStack = new Stack<>();
			Stack<Integer> rightStack = new Stack<>();
			for(int i = 0; i<N;++i) {
				leftStack.add(Integer.parseInt(str.substring(i,i+1)));
			}
			
			while(true) {
				rightStack.add(leftStack.pop());
				
				while(!leftStack.isEmpty()&& !rightStack.isEmpty() && leftStack.peek() == rightStack.peek()) {
					leftStack.pop();
					rightStack.pop();
				}
				if(leftStack.isEmpty()) break;
				
			}
			sb.append("#").append(tc).append(" ");
			while(!rightStack.isEmpty()) {
				sb.append(rightStack.pop());
			}
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
}

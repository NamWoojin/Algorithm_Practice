import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1094_막대기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<>();
		stack.push(64);
		int sum = 64;
		while(sum != X) {
			int num = stack.pop();
			stack.push(num/2);
			stack.push(num/2);
			if(sum-stack.peek() >=X ) {
				int small = stack.pop();
				sum -= small;
			}
		}
		System.out.println(stack.size());
	}
}

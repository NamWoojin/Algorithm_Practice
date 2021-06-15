import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1874_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<>();
		int arr[] = new int[N];
		for (int i = 1; i <= N; ++i) {
			arr[i - 1] = Integer.parseInt(in.readLine());
		}
		int index = 0;
		int num = 1;
		StringBuilder sb = new StringBuilder();
		for (num = 1; num <= N; ++num) {
			stack.add(num);
			sb.append("+\n");
			while (index < arr.length && !stack.isEmpty()&& arr[index] == stack.peek()) {
				stack.pop();
				sb.append("-\n");
				++index;
			}
		}
		if(index == arr.length && num == N+1) {
			System.out.println(sb);			
		}else {
			System.out.println("NO");
		}
	}
}

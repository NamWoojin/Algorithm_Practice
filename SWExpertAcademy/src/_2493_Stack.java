import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2493_Stack {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Integer> heightStack = new Stack<>();
		Stack<Integer> indexStack = new Stack<>();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i= 1; i<=N; ++i) {
			int num = Integer.parseInt(st.nextToken());
			while(true) {
				if(heightStack.isEmpty()) {
					heightStack.push(num);
					indexStack.push(i);
					result.append("0 ");
					break;
				}
				else {
					int height = heightStack.pop();
					int index = indexStack.pop();
					if(height >= num) {
						result.append(index).append(" ");
						heightStack.push(height);
						heightStack.push(num);
						indexStack.push(index);
						indexStack.push(i);
						break;
					}
				}
			}
		}
		
		
		
		System.out.println(result.toString());

	
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10828_스택 {
	static class Stack {
		static private int[] arr;
		static private int top = -1;

		Stack() {
			this(1);
		}

		Stack(int size) {
			arr = new int[size];
		}

		static void push(int num) {
			if (top+1 == arr.length) {
				int[] temp = new int[arr.length+1];
				for (int i = 0; i < arr.length; ++i) {
					temp[i] = arr[i];
				}
				temp[++top] = num;
				arr = temp;
			} else {
				arr[++top] = num;
			}
		}

		static int pop() {
			return top == -1 ? -1 : arr[top--];
		}

		static int size() {
			return top + 1;
		}

		static int empty() {
			return top == -1 ? 1 : 0;
		}

		static int top() {
			return top == -1 ? -1 : arr[top];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack stack = new Stack();
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; ++i) {
			st  = new StringTokenizer(in.readLine());
			String order = st.nextToken();
			switch(order) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				System.out.println(stack.pop());
				break;
			case "top":
				System.out.println(stack.top());
				break;
			case "empty":
				System.out.println(stack.empty());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			
			}
		}
	}
}

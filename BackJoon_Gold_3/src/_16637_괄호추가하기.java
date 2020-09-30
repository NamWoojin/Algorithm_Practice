import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _16637_괄호추가하기 {
	static int signCnt, order[], max = 0;
	static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		for (int i = N - 1; i >= 0; --i) {
			stack.push(str.charAt(i));
		}
		signCnt = N / 2;
		order = new int[signCnt];
		makeOrder(0,new Stack<Character>(), stack);
		System.out.println(max);
	}

	private static void makeOrder(int count,Stack<Character> left, Stack<Character> right) {
		if (right.size() == 0) {
			if (left.size() == 1) {
				max = Math.max(max, left.pop());
				return;
			} else {
				while (left.size() > 0) {
					right.push(left.pop());
				}
			}
		}
		
		if(count == signCnt*2) {
			return;
		}

		char pop = right.pop();
		System.out.println((int)pop);
		if(pop>='0' && pop <='9') {
			left.push(pop);
			makeOrder(count,left,right);
		}else {
			left.push(pop);
			makeOrder(count+1,left,right);
			left.pop();
			int leftNum = left.pop()-'0';
			int rightNum = right.pop()-'0';
			switch(pop) {
			case '+':
				left.push((char)(leftNum+rightNum));
				break;
			case '-':
				left.push((char)(leftNum-rightNum));
				break;
			case '*':
				left.push((char)(leftNum*rightNum));
				break;
			}
			makeOrder(count+1,left,right);
			left.pop();
			left.push((char)leftNum);
			right.push((char)rightNum);
			right.push(pop);
		}
		
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _16637_괄호추가하기 {
	static int max = -Integer.MAX_VALUE;
	static Stack<Integer> numStack = new Stack<>();
	static Stack<Character> signStack = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		for (int i = N - 1; i >= 0; --i) {
			char cha = str.charAt(i);
			if(cha >= '0' && cha <='9') {
				numStack.add(cha-'0');
			}else {
				signStack.add(cha);
			}
		}
		doCalculate(numStack.pop());
		System.out.println(max);
	}

	private static void doCalculate(int ans) {
		if(signStack.size() == 0) {
			max = Math.max(max, ans);
			return;
		}
		char sign = signStack.pop();
		int num = numStack.pop();
		doCalculate(operate(ans,num,sign));
		if(signStack.size() != 0) {
			char sign2 = signStack.pop();
			int num2 = numStack.pop();
			int cal= operate(num,num2,sign2);
			doCalculate(operate(ans,cal,sign));
			signStack.add(sign2);
			numStack.add(num2);
		}
		signStack.add(sign);
		numStack.add(num);
	}
	
	private static int operate(int left,int right,char operator) {
		switch(operator) {
		case '+':
			return left+right;
		case '-':
			return left-right;
		case '*':
			return left*right;
		}
		return -1;
	}

}

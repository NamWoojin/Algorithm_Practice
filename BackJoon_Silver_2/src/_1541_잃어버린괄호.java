import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = in.readLine().toCharArray();
		Deque<Integer> numbers = new ArrayDeque<>();
		Queue<Character> signs = new LinkedList<>();
		int idx = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<chars.length;++i) {
			if(chars[i] >= '0' && chars[i]<='9') {	//숫자일 때
				sb.append(chars[i]);
			}else {	//기호일 때
				numbers.add(Integer.parseInt(sb.toString()));
				sb.setLength(0);
				signs.add(chars[i]);
			}
		}
		numbers.add(Integer.parseInt(sb.toString()));	//마지막 수 넣기
		numbers.add(numbers.pop());	//맨 앞에 있는 수 맨 뒤로 보내기
		while(!signs.isEmpty()) {
			char sign = signs.poll();
			if(sign == '+') {
				int num1 = numbers.pollFirst();
				int num2 = numbers.pollLast();
				numbers.add(num1+num2);
			}else {
				numbers.add(numbers.pop());	//맨 앞에 있는 수 맨 뒤로 보내기
			}
		}
		int answer = numbers.pop();
		while(!numbers.isEmpty()) {
			answer -= numbers.pop();
		}
		System.out.println(answer);
	}
}

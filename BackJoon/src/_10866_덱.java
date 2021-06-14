import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _10866_덱 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Deque<Integer> deque = new ArrayDeque<>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		while (--N >= 0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String order = st.nextToken();
			switch (order) {
			case "push_front":
				int num = Integer.parseInt(st.nextToken());
				deque.addFirst(num);
				break;
			case "push_back":
				num = Integer.parseInt(st.nextToken());
				deque.addLast(num);
				break;
			case "pop_front":
				if (deque.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(deque.pollFirst()).append("\n");
				}
				break;
			case "pop_back":
				if (deque.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(deque.pollLast()).append("\n");
				}
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				sb.append(deque.isEmpty() ? "1" : "0").append("\n");
				break;
			case "front":
				if (deque.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(deque.peekFirst()).append("\n");
				}
				break;
			case "back":
				if (deque.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(deque.peekLast()).append("\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}

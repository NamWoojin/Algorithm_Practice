import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1158_요세푸스문제_queue {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i<=N;++i) {
			queue.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int count = 0;
		while(!queue.isEmpty()) {
			++count;
			if(count == K) {
				count = 0;
				sb.append(queue.poll()+", ");
			}else {
				queue.offer(queue.poll());
			}
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}
}

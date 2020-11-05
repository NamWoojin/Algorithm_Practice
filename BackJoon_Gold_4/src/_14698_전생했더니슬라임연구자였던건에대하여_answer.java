import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _14698_전생했더니슬라임연구자였던건에대하여_answer {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();
			for (int i = 0; i < N; ++i) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			long answer = 1;
			while (pq.size() > 1) {
				long num1 = pq.poll();
				long num2 = pq.poll();
				long mul = num1 * num2;
				pq.add(mul);
				answer = ((mul% 1000000007) * answer)% 1000000007;
			}
			System.out.println(answer);

		}
	}
}

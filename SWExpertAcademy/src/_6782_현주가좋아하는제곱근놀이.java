import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _6782_현주가좋아하는제곱근놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			float N = Integer.parseInt(in.readLine());
			Queue<Float> queue = new LinkedList<>();
			int count = 0;
			queue.offer(N);
			out: while (true) {
				int size = queue.size();
				while (--size >= 0) {
					float num = queue.poll();
					if (num == 2) {
						break out;
					}
					queue.offer(num + 1);
					if (num == (int) num) {
						queue.offer((float)Math.sqrt(num));
					}
				}
				++count;
			}
			System.out.println("#" + tc + " " + count);
		}
	}
}

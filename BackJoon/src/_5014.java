import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5014 {

	static boolean[] visited;
	static int F;
	static int S;
	static int G;
	static int U;
	static int D;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		min = 1000001;
		visited = new boolean[F + 1];
		int ans=find();
		if (ans == -1)
			System.out.println("use the stairs");
		else
			System.out.println(ans);
	}

	static int find() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(S);
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (--size >= 0) {
				int num = queue.poll();
				if (num == G) {
					
					return count;
				}

				if (num + U <= F && !visited[num + U]) {
					visited[num + U] = true;
					queue.offer(num + U);
				}
				if (num - D >= 1 && !visited[num - D]) {
					visited[num - D] = true;
					queue.offer(num - D);
				}
			}
			++count;
		}
		return -1;
	}
}

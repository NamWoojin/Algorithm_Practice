import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697 {
	static int N;
	static int K;
	
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int min = 0;
		visited = new boolean[100001];
		if (N == K) {
			min = 0;
		} else if (N > K) {
			min = N - K;
		} else {
			min = find(N);
		}
		System.out.println(min);

	}

	private static int find(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(num);
		int count = 0;
		visited[N] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			while (--size >= 0) {
				int number = queue.poll();
				if (number == K)
					return count;
				if (number*2 <=100000 &&!visited[number * 2]) {
					visited[number * 2] = true;
					queue.offer(number * 2);
				}
				if (number+1 <=100000 && !visited[number + 1]) {
					visited[number + 1] = true;
					queue.offer(number + 1);
				}
				if (number-1 >= 0 &&!visited[number - 1]) {
					visited[number - 1] = true;
					queue.offer(number - 1);
				}
			}
			++count;
		}
		return count;
	}

}

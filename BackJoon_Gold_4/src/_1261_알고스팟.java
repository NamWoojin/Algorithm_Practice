import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1261_알고스팟 {
	static class Node implements Comparable<Node> {
		int r, c, count;

		Node(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.count - o.count;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[N][M];
		for (int i = 0; i < N; ++i) {
			String str = in.readLine();
			for (int j = 0; j < M; ++j) {
				arr[i][j] = str.charAt(j) == '1';
			}
		}

		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(0, 0, 0));
		boolean[][][] visited = new boolean[N * M][N][M];
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			if (n.r == N - 1 && n.c == M - 1) {
				System.out.println(n.count);
				break;
			}
			for (int i = 0; i < 4; ++i) {
				int rr = n.r + dr[i];
				int cc = n.c + dc[i];
				if (rr < 0 || cc < 0 || rr >= N || cc >= M)
					continue;
				
				if(arr[rr][cc] && !visited[n.count+1][rr][cc]) {
					queue.offer(new Node(rr,cc,n.count+1));
					visited[n.count+1][rr][cc] = true;
				}
				else if(!arr[rr][cc] && !visited[n.count][rr][cc]) {
					queue.offer(new Node(rr,cc,n.count));
					visited[n.count][rr][cc] = true;
				}
			}
		}

	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1445_일요일아침의데이트 {
	static class Node implements Comparable<Node> {
		int r;
		int c;
		int trash;
		int nearTrash;

		public Node(int r, int c, int trash, int nearTrash) {
			this.r = r;
			this.c = c;
			this.trash = trash;
			this.nearTrash = nearTrash;
		}

		@Override
		public int compareTo(Node o) {
			if (this.trash == o.trash) {
				return this.nearTrash - o.nearTrash;
			}
			return this.trash - o.trash;
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M;
	static char map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		Node start = null;
		Node flower = null;
		for (int i = 0; i < N; ++i) {
			map[i] = in.readLine().toCharArray();
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				switch (map[i][j]) {
				case 'S':
					start = new Node(i, j, 0, 0);
					break;
				case 'g':
					for (int k = 0; k < 4; ++k) {
						int rr = i + dr[k];
						int cc = j + dc[k];

						if (rr < 0 || cc < 0 || rr >= N || cc >= M)
							continue;

						if (map[rr][cc] == '.')
							map[rr][cc] = 'n';
					}
					break;
				case 'F':
					flower = new Node(i, j, 0, 0);
					break;
				}
			}
		}

		Node result = bfs(start,flower);
		System.out.println(result.trash + " " + result.nearTrash);
	}

	private static Node bfs(Node start,Node flower) {
		int[][] countMap = new int[N][M];
		for (int i = 0; i < N; ++i)
			Arrays.fill(countMap[i], Integer.MAX_VALUE);

		Queue<Node> queue = new LinkedList<>();
		queue.offer(start);
		countMap[start.r][start.c] = 0;
		Node end = null;
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			if (end != null)
				if((n.trash > end.trash) || (n.trash == end.trash && n.nearTrash >= end.nearTrash))
					continue;
			
			if (map[n.r][n.c] == 'F') {
				//if(end == null || ((n.trash > end.trash) || (n.trash == end.trash && n.nearTrash >= end.nearTrash)))
					end = n;
				continue;
			}
			
			for (int i = 0; i < 4; ++i) {
				int rr = n.r + dr[i];
				int cc = n.c + dc[i];

				if (rr < 0 || cc < 0 || rr >= N || cc >= M)
					continue;
				if (countMap[rr][cc] <= n.trash * 10000 + n.nearTrash)
					continue;

				countMap[rr][cc] = n.trash * 10000 + n.nearTrash;

				if (map[rr][cc] == 'g')
					queue.offer(new Node(rr, cc, n.trash+1, n.nearTrash));
				else if (map[rr][cc] == 'n')
					queue.offer(new Node(rr, cc, n.trash, n.nearTrash+1));
				else
					queue.offer(new Node(rr, cc, n.trash, n.nearTrash));
			}
		}

		return end;
	}
}

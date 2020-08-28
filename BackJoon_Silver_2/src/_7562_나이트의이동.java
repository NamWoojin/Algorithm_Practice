import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7562_나이트의이동 {
	static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int I;
	static boolean[][] isVisited;
	static Node goal;

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			I = Integer.parseInt(in.readLine());
			isVisited = new boolean[I][I];
			StringTokenizer st = new StringTokenizer(in.readLine());
			Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(in.readLine());
			goal = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			System.out.println(bfs(start));
		}
	}

	private static int bfs(Node start) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(start);
		isVisited[start.r][start.c] = true;
		int num = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (--size >= 0) {
				Node n = queue.poll();
				if(n.r == goal.r && n.c == goal.c) {
					return num;
				}
				for (int i = 0; i < 8; ++i) {
					int rr = n.r + dr[i];
					int cc = n.c + dc[i];
					
					if(rr<0||cc<0||rr>=I||cc>=I)
						continue;
					
					if(!isVisited[rr][cc]) {
						isVisited[rr][cc] = true;
						queue.offer(new Node(rr,cc));
					}
				}

			}
			++num;
		}
		return num;
	}
}

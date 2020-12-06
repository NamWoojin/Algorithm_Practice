import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _8382_방향전환 {
	static class Node {
		int r, c;
		int move;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		Node(int r, int c, int move) {
			this.move = move;
			this.r = r;
			this.c = c;
		}
	}

	static int dir[][][] = { { { 1, 0 }, { -1, 0 } }, { { 0, 1 }, { 0, -1 } } };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Node end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			boolean visited[][][] = new boolean[201][201][2];
			int count = 0;
			Queue<Node> q = new LinkedList<>();
			start.move = 0;
			q.offer(start);
			Node temp = new Node(start.r, start.c);
			temp.move = 1;
			q.offer(temp);
			visited[start.r + 100][start.c + 100][0] = true;
			visited[start.r + 100][start.c + 100][1] = true;
			out: while (!q.isEmpty()) {
				int size = q.size();
				while (--size >= 0) {
					Node n = q.poll();
					if (n.r == end.r && n.c == end.c) {
						break out;
					}

					for (int i = 0; i < 2; ++i) {
						int rr = n.r + dir[n.move][i][0];
						int cc = n.c + dir[n.move][i][1];

						if (rr < -100 || cc < -100 || rr > 100 || cc > 100)
							continue;
						if (visited[rr + 100][cc + 100][n.move])
							continue;
						visited[rr + 100][cc + 100][n.move] = true;
						q.offer(new Node(rr, cc, (n.move + 1) % 2));
					}
				}
				++count;
			}
			System.out.println("#" + tc + " " + count);

		}
	}
}

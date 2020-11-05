import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class _1868_파핑파핑지뢰찾기 {
	static class Node implements Comparable<Node> {
		int r, c, bombs;

		public Node(int r, int c, int bombs) {
			super();
			this.r = r;
			this.c = c;
			this.bombs = bombs;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.bombs - o.bombs;
		}

	}

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(in.readLine());
			char[][] map = new char[N][N];
			int[][] answer = new int[N][N];
			for (int i = 0; i < N; ++i) {
				map[i] = in.readLine().toCharArray();
			}
			PriorityQueue<Node> q = new PriorityQueue<>();
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if(map[i][j] == '.') {
						int count = 0;
						for(int k = 0; k<8;++k) {
							int rr = i + dr[k];
							int cc = j + dc[k];
							if(rr < 0 || cc < 0 || rr >= N || cc >= N)
								continue;
							
							if(map[rr][cc] == '*')
								++count;
						}
						answer[i][j] = count;
						q.add(new Node(i,j,count));
					}else {
						answer[i][j] = -1;
					}
				}
			}
			int count = 0;
			boolean[][] visited = new boolean[N][N];
			while(!q.isEmpty()) {
				Node n = q.poll();
				visited[n.r][n.c] = true;
				if(map[n.r][n.c] != '.')
					continue;
				
				++count;
				Queue<Node> queue =new LinkedList<>();
				queue.add(n);
				while(!queue.isEmpty()) {
					Node nn = queue.poll();
					map[nn.r][nn.c] = (char)(answer[nn.r][nn.c]+48);
					if(answer[nn.r][nn.c] == 0) {
						for(int k = 0; k<8;++k) {
							int rr = nn.r + dr[k];
							int cc = nn.c + dc[k];
							if(rr < 0 || cc < 0 || rr >= N || cc >= N)
								continue;
							if(visited[rr][cc])
								continue;
							
							visited[rr][cc] = true;
							queue.offer(new Node(rr,cc,0));
						}
					}
				}
				
			}
			System.out.println("#"+tc+" "+count);
		}
	}
}

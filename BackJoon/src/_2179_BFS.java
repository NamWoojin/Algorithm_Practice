import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Status {
	int r;
	int c;
	int cnt;
	public Status(int r, int c, int cnt) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
	
}
public class _2179_BFS {
	
	private static int dr[] = { -1, 1, 0, 0 };
	private static int dc[] = { 0, 0, -1, 1 };
	private static int[][] maze;
	private static int ans;
	static boolean[][] visited;
	private static int N, M;
	private static Queue<Status> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// DFS로 풀면, 굉장히 짧은 거리가 있음에도 끝까지 가야 알 수 있기 때문에
		// 최단거리 문제는 BFS가 유리함.
		// 경로의 수는 DFS가 유리
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N + 2][M + 2]; // 미로의 사방에 0이 생겨 못가게 됨.
		visited = new boolean[N + 2][M + 2];
		ans = N * M;
		for (int i = 1; i <= N; ++i) {
			String str = in.readLine();
			for (int j = 0; j < M; ++j) {
				maze[i][j + 1] = str.charAt(j) - '0';
			}
		}
		visited[1][1] = true;
		queue.offer(new Status(1, 1, 1));
		cal();// 처음도 1
		System.out.println(ans);
	}

	// 각 상태가 가져야 하는 정보는, 어디있는지, 몇칸이나 왔는지.
	private static void cal() {

		while (!queue.isEmpty()) {
			Status s = queue.poll();
			if (s.r == N && s.c == M) {
				if(ans > s.cnt) {
					ans = s.cnt;
				}
				break;
			}

			for (int d = 0; d < 4; ++d) {
				int nr = s.r + dr[d];
				int nc = s.c + dc[d];
				if (maze[nr][nc] == 0)
					continue;
				if (visited[nr][nc])
					continue;
				queue.add(new Status(nr, nc, s.cnt + 1));
				visited[nr][nc] = true;

			}
		}

	}
}

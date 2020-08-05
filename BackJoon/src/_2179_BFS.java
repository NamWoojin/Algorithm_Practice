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
		// DFS�� Ǯ��, ������ ª�� �Ÿ��� �������� ������ ���� �� �� �ֱ� ������
		// �ִܰŸ� ������ BFS�� ������.
		// ����� ���� DFS�� ����
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N + 2][M + 2]; // �̷��� ��濡 0�� ���� ������ ��.
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
		cal();// ó���� 1
		System.out.println(ans);
	}

	// �� ���°� ������ �ϴ� ������, ����ִ���, ��ĭ�̳� �Դ���.
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

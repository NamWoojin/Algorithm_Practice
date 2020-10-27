import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _19238_스타트택시 {
	static class Node {
		int r, c;
		int oil;
		Node(int r, int c, int oil) {
			this.r = r;
			this.c = c;
			this.oil = oil;
		}
	}

	static int N, M, map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Node[] nodeDests;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int Oil = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine());
		Node driver = new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Oil);
		nodeDests = new Node[M];
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int desR = Integer.parseInt(st.nextToken()) - 1;
			int desC = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = i + 2;
			nodeDests[i] = new Node(desR,desC,0);
		}
		for (int i = 0; i < M; ++i) {
			driver = findPassenger(driver);
			
			if (driver == null)
				break;
		}

		if (driver == null)
			System.out.println(-1);
		else
			System.out.println(driver.oil);

	}

	private static Node findPassenger(Node driver) {
		Queue<Node> q = new LinkedList<>();
		boolean isVisited[][] = new boolean[N][N];
		q.add(driver);
		isVisited[driver.r][driver.c] = true;
		Node passenger = null;
		int destR = 0;
		int destC = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (--size >= 0) {
				Node n = q.poll();
				if (map[n.r][n.c] >= 2) {
					if (passenger == null || passenger.r > n.r || (passenger.r == n.r && passenger.c > n.c)) {
						passenger = n;
						destR = nodeDests[map[n.r][n.c]-2].r;
						destC = nodeDests[map[n.r][n.c]-2].c;
						continue;
					}
				}
				if (n.oil == 0)
					continue;
				
				for (int i = 0; i < 4; ++i) {
					int rr = n.r + dr[i];
					int cc = n.c + dc[i];

					if (rr < 0 || cc < 0 || rr >= N || cc >= N)
						continue;
					if (isVisited[rr][cc] || map[rr][cc]== 1)
						continue;

					isVisited[rr][cc] = true;
					q.offer(new Node(rr, cc, n.oil - 1));
				}
			}
			if (passenger != null) {
				break;
			}
		}

		if (passenger == null) {
			return null;
		} else {
			map[passenger.r][passenger.c] = 0;
			return findDestination(passenger, destR,destC);
		}
	}

	private static Node findDestination(Node start, int destR,int destC) {
		Queue<Node> q = new LinkedList<>();
		boolean isVisited[][] = new boolean[N][N];
		q.add(start);
		isVisited[start.r][start.c] = true;
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.r == destR && n.c == destC) {
				return new Node(n.r,n.c, n.oil + (start.oil - n.oil)*2);
			}
			if (n.oil == 0)
				continue;
			for (int i = 0; i < 4; ++i) {
				int rr = n.r + dr[i];
				int cc = n.c + dc[i];

				if (rr < 0 || cc < 0 || rr >= N || cc >= N)
					continue;
				if (isVisited[rr][cc]|| map[rr][cc]== 1)
					continue;

				isVisited[rr][cc] = true;
				q.offer(new Node(rr, cc, n.oil - 1));
			}
		}
		return null;
	}
}

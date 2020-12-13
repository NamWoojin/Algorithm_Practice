import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14502_연구소 {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M, map[][],tempMap[][],minTwos = Integer.MAX_VALUE,twos=0,zeros=0;
	static Queue<Node> virus = new LinkedList<>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus.add(new Node(i, j));
				else if(map[i][j] == 0)
					++zeros;
			}
		}

		solve(0,0);
		System.out.println(zeros - minTwos -3);
	}

	static void solve(int count, int row) {
		if (count == 3) {
//			bfs();
			Queue<Node> q = new LinkedList<>(virus);
			tempMap = new int[N][];
			for (int i = 0; i < N; ++i) {
				tempMap[i] = map[i].clone();
			}
			twos = -q.size();
			while(!q.isEmpty()) {
				Node n = q.poll();
				dfs(n.r, n.c);
			}
			minTwos = Math.min(minTwos, twos);
			return;
		}
		for (int i = row; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					solve(count + 1, i);
					map[i][j] = 0;
				}
			}
		}
	}

//	static void bfs() {
//		Queue<Node> q = new LinkedList<>(virus);
//		int[][] tempMap = new int[N][];
//		for (int i = 0; i < N; ++i) {
//			tempMap[i] = map[i].clone();
//		}
//		int twos = -q.size();
//		while (!q.isEmpty()) {
//			Node n = q.poll();
//			++twos;
//			if(twos > minTwos) {
//				return;
//			}
//			for (int i = 0; i < 4; ++i) {
//				int rr = n.r + dr[i];
//				int cc = n.c + dc[i];
//				if(rr<0||cc<0||rr>=N||cc>=M)	//범위 밖에 나갔을 때
//					continue;
//				if(tempMap[rr][cc] == 0) {
//					tempMap[rr][cc] = 2;
//					q.add(new Node(rr,cc));
//				}
//			}
//		}
//
//		minTwos = Math.min(minTwos, twos);
//	}
	
	static void dfs(int r, int c) {
		++twos;
//		if(twos > minTwos) {	//없는게 시간 더 빠름
//			return;
//		}
		for (int i = 0; i < 4; ++i) {
			int rr = r + dr[i];
			int cc = c + dc[i];
			if(rr<0||cc<0||rr>=N||cc>=M)	//범위 밖에 나갔을 때
				continue;
			if(tempMap[rr][cc] == 0) {
				tempMap[rr][cc] = 2;
				dfs(rr,cc);
			}
		}
	}
}

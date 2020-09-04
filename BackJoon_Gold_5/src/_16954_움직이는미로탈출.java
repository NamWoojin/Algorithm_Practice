import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _16954_움직이는미로탈출 {
	static final int N = 8;
	static char[][] map;

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
//	static boolean[][] isVisited;
	static Deque<Node> deque;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new char[N][N];
//		isVisited = new boolean[N][N];
		deque = new ArrayDeque<>();
		for (int i = 0; i < N; ++i) {
			String str = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '#') {
					deque.offer(new Node(i, j));
				}
			}
		}
		System.out.println(bfs()? '1': '0');
		
	}

	private static boolean bfs() {
		Queue<Node> user = new LinkedList<>();
		user.offer(new Node(N - 1, 0));
//		isVisited[N - 1][0] = true;

		while (!user.isEmpty()) {
			int size = user.size();
			while (--size >= 0) {
				Node n = user.poll();
				
				if(map[n.r][n.c] == '#')
					continue;
//				System.out.println(n.r+" "+n.c);
				for (int i = 0; i < 8; ++i) {
					int rr = n.r + dr[i];
					int cc = n.c + dc[i];
					if(rr<0|| cc<0||rr>=N||cc>=N)
						continue;
//					!isVisited[rr][cc] &&
					if ( map[rr][cc] != '#') {
						if(rr == 0 && cc== N-1) {
							return true;
						}
						map[rr][cc] = '*';
						user.offer(new Node(rr, cc));
//						isVisited[rr][cc] = true;
					}
				}
				user.offer(n);
			}
			moveWall();
//			System.out.println();
//			for(int i =0; i<N;++i)
//				System.out.println(Arrays.toString(map[i]));
//			System.out.println();
		}
		return false;
	}
	
	private static void moveWall() {
		int size = deque.size();
		while(--size>=0) {
			Node n = deque.pollLast();
			map[n.r][n.c] = '.';
			if(n.r == N-1)
				continue;
			map[n.r+1][n.c]  = '#';
			deque.offerFirst(new Node(n.r+1,n.c));
		}
		
	}
}

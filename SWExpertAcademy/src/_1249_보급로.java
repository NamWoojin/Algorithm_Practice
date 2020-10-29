import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _1249_보급로 {
	static class Node  {
		int r, c, time;

		Node(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

		
	}

	static int map[][], N;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			int num = 0;
			for (int i = 0; i < N; ++i) {
				String str = in.readLine();
				for (int j = 0; j < N; ++j) {
					map[i][j] = str.charAt(j)-'0';
					num += map[i][j];
				}
			}
			System.out.println("#"+tc+" "+bfs());
		}
	}

	private static int bfs() {
		
		int[][] minMap = new int[N][N];
		for(int i = 0; i<N;++i)
			Arrays.fill(minMap[i], Integer.MAX_VALUE);
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0));
		while (!q.isEmpty()) {
			Node n = q.poll();
			for(int i = 0; i<4;++i) {
				int rr = n.r + dr[i];
				int cc = n.c + dc[i];
				
				if(rr<0|| cc<0||rr>=N||cc>=N)
					continue;
				
				int num  =n.time + map[rr][cc];
				if(minMap[rr][cc] > num) {
					minMap[rr][cc] = num;
					q.offer(new Node(rr,cc,num));
				}
				
			}
		}
		return minMap[N-1][N-1];
	}
}

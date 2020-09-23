import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11048_이동하기 {
	static int[] dr = {1,0,1};
	static int[] dc = {0,1,1};
	static int maze[][],N,M;
	static int  dp[][];
	static class Node{
		int r, c;
		Node(int r,int c){
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		dp = new int[N][M];
		for(int i =0; i<N;++i) {
			st=  new StringTokenizer(in.readLine());
			for (int j = 0; j < M; ++j) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(dp[N-1][M-1]);
		
	}
	
	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		queue.add(new Node(0,0));
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			int max = 0;
			for(int i =0; i<3;++i) {
				int rr = n.r - dr[i];
				int cc = n.c - dc[i];
				
				if(rr<0 || cc<0)
					continue;
				
				max = Math.max(max, dp[rr][cc]);
			}
			dp[n.r][n.c] = max + maze[n.r][n.c];
			for(int i =0; i<3;++i) {
				int rr = n.r + dr[i];
				int cc = n.c + dc[i];
				
				if(rr>=N || cc>=M)
					continue;
				if(visited[rr][cc])
					continue;
				
				visited[rr][cc] = true;
				queue.offer(new Node(rr,cc));
			}
			
		}
	}
}

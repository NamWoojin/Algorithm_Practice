import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2206 {
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][][] isVisited;
	static class Node implements Comparable<Node>{
		int r; int c;
		int breakCount;
		int move;
		Node(int r, int c, int breakCount,int move){
			this.r = r;
			this.c = c;
			this.move= move;
			this.breakCount = breakCount;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.move == o.move)
				return this.breakCount - o.breakCount;
			else
				return this.move - o.move;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		isVisited = new boolean[N][M][2];
		for(int i =0;i<N;++i) {
			String str = in.readLine();
			for(int j = 0; j<M;++j) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		System.out.println(bfs());
	}

	private static int bfs() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(0,0,0,1));
		isVisited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.r == N-1 && node.c == M-1) {
				return node.move;
			}
			
			for(int i =0; i<4;++i) {
				int rr = node.r + dr[i];
				int cc = node.c + dc[i];
				
				if(rr<0||cc<0||rr>=N||cc>=M)
					continue;
				
				if(node.breakCount == 0 && !isVisited[rr][cc][0]) {
					if(arr[rr][cc] == 1) {
						isVisited[rr][cc][1] = true;
						queue.offer(new Node(rr,cc,1,node.move+1));
					}else {
						isVisited[rr][cc][0] = true;
						queue.offer(new Node(rr,cc,node.breakCount,node.move+1));
					}
					
				}else if(node.breakCount == 1&& !isVisited[rr][cc][1]){
					isVisited[rr][cc][1] = true;
					if(arr[rr][cc] == 0) {
						queue.offer(new Node(rr,cc,node.breakCount,node.move+1));
					}
				}
			}
		}
		
		return -1;
	}
}

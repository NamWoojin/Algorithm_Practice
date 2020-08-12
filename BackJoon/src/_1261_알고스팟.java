import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1261_알고스팟 {
	static class Node implements Comparable<Node>{
		int r; int c; int count = 0;
		Node(int r,int c,int count){
			this.r = r;
			this.c = c;
			this.count = count;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.count - o.count;
		}
		
	}
	static boolean[][] isVisited;
	static int N;
	static int M;
	static int min;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		isVisited = new boolean[N][M];
		min = N*M;
		for(int i = 0; i<N;++i) {
			String str = in.readLine();
			for(int j = 0; j<M;++j) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
//		for(int i = 0; i<N;++i) {
//			for(int j = 0; j<M;++j) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		bfs();
		System.out.println(min);
	}
	
	private static void bfs() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(0,0,0));
		isVisited[0][0] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.r == N-1 && node.c == M-1) {
				min = Math.min(node.count, min);
				return;
			}
			
			for(int i = 0; i<4;++i) {
				int rr = node.r + dr[i];
				int cc = node.c + dc[i];
				
				if(rr < 0|| cc<0|| rr>= N||cc>= M)
					continue;
				
				if(!isVisited[rr][cc] && arr[rr][cc] == 0) {
					isVisited[rr][cc] = true;
					queue.add(new Node(rr,cc,node.count));
				}
				else if (!isVisited[rr][cc] && arr[rr][cc] == 1) {
					isVisited[rr][cc]= true;
					queue.add(new Node(rr,cc,node.count+1));
				}
			}
			
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1949_등산로조성 {
	static class Node{
		int r,c,cnt,num;
		boolean cut = false;
		public Node(int r, int c,int num , int cnt, boolean cut) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
			this.cnt = cnt;
			this.cut = cut;
		}
		
	}
	static int N,K,map[][],max;
	static boolean visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<= T;++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			max = 0;
			Queue<Node> tops = new LinkedList<>();
			int top = 0;
			for(int i=0; i<N;++i) {
				st = new StringTokenizer(in.readLine());
				for(int j =0;j<N;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(top<map[i][j]) {
						tops = new LinkedList<>();
						top = map[i][j];
						tops.add(new Node(i,j,top,1,false));
					}else if(top == map[i][j]) {
						tops.add(new Node(i,j,top,1,false));
					}
				}
			}
//			bfs(tops);
			while(!tops.isEmpty()) {
				Node n = tops.poll();
				dfs(n);
			}
			System.out.println("#"+tc+" "+max);
		}
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void bfs(Queue<Node> queue) {
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			int nowNum = n.num;
			max = Math.max(n.cnt, max);
			for(int i = 0; i<4;++i) {
				int rr =n.r + dr[i];
				int cc =n.c + dc[i];
				if(rr<0||cc<0||rr>=N||cc>=N)
					continue;
				
				int moveNum = map[rr][cc];
				if(nowNum > moveNum) {
					queue.add(new Node(rr,cc,moveNum,n.cnt+1,n.cut));
				}else if(!n.cut){
					for(int j =1;j<=K;++j) {
						if(nowNum > moveNum-j) {
							queue.add(new Node(rr,cc,moveNum-j,n.cnt+1,true));
						}
					}
				}
			}
		}
	}
	
	private static void dfs(Node n) {
		visited[n.r][n.c] = true;
		int nowNum = n.num;
		max = Math.max(n.cnt, max);
		for(int i = 0; i<4;++i) {
			int rr =n.r + dr[i];
			int cc =n.c + dc[i];
			if(rr<0||cc<0||rr>=N||cc>=N)
				continue;
			if(visited[rr][cc])
				continue;
			int moveNum = map[rr][cc];
			if(nowNum > moveNum) {
				dfs(new Node(rr,cc,moveNum,n.cnt+1,n.cut));
			}else if(!n.cut){
				for(int j =1;j<=K;++j) {
					if(nowNum > moveNum-j) {
						dfs(new Node(rr,cc,moveNum-j,n.cnt+1,true));
						break;
					}
				}
			}
		}
		visited[n.r][n.c] = false;
	}
}

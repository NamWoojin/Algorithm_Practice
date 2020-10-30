import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _14500_테트로미노_dfs {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M, map[][], max = 0;
	static boolean[][] visited;
	static Node[] nodes = new Node[4];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<N;++i) {
			for(int j =0; j<M;++j) {
				dfs(new Node(i,j),0,0);
				getT(i,j);
			}
		}
		
		System.out.println(max);
	}
	
	private static void dfs(Node n, int idx,int sum ) {
		if(idx == 4) {
			max = Math.max(sum, max);
			return;
		}
		
		for(int i =0; i<4;++i) {
			int rr = n.r + dr[i];
			int cc = n.c + dc[i];
			
			if(rr<0||cc<0||rr>=N||cc>=M)
				continue;
			if(visited[rr][cc])
				continue;
			
			nodes[idx] = new Node(rr,cc);
			visited[rr][cc] = true;
			dfs(nodes[idx],idx+1,sum+map[rr][cc]);
			visited[rr][cc] = false;
		}
		
	}
	
	private static void getT(int r,int c) {
		int sum = map[r][c];
		ArrayList<Integer> around = new ArrayList<>();
		for(int i = 0; i<4;++i) {
			int rr = r + dr[i];
			int cc = c + dc[i];
			
			if(rr<0||cc<0||rr>=N||cc>=M)
				continue;
			
			around.add(map[rr][cc]);
			sum += map[rr][cc];
		}
		if(around.size()==3) {
			max = Math.max(max, sum);
		}else if(around.size() > 3) {
			for(int i = 0; i<around.size();++i) {
				max = Math.max(max, sum - around.get(i));
			}
		}
	}
	
	
	
//	private static void getT(int r,int c) {
//		int sum = map[r][c];
//		
//		int[] around = new int[4];
//		for(int i = 0; i<4;++i) {
//			int rr = r + dr[i];
//			int cc = c + dc[i];
//			
//			if(rr<0||cc<0||rr>=N||cc>=M)
//				continue;
//			
//			around[i] = map[rr][cc];
//		}
//		
//		add(around,0,0,sum);
//	}
//	
//	private static void add(int[] around, int idx, int choice, int sum) {
//		if(choice == 3) {
//			max = Math.max(sum, max);
//			return;
//		}
//		
//		if(idx == 4) {
//			return;
//		}
//		
//		add(around,idx+1,choice,sum);
//		if(around[idx] != 0) {
//			add(around,idx+1,choice+1,sum+around[idx]);
//		}
//	}

	
}

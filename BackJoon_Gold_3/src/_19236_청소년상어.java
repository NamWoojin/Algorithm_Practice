import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19236_청소년상어 {
	
	static class Node{
		int r,c,dir,num;
		Node(int r, int c,int dir){
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		Node(int r, int c,int dir,int num){
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.num = num;
		}
	}
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] map = new int[4][4];
		Node[] nodes = new Node[17];
		for(int r = 0; r<4;++r) {
			st = new StringTokenizer(in.readLine());
			for(int c = 0; c<4;++c) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				map[r][c] = num;
				nodes[num] = new Node(r,c,dir);
			}
		}
		Node shark = new Node(0,0,nodes[map[0][0]].dir,map[0][0]);
		nodes[map[0][0]] = null;
		map[0][0] = -1;
		solve(map,nodes,shark);
		System.out.println(max);
	}
	
	static void solve(int[][] map, Node[] nodes,Node shark) {

		
		moveFish(map,nodes);
		
		int sr = shark.r;
		int sc = shark.c;
		map[sr][sc] = 0;
		while(true) {
			sr += dr[shark.dir];
			sc += dc[shark.dir];
			
			if(sr <0 ||sc<0|| sr>= 4|| sc>=4)
				break;
			if(map[sr][sc]==0)	//물고기 없는 빈칸
				continue;
			
			int fishNum = map[sr][sc];
			
			int[][] mapTemp = new int[4][];
			Node[] nodesTemp = nodes.clone();
			for(int i = 0; i<4;++i) {
				mapTemp[i] = map[i].clone();
			}
			
			Node sharkTemp = new Node(sr,sc,nodes[fishNum].dir,shark.num+fishNum);
			nodesTemp[fishNum] = null;
			mapTemp[sr][sc] = -1;
			
			solve(mapTemp,nodesTemp,sharkTemp);
			
		}
		
		max = Math.max(max, shark.num);
	}
	
	static void moveFish(int[][] map, Node[] nodes) {
		for(int i = 1; i<=16;++i) {
			if(nodes[i] != null) {
				Node fish = nodes[i];
				for(int dir = 0; dir<8;++dir) {
					int newDir = (fish.dir+dir)%8;
					int rr = fish.r + dr[newDir];
					int cc = fish.c + dc[newDir];
					
					if(rr<0||cc<0||rr>=4||cc>=4)	//공간 넘는 칸
						continue;
					if(map[rr][cc] == -1)	// 상어(-1)
						continue;
					
					
					nodes[i] = new Node(rr,cc,newDir);
					
					if(map[rr][cc] != 0) {	//빈칸아닐경우
						nodes[map[rr][cc]] = new Node(fish.r,fish.c,nodes[map[rr][cc]].dir);
					}
					
					// 자리바꾸기
					map[rr][cc] ^= map[fish.r][fish.c];
					map[fish.r][fish.c] ^= map[rr][cc];
					map[rr][cc] ^= map[fish.r][fish.c];
					break;
				}
			}
			
		}
	}
	
	
	
}

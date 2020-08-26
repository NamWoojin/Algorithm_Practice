import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1194_달이차오른다가자 {
	static class Node{
		int r,c;
		int key;
		int movement;
		Node(int r, int c, int key, int movement){
			this.r = r;
			this.c = c;
			this.key = key;
			this.movement = movement;
		}
	}
	static int N,M;
	static char[][] maze;
	static Node start;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new char[N][M];
		for(int i = 0; i<N;++i) {
			String str = in.readLine();
			for(int j = 0; j<M;++j) {
				maze[i][j] = str.charAt(j);
				if(maze[i][j] == '0') {
					maze[i][j] = '.';
					start = new Node(i,j,0,0);
				}
					
			}
		}
		System.out.println(bfs());
		
	}
	
	private static int bfs() {
		boolean[][][] isVisited = new boolean[N][M][1<<6];
		isVisited[start.r][start.c][0] = true;
		Queue<Node> queue=new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			for(int i = 0; i<4;++i) {
				int rr = n.r + dr[i];
				int cc = n.c + dc[i];
				
				if(rr<0||cc<0||rr>=N|cc>=M)
					continue;
				
				if(isVisited[rr][cc][n.key])
					continue;
				
				switch(maze[rr][cc]) {
				case '#':
					break;
				case'.':
					queue.offer(new Node(rr,cc,n.key,n.movement+1));
					isVisited[rr][cc][n.key] = true;
					break;
				case '1':
					return n.movement+1;
					
				default:
					if(maze[rr][cc] <'G') {
						if((n.key&(1<<(maze[rr][cc]-'A')))>0) {
							queue.offer(new Node(rr,cc,n.key,n.movement+1));
							isVisited[rr][cc][n.key] = true;
						}
					}else {
						queue.offer(new Node(rr,cc,n.key|(1<<(maze[rr][cc]-'a')),n.movement+1));
						isVisited[rr][cc][n.key|(1<<(maze[rr][cc]-'a'))] = true;
					}
					break;
				}
			}
		}
		return -1;
	}
	
}
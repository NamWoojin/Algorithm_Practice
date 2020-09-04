import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1473_미로탈출 {
	static int N,M,min = Integer.MAX_VALUE;
	static int[] dr = {-1,1,0,0};//상하좌우
	static int[] dc = {0,0,-1,1};
	static char[][] map;
	static class Node{
		int r,c,time;
		Node(int r, int c,int time){
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	static boolean[][] changed;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		changed = new boolean[N][M];
		for(int i =0; i<N;++i) {
			String str = in.readLine();
			for(int j = 0; j<M;++j) {
				map[i][j] = str.charAt(j);
			}
		}
		
		bfs(0,0,0);
		System.out.println(min);
	}
	
	private static void bfs(int r, int c,int time) {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] isVisited = new boolean[N][M];
		queue.offer(new Node(r,c,time));
		isVisited[r][c] =true;
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			if(n.r == N-1 && n.c == M-1) {
				min = Math.min(min, n.time);
				return;
			}
			int i=0,j=0;
			switch(map[n.r][n.c]) {
			case 'A':
				i=0;j=4;
				break;
			case 'B':
				break;
			case 'C':
				i=0;j=2;
				break;
			case 'D':
				i=2;j=4;
				break;
			}
			
			for(; i<j;++i) {
				int rr = n.r + dr[i];
				int cc = n.c +dc[i];
				if(rr<0|| cc<0||rr>N-1||cc>M-1)
					continue;
				if(isVisited[rr][cc])
					continue;
				
				switch(map[rr][cc]) {
				case 'A':
					queue.offer(new Node(rr,cc,n.time+1));
					isVisited[rr][cc] = true;
					break;
				case 'B':
					break;
				case 'C':
					if(i==3||i==4)
						continue;
					queue.offer(new Node(rr,cc,n.time+1));
					isVisited[rr][cc] = true;
					break;
				case 'D':
					if(i==1 || i==2)
						continue;
					queue.offer(new Node(rr,cc,n.time+1));
					isVisited[rr][cc] = true;
					break;
				}
				
			}
		}//queue Empty
		
		//맵뒤집기
		changeMap(r,c);
		++time;
		
		isVisited = new boolean[N][M];
		queue.offer(new Node(r,c,time));
		isVisited[r][c] =true;
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			if(n.r == N-1 && n.c == M-1) {
				min = Math.min(min, n.time);
				return;
			}
			int i=0,j=0;
			switch(map[n.r][n.c]) {
			case 'A':
				i=0;j=4;
				break;
			case 'B':
				break;
			case 'C':
				i=0;j=2;
				break;
			case 'D':
				i=2;j=4;
				break;
			}
			
			for(; i<j;++i) {
				int rr = n.r + dr[i];
				int cc = n.c +dc[i];
				if(rr<0|| cc<0||rr>N-1||cc>M-1)
					continue;
				if(isVisited[rr][cc])
					continue;
				
				switch(map[rr][cc]) {
				case 'A':
					queue.offer(new Node(rr,cc,n.time+1));
					isVisited[rr][cc] = true;
					break;
				case 'B':
					break;
				case 'C':
					if(i==3||i==4)
						continue;
					queue.offer(new Node(rr,cc,n.time+1));
					isVisited[rr][cc] = true;
					break;
				case 'D':
					if(i==1 || i==2)
						continue;
					queue.offer(new Node(rr,cc,n.time+1));
					isVisited[rr][cc] = true;
					break;
				}
				
			}
		}//queue Empty
		
		
		//다음 위치 시작
		newStart(r,c,time);
		
	}
	private static void newStart(int r,int c,int time) {
		int i=0,j=0;
		switch(map[r][c]) {
		case 'A':
			i=0;j=4;
			break;
		case 'B':
			break;
		case 'C':
			i=0;j=2;
			break;
		case 'D':
			i=2;j=4;
			break;
		}
		
		for(; i<j;++i) {
			int rr = r + dr[i];
			int cc = c +dc[i];
			if(rr<0|| cc<0||rr>N-1||cc>M-1)
				continue;
			
			switch(map[rr][cc]) {
			case 'A':
				bfs(rr,cc,time+1);
				break;
			case 'B':
				break;
			case 'C':
				if(i==3||i==4)
					continue;
				bfs(rr,cc,time+1);
				break;
			case 'D':
				if(i==1 || i==2)
					continue;
				bfs(rr,cc,time+1);
				break;
			}
			
		}
	}
	private static void changeMap(int r, int c) {
		for(int i =0; i<r;++i) {
			if(map[i][c] == 'C')
				map[i][c] = 'D';
			else if(map[i][c] == 'D')
				map[i][c] = 'C';
		}
		for(int i =0; i<c;++i) {
			if(map[r][i] == 'C')
				map[r][i] = 'D';
			else if(map[r][i] == 'D')
				map[r][i] = 'C';
		}
	}
}

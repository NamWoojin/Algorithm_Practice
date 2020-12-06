import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _2151_거울설치 {
	static class Node implements Comparable<Node>{
		int r, c;
		int dir;		//방향
		int count = 0;	//거울 개수
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		Node(int r, int c,int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		Node(int r, int c,int dir,int count) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.count = count;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.count - o.count;
		}
	}

	static int N;
	static char[][] map;
	static int dr[] = { -1, 0, 1, 0 }; // 상,우,하,좌
	static int dc[] = { 0, -1, 0, 1 };
	static boolean visited[][][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new char[N][];
		visited=  new boolean[N][N][4];
		Node startDoor = null;	//시작할 #
		for (int i = 0; i < N; ++i) {
			map[i] = in.readLine().toCharArray();
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == '#') {
					startDoor = new Node(i, j);
				}
			}
		}
		
		PriorityQueue<Node> pQueue = new PriorityQueue<>();
		for(int i = 0; i<4;++i) {	//시작 문에 4가지 방향으로 큐에 넣기
			pQueue.offer(new Node(startDoor.r,startDoor.c,i));
			visited[startDoor.r][startDoor.c][i] = true;
		}
		
		int answer = 0;
		loop:while(!pQueue.isEmpty()) {
			Node n = pQueue.poll();
			int rr = n.r + dr[n.dir];
			int cc = n.c + dc[n.dir];
			
			if(rr < 0|| cc< 0|| rr>= N||cc>=N)	//범위 밖에 나가면
				continue;
			if(visited[rr][cc][n.dir])	//같은 위치에 같은 방향으로 방문한 적이 있다면
				continue;
			
			switch(map[rr][cc]) {
			case '.':	//가던 방향 그대로
				pQueue.offer(new Node(rr,cc,n.dir,n.count));
				visited[rr][cc][n.dir] = true;
				break;
			case '!':	//직진, 좌회전, 우회전
				pQueue.offer(new Node(rr,cc,n.dir,n.count));
				pQueue.offer(new Node(rr,cc,(n.dir+1)%4,n.count+1));
				pQueue.offer(new Node(rr,cc,(n.dir+3)%4,n.count+1));
				visited[rr][cc][n.dir] = true;
				visited[rr][cc][(n.dir+1)%4] = true;
				visited[rr][cc][(n.dir+3)%4] = true;
				break;
			case '#':	//도착
				answer = n.count;
				break loop;
			}
			
		}
		System.out.println(answer);
	}

	
}

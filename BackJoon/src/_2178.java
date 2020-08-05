import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2178 {
	private static int dr[] = {-1,1,0,0};
	private static int dc[] = {0,0,-1,1};
	private static int[][]maze;
	private static int ans;
	static boolean[][] visited;
	private static int N,M;
	public static void main(String[] args) throws IOException {
		//DFS로 풀면, 굉장히 짧은 거리가 있음에도 끝까지 가야 알 수 있기 때문에
		//최단거리 문제는 BFS가 유리함.
		//경로의 수는 DFS가 유리
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N+2][M+2];	//미로의 사방에 0이 생겨 못가게 됨.
		visited = new boolean[N+2][M+2];
		ans = N*M;
		for(int i = 1;i<=N;++i) {
			String str = in.readLine();
			for(int j = 0; j<M;++j) {
				maze[i][j+1] = str.charAt(j)-'0';
			}
		}
		visited[1][1] = true;
		cal(1,1,1);//처음도 1
		System.out.println(ans);
	}
	
	//각 상태가 가져야 하는 정보는, 어디있는지, 몇칸이나 왔는지.
	private static void cal(int r, int c, int cnt) {
		//기저파트 : 목적지에 도달
		if(cnt > ans)
			return;
		if(r==N && c == M) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		for(int i= 0; i<4;++i) {
			//갈 수 있는곳(벽이 아닌 곳)
			int nr = r+dr[i];
			int nc =c+dc[i];
			if(maze[nr][nc] == 0 || visited[nr][nc])
				continue;
			
			visited[nr][nc] = true;
			cal(nr,nc,cnt+1);
			visited[nr][nc] = false;
			
		}
	}
}

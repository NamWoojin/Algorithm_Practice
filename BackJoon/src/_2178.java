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
		//DFS�� Ǯ��, ������ ª�� �Ÿ��� �������� ������ ���� �� �� �ֱ� ������
		//�ִܰŸ� ������ BFS�� ������.
		//����� ���� DFS�� ����
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N+2][M+2];	//�̷��� ��濡 0�� ���� ������ ��.
		visited = new boolean[N+2][M+2];
		ans = N*M;
		for(int i = 1;i<=N;++i) {
			String str = in.readLine();
			for(int j = 0; j<M;++j) {
				maze[i][j+1] = str.charAt(j)-'0';
			}
		}
		visited[1][1] = true;
		cal(1,1,1);//ó���� 1
		System.out.println(ans);
	}
	
	//�� ���°� ������ �ϴ� ������, ����ִ���, ��ĭ�̳� �Դ���.
	private static void cal(int r, int c, int cnt) {
		//������Ʈ : �������� ����
		if(cnt > ans)
			return;
		if(r==N && c == M) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		for(int i= 0; i<4;++i) {
			//�� �� �ִ°�(���� �ƴ� ��)
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

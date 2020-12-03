import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2814_최장경로 {
	static int N,M,arr[],max;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int [N];
			max = 1;
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				arr[x] |= (1<<y);
				arr[y] |= (1<<x);
			}
			
			for(int i = 0; i<N;++i) {	//돌아가면서 시작점 선택
				dfs(i,1<<i,1);
			}
			
			System.out.println("#"+tc+" "+max);
			
		}
	}
	
	private static void dfs(int num,int visited, int count) {
		for(int i = 0 ; i<N;++i) {
			if((arr[num] &(1<<i))>0 && (visited & (1<<i)) == 0) {	//간선이 있고 방문하지 않았을 때
				dfs(i,visited|(1<<i),count+1);
			}
		}
		max = Math.max(count, max);
	}
	
	private static int dfs2(int num,int visited) {	//반환마다 +1씩 해서 반환하면 count를 들고다니지 않아도 됨
		int ret = 1;
		for(int i = 0 ; i<N;++i) {
			if((arr[num] &(1<<i))>0 && (visited & (1<<i)) == 0) {	//간선이 있고 방문하지 않았을 때
				ret = Math.max(dfs2(i,visited|(1<<i))+1,ret);
			}
		}
		return ret;
	}
}

/*
인접행렬이 인접리스트보다 유리한 점 : 해당 노드에 들어오는 간선 파악 가능(세로), 해당 노드에서 나가는 간선 파악 가능(가로)

방문체크 상태가 같고, 같은 점에 있을 때 기록된 값이 있다면 그 뒤의 흐름의 방식은 같으므로 더 계산하지 않는다. 
 */

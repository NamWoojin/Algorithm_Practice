import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17070_파이프옮기기1 {
	static boolean[][] array;
	static int N,cnt = 0;
	static int dr[] = {0,1,1};
	static int dc[] = {1,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		array = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = st.nextToken().equals("1") ? true : false;
			}
		}
		
		dfs(0,1,0);
		System.out.println(cnt);
	}
	
	static void dfs(int r, int c, int dir) {
		if(r== N-1 && c== N-1) {
			cnt++;
			return;
		}
		
		for(int i = -1; i<=1;++i) {
			int newDir = dir + i;
			if(newDir<0 || newDir>2 || Math.abs(newDir-dir) ==2)
				continue;
			
			int newR = r+dr[newDir];
			int newC = c+dc[newDir];
			
			if(newR > N-1 || newC >N-1)
				continue;
			
			if(array[newR][newC])
				continue;
			
			if(newDir == 1)
				if(array[newR-1][newC] || array[newR][newC-1])
					continue;
			
			dfs(newR,newC,newDir);
		}
	}
	
	
}

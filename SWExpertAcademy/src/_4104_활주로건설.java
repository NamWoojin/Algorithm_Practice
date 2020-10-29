import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4104_활주로건설 {

	static int N, X, map[][],count;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(in.readLine());
//		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			count = 0;
			map = new int[N][N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}

			for (int t = 0; t < 2; ++t) {
				for (int i = 0; i < N; ++i) {
					visited = new boolean[N];
					find(i, 1, t);
				}
			}
			System.out.println(count);
//			System.out.println("#" + tc + " " + count);
//		}
	}

	private static void find(int row, int idx, int dir) {
		if (idx >= N) {
			++count;
			return;
		}
		
		int diff = dir == 0 ? map[row][idx] - map[row][idx - 1] : map[idx][row] - map[idx - 1][row];
		switch (diff) {
		case 1: // 올라갈 때
			int num = dir == 0 ?map[row][idx-1]:map[idx-1][row];
			for(int i = 1; i<=X;++i) {
				if(idx-i<0)
					return;
				
				if(dir == 0) {
					if(map[row][idx-i] == num && !visited[idx-i]) {
						visited[idx-i] = true;
					}
					else {
						return;
					}
				}else {
					if(map[idx-i][row] == num && !visited[idx-i]) {
						visited[idx-i] = true;
					}
					else {
						return;
					}
				}
			}
			find(row,idx+1,dir);
			break;
		case 0: // 같은 레벨
			find(row,idx+1,dir);
			break;
		case -1: // 내려갈때
			
			num = dir == 0 ?map[row][idx]:map[idx][row];
			
			for(int i = 0; i<X;++i) {
				if(idx+i>=N)
					return;
				if(dir == 0) {
					if(map[row][idx+i] == num && !visited[idx+i]) {
						visited[idx+i] = true;
					}
					else {
						return;
					}
				}else {
					if(map[idx+i][row] == num && !visited[idx+i]) {
						visited[idx+i] = true;
					}
					else {
						return;
					}
				}
			}
			find(row,idx+X,dir);
			break;
		default: // 차이가 2 이상
			return;
		}

	}
}

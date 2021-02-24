import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17822_원판돌리기 {
	static int topIndex[], circles[][];
	static int sum, count;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		circles = new int[N+2][M];
		topIndex = new int[N+2];
		count = N * M;
		for(int i = 1; i<=N;++i) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<M;++j) {
				circles[i][j] = Integer.parseInt(st.nextToken());
				sum += circles[i][j];
			}
		}
		
		for(int order = 0; order<T;++order) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int addNum = d == 0 ?   M-k:k;
			for(int j = x; j<=N;j += x) {	//회전판 회전
				topIndex[j] += addNum;
				topIndex[j] %= M;
			}
			
			int[][] tempCircles = new int[N+2][M];
			boolean isEqual = false;
			for(int i = 1; i<=N;++i) {
				for(int j = 0; j<M;++j) {
					if(circles[i][j] != 0) {
						int number = circles[i][j];
						int diff = M - (topIndex[i]-j);
//						System.out.println(circles[i+1][(topIndex[i+1]+diff)%M]);
//						System.out.println(circles[i-1][(topIndex[i-1]+diff)%M]);
						if(number == circles[i+1][(topIndex[i+1]+diff)%M] || number == circles[i-1][(topIndex[i-1]+diff)%M] || number == circles[i][(j+1)%M] || number == circles[i][(j+M-1)%M]) {	// 인접한 것중 같은 값이 있으면
							isEqual = true;
							sum -= circles[i][j];
							--count;
						}
						else {	// 인접한 것중 같은 값이 없으면
							tempCircles[i][j] = circles[i][j];
						} 
					}
				}
			}
			if(!isEqual) {	//같은 것이 없었을 경우
				float average = sum/(float)count;
				sum = 0;
				for(int i = 1; i<=N;++i) {
					for(int j = 0; j<M;++j) {
						if(tempCircles[i][j] != 0) {
							tempCircles[i][j] += tempCircles[i][j] > average ? -1:+1;
							sum += tempCircles[i][j];
						}
					}
				}
			}
			
			circles = tempCircles;
		}
		System.out.println(sum);
	}
}

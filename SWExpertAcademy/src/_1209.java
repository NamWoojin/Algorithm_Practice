import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1209 {
	private static int N = 100;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb =new StringBuffer();
		for(int tc = 1; tc<=10;++tc) {
			StringTokenizer st;
			in.readLine();
			int[][] arr = new int[N][N];
			for(int i = 0; i<N;++i) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j<N;++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max= 0;
			int rightDownSum = 0;
			int leftDownSum = 0;
			for(int i = 0; i<N;++i) {
				int horizontalSum = 0;
				int verticalSum = 0;
				
				for(int j = 0; j<N;++j) {
					horizontalSum += arr[i][j];
					verticalSum += arr[j][i];
					if(i == j)
						rightDownSum += arr[i][j];
					if(i == N-j)
						leftDownSum += arr[i][j];
				}
				max = max < horizontalSum ? horizontalSum : max;
				max = max < verticalSum ? verticalSum:max;
			}
			max = max < rightDownSum ? rightDownSum:max;
			max = max < leftDownSum ? leftDownSum:max;
			
			sb.append("#").append(tc).append(" ").append(max);
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
}

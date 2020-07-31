import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[] towers = new int[N];
		int[] heights = new int[100000000];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int max = 0;
		
		for (int i = 0; i < N; ++i) {
			towers[i] = Integer.parseInt(st.nextToken());
			heights[towers[i]] = i;
			
			if (max < towers[i]) {
				max = towers[i];
				result.append("0 ");
			} else {
//				for(int j = towers[i]-1;j>0;--j) {
//					if(heights[j] != 0) {
//						result.append(heights[j]+1).append(" ");
//						break;
//					}
//				}
				
				for (int j = i - 1; j >= 0; --j) {
					if (towers[i] <= towers[j]) {
						result.append(j + 1).append(" ");
						break;
					}
				}
			}
		}
		System.out.println(result);

	}

}

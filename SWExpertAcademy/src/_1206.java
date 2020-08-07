import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1206 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb =new StringBuffer();
		for(int tc = 1; tc<=10;++tc) {
			
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i = 0; i<N;++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int sum =0;
			for(int i = 2;i<N-2;++i) {
				int Max = Math.max(Math.max(arr[i-1], arr[i-2]),Math.max(arr[i+1], arr[i+2]));
				if(arr[i] <= Max)
					continue;
				sum += arr[i] - Max;
			}
			sb.append("#").append(tc).append(" ").append(sum);
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
}

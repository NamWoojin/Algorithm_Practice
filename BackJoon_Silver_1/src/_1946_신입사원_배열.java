import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1946_신입사원_배열 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N+1];
			StringTokenizer st;	
			for(int i = 0; i<N;++i){
				st = new StringTokenizer(in.readLine());
				arr[Integer.parseInt(st.nextToken())]=Integer.parseInt(st.nextToken());
			}
			int count = 1;
			int BigB = arr[1];
			for(int i = 1; i<=N;++i) {
				if(BigB == 1) {
					break;
				}
				if(arr[i] < BigB) {
					++count;
					BigB = arr[i];
				}
			}
			System.out.println(count);
		}
	}
}

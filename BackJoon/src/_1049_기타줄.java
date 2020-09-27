import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1049_기타줄 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int minXI = Integer.MAX_VALUE;
		int minI = Integer.MAX_VALUE;
		for(int i =0; i<M;++i) {
			st =  new StringTokenizer(in.readLine());
			minXI = Math.min(Integer.parseInt(st.nextToken()),minXI);
			minI = Math.min(Integer.parseInt(st.nextToken()),minI);
		}
		int ans = 0;
		if(minI*6 <= minXI) {
			ans = minI * N;
		}else {
			ans = minXI *(N/6 + (N%6>0?1:0));
			ans = Math.min(ans, N/6*minXI + N%6 * minI);
		}
		System.out.println(ans);
	}
}

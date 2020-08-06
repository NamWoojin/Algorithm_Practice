import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6730 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			int N  = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			int[] arr = new int[N];
			int upMax=0;
			int downMax = 0;
			for(int i = 0; i<N;++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 1; i<N;++i) {
				int mul = arr[i]-arr[i-1];
				if(mul>0)
					upMax = upMax < mul ? mul : upMax;
				else
					downMax =downMax > mul ? mul:downMax;
			}
			sb.append("#").append(tc).append(" ").append(upMax).append(" ").append(Math.abs(downMax));
			System.out.println(sb.toString());
			sb.setLength(0);
			
		}
	}
}

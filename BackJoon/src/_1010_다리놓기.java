import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1010_다리놓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T  = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			long N = Integer.parseInt(st.nextToken());
			long M = Integer.parseInt(st.nextToken());
			System.out.println(fact(M,N)/fact(M-N,0L));
		}
	}
	
	
	private static long fact(long num,long end) {
		if(num<=end)
			return end+1;
		return num *fact(num-1,end);
	}
	
	
}

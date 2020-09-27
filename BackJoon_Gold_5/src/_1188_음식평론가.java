import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1188_음식평론가 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		System.out.println(M- gcd(N,M));
	}
	
	private static int gcd(int a, int b) {
		if(b == 0) 
			return a;
		return gcd(b,a%b);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1699_제곱수의합 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(in.readLine());
		int d[] = new int[N+1];
		for(int i = 1;i<=N;++i)
			d[i] = i;
		for(int i = 2;i<=N;++i) {
			for(int j = 2;j*j<=i;++j) {
				d[i] = Math.min(d[i], d[i-j*j]+1);
			}
		}
		System.out.println(d[N]);
	}
	
}

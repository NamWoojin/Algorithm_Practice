import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _8567_약수의개수가많은수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int[] arr = new int[10001];
		for(int i = 1; i<10001;++i) {
			for(int j = 1; j<=i/2;++j) {
				if(i%j ==0) {
					++arr[i];
					if(i/j != j) {
						++arr[i];
					}
				}
			}
		}
		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(in.readLine());
			int num = 0;
			int max = 0;
			for(int i =1;i<=N;++i) {
				if(max <= arr[i]) {
					max = arr[i];
					num = i;
				}
			}
			System.out.println("#"+tc+" "+num);
		}
	}
}	

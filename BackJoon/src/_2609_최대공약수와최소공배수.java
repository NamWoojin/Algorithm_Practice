import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		System.out.println(GCD(num1,num2));
		System.out.println(LCM(num1,num2));
	}
	
	private static int GCD(int num1, int num2) {
		if(num2 == 0) {
			return num1;
		}
		return GCD(num2,num1%num2);
	}
	
	private static int LCM(int num11, int num22) {
		int[][] used = new int[10001][2];
		int num1 = num11;
		int num2 = num22;
		while(num1 > 1) {
			for (int i = 2; i <= num1; ++i) {
				if(num1 % i == 0) {
					++used[i][0];
					num1 /= i;
					break;
				}
			}
		}
		while(num2 > 1) {
			for (int i = 2; i <= num2; ++i) {
				if(num2 % i == 0) {
					++used[i][1];
					num2 /= i;
					break;
				}
			}
		}
		
		int lcm = 1;
		int max= Math.max(num11, num22);
		for(int i = 2; i<=max;++i) {
			if(used[i][0] == 0 && used[i][1] == 0)
				continue;
			
			lcm *= Math.pow(i, Math.max(used[i][0], used[i][1]));
		}
		return lcm;
	}
}	

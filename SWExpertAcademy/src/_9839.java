import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9839 {
	static int[] array;
	static int N;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			N = Integer.parseInt(in.readLine());
			array = new int[N];
			max = -1;
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i =0; i<N;++i) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			find(0,0,1);
			sb.append("#").append(tc).append(" ").append(max);
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
	
	static void find(int idx,int choice,int mul) {
		if(choice == 2) {
			if(Condition(mul)) {
				max = Math.max(mul, max);
			}
			return;
		}
		if(idx == N)
			return;
		
		find(idx+1,choice,mul);
		find(idx+1,choice+1,mul*array[idx]);
	}
	
	static boolean Condition(int mul) {
		int prev = mul%10;
		mul /= 10;
		while(mul>=1) {
			if(mul %10 != prev - 1) {
				return false;
			}
			prev  = mul %10;
			mul /= 10;
		}
		return true;
	}
}




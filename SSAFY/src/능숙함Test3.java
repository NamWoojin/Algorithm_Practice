import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 능숙함Test3 {
	static int n;
	static String str;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		str = in.readLine();
		n = str.length();
//		System.out.println(solve(0,""));
		solve(0);
	}
	
//	static String solve(int idx,String st) {
//		if(idx == n) {
//			return st;
//		}
//		
//		return solve(idx+1,st+str.charAt(idx)) + str.charAt(idx);
//	}
	
	static void solve(int idx) {
		if(idx == n) {
			System.out.println();
			return;
		}
		System.out.print(str.charAt(idx));
		solve(idx+1);
		System.out.print(str.charAt(idx));
	}
}

package AlgorithmDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		solve(0,"");
	}
	
	static void solve(int idx,String str) {
		if(idx == N) {
			System.out.println(str);
			return;
		}
		for(int i = 1 ;i<=6;++i) {
			solve(idx+1,str+" "+i);
		}
	}
}

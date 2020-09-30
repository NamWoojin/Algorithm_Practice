import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14888_연산자끼워넣기 {
	static int signCnt[],N,max = -Integer.MAX_VALUE,min = Integer.MAX_VALUE;
	static int num[],sign[]; 
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		num = new int[N];
		sign = new int[N-1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i =0; i<N;++i) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		signCnt = new int[4];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<4;++i) {
			signCnt[i] = Integer.parseInt(st.nextToken());
		}
		makeOrder(0);
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void makeOrder(int idx) {
		if(idx == N-1) {
			doCalculate();
			return;
		}
		for(int i = 0; i<4;++i) {
			if(signCnt[i] != 0) {
				--signCnt[i];
				sign[idx] = i;
				makeOrder(idx+1);
				++signCnt[i];
			}
		}
		
	}
	
	private static void doCalculate() {
		int idx = 0;
		int ans = num[0];
		while(idx < N-1) {
			int s = sign[idx];
			int n = num[idx+1];
			ans = operator(ans,n,s);
			++idx;
		}
		
		max = Math.max(max, ans);
		min = Math.min(min, ans);
	}
	
	private static int operator(int num1,int num2,int operator) {
		switch(operator) {
		case 0:
			return num1 + num2;
		case 1:
			return num1-num2;
		case 2:
			return num1 * num2;
		case 3:
			if(num1 >= 0)
				return num1/num2;
			else
				return -((-num1)/num2);
		}
		return -1;
	}
}

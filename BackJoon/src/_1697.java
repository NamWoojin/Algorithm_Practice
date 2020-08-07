import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1697 {
	static int N;
	static int K;
	static int min = 100000;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		min = 100000;
		
		if(N == K) {
			min = 0;
		}
		else if(N>K) {
			min = N-K;
		}
		else {
			//곱해서 K 넘어가는 숫자 찾기
			//그 숫자 에서 작아져가면서 최소점 찾기
			int times = 0;	//소요된 시간
			int calculate = N;	//계산 값
			for(times = 0;; times++) {
				if(calculate >= K) {
					break;
				}
				calculate *= 2;
			}
			int add = (times-1)+(K-calculate/2);
			int sub = times+(calculate-K);
			min = Math.min(add,sub);
			find(N,0,times);
			
		}
		System.out.println(min);
		
	}
	
	private static void find(int num,int count, int multipleNum) {
		if(count >= min || num < 0 || num>100000) 
			return;
		
		if(num == K) {
			min = min > count ? count: min;
			return;
		}
		
		if(multipleNum >0)
			find(num * 2,count+1,multipleNum-1);
		find(num - 1,count+1,multipleNum);
		find(num + 1,count+1,multipleNum);
	}
	
}

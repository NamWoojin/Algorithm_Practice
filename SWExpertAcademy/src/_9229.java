import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9229 {
	static int M;
	static int N;
	static int[] arr;
	static int num = 2;
	static int max = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc =1;tc<=T;++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			max = -1;
			arr = new int[N];
			st = new StringTokenizer(in.readLine());
			for(int i =0;i<N;++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Combination(0,0,0);
			
			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(max);
		}
	}
	
	private static void Combination(int idx,int c_idx,int weight) {
		if(idx == N || c_idx == 2) {	//모든 경우를 계산했을 때 또는 두 봉지일 때
			if(c_idx != 2)	//두 봉지가 아니면 X
				return;
			if(weight <= M && weight > max) {
				max = weight;
			}
			return;
		}
		
		Combination(idx+1,c_idx+1,weight+arr[idx]);
		Combination(idx+1,c_idx,weight);
	}
}




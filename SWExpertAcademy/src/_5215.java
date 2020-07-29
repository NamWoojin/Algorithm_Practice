import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5215 {
	static int[] T;	//만족도 점수
	static int[] K;	//칼로리
	static int L;	//제한 칼로리
	static int maxGood = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int Test = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=Test;++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			T = new int[N];
			K = new int[N];
			maxGood = 0;
			for(int i = 0;i<N;++i) {
				st = new StringTokenizer(in.readLine()," ");
				T[i] = Integer.parseInt(st.nextToken());
				K[i] = Integer.parseInt(st.nextToken());
			}
			
			Calculate(0,0,0);
			
			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(maxGood);
		}
	}
	
	//조합
	private static void Calculate(int idx,int good,int kcal) {
		if(idx == T.length) {
			if(kcal<=L){
				if(maxGood<good)
					maxGood = good;
			}
			return;
		}
		Calculate(idx+1,good,kcal);
		Calculate(idx+1,good+T[idx],kcal+K[idx]);
	}

}






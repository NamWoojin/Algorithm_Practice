import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5215 {
	static int[] T;	//������ ����
	static int[] K;	//Į�θ�
	static int L;	//���� Į�θ�
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
	
	//����
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






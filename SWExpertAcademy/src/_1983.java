import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1983 {
	private static String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			StringTokenizer st =new StringTokenizer(in.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			float[] score = new float[N]; 
			for(int i = 0;i<N;++i) {
				st = new StringTokenizer(in.readLine()," ");
				score[i] = (float) (Integer.parseInt(st.nextToken())*0.35+Integer.parseInt(st.nextToken())*0.45+Integer.parseInt(st.nextToken())*0.2);
			}
			int count = 0;
			for(int i = 0; i<N;++i) {
				if(i == (K-1))
					continue;
				
				if(score[i] > score[K-1])
					++count;
			}
			
			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(grade[(int)(count/(N/10))]);
		}
	}
}

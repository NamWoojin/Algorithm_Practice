import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2961 {
	static class Food{
		int sour;
		int bitter;
		

		public Food(int sour, int bitter) {
			super();
			this.sour = sour;
			this.bitter = bitter;
		}
	}
	static int N;
	static int min = 1000000000;
	static Food[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new Food[N];
		StringTokenizer st;
		for(int i = 0; i<N;++i) {
			st = new StringTokenizer(in.readLine());
			arr[i] = new Food(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Calculate(0,1,0);
		System.out.println(min);
		
	}
	
	static void Calculate(int idx,int sour,int bitter) {
		if(idx == N) {
			if(sour == 1 && bitter == 0)	//아무것도 선택 안하는 경우
				return;
			int num = Math.abs(sour - bitter);
			min = min> num ? num: min;
			return;
		}
		Calculate(idx+1,sour,bitter);
		Calculate(idx+1,sour*arr[idx].sour,bitter+arr[idx].bitter);
	}
}

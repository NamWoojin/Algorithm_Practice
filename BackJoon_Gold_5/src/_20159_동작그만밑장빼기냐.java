import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20159_동작그만밑장빼기냐 {
	static int N,cards[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		cards = new int[N+1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 1; i<=N;++i) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		int adds[][] = new int[N/2+2][2];
		for(int i = 0; i<=N;++i) {
			int num = i%2;
			if(num == 1) {
				adds[i/2 + 1][num] = adds[i/2][num] + cards[i];	//홀수번 째 (앞에서부터 더하기)
			}else {
				adds[(N-i)/2][num] = adds[(N-i)/2+1][num] + cards[N-i];	//짝수번 째(뒤에서부터 더하기)
			}
		}
		
		int max = 0;
		for(int i = 0; i <= N/2 ;++i) {	
			max = Math.max(max,adds[i+1][0]+ adds[i][1]);			//정훈이 차례에 밑장빼기 할 때
			max = Math.max(max,adds[i][0]+ adds[i][1] - cards[N]);	//상대 차례에 밑장빼기 할 때
		}
		System.out.println(max);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20055_컨베이어벨트위의로봇 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int length = N*2;
		int[] arr = new int[length];
		boolean[] robotPos = new boolean[N];
		st = new StringTokenizer(in.readLine());
		int zero = 0;
		for (int i = 0; i < length; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] == 0)
				++zero;
		}
		
		int level = 0;
		int upIdx = 0;
		while(zero<K) {
			upIdx = upIdx == 0? length-1:upIdx-1;
			robotPos[N-1] = false;
			for(int i = N-2;i>=0;--i) {
				if(robotPos[i] && !robotPos[i+1] && arr[(upIdx+i)%length]>=1) {
					--arr[(upIdx+i)%length];
					robotPos[i] = false;
					robotPos[i+1] = true;
					if(arr[(upIdx+i)%length]==0)
						++K;
				}
			}
			robotPos[N-1] = false;
			if(!robotPos[0] ) {
				
			}
			
			++level;
		}
		System.out.println(level);
	}
}

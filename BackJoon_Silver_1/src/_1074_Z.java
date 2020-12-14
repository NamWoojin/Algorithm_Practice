import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074_Z {
	static int N,r,c,answer = 0;
	static int dr[] = {0,0,1,1};
	static int dc[] = {0,1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dynamic((int)Math.pow(2, N),0,0);
		System.out.println(answer);
	}
	static boolean dynamic(int num, int rr, int cc) {
		if(rr == r && cc == c) {
			return true;
		}
		if(num == 1) {
			++answer;
			return false;
		}
		for(int i = 0; i<4;++i) {
			if(rr+dr[i]*num/2 <= r && rr+dr[i]*num/2+num/2 > r &&
					cc+dc[i]*num/2 <= c && cc+dc[i]*num/2+num/2 > c) {
				if(dynamic(num/2,rr+dr[i]*num/2,cc+dc[i]*num/2))
					return true;
			}
			else {
				answer += (num/2 * num/2);
			}
//			if(dynamic(num/2,rr+dr[i]*num/2,cc+dc[i]*num/2))
//				return true;
		}
		return false;
	}
}

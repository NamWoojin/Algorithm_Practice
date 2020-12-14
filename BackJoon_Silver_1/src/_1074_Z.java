import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074_Z {
	static int N,r,c,answer = 0;
	static int dr[] = {0,0,1,1};	//좌상,우상,좌하,우하
	static int dc[] = {0,1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dynamic((int)Math.pow(2, N),0,0);	//2차원 배열의 크기,0,0으로 시작
		System.out.println(answer);
	}
	static boolean dynamic(int num, int rr, int cc) {
		if(rr == r && cc == c) {	// r,c를 만났을 때 true반환
			return true;
		}
		for(int i = 0; i<4;++i) {
			if(rr+dr[i]*num/2 <= r && rr+dr[i]*num/2+num/2 > r &&
					cc+dc[i]*num/2 <= c && cc+dc[i]*num/2+num/2 > c) {	//4등분한 2차원배열 파트 각각에 (r,c)가 포함되는지 확인
				if(dynamic(num/2,rr+dr[i]*num/2,cc+dc[i]*num/2))	// (r,c)가 포함되는 배열 파트에 재귀를 통해 접근
					return true;									// r,c를 만났을 때 true반환
			}
			else {
				answer += (num/2 * num/2);	//(r,c)가 포함되는 배열 파트가 아니라면 해당 파트에 있는 칸의 개수 모두 더해주기
			}
		}
		return false;
	}
}

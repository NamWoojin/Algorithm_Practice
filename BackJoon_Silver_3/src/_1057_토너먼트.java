import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1057_토너먼트 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int round = 1;
		while (true) {
			if (K == L) {
				--round;
				break;
			}
			if(K==0|| L==0) {
				round = -1;
				break;
			}
			K = K / 2 + (K % 2 == 1 ? 1 : 0);
			L = L / 2 + (L % 2 == 1 ? 1 : 0);
			++round;
		}
		System.out.println(round);
	}
}

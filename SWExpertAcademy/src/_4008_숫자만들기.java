import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4008_숫자만들기 {
	static int N, cals[], numbers[], min, max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(in.readLine());
			cals = new int[4];
			numbers = new int[N];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 4; ++i) {
				cals[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; ++i) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			solve(1,numbers[0]);
			
			System.out.println("#"+tc+" "+(max-min));
		}
	}

	private static void solve(int idx,int result) {
		if (idx == N) {
			max = Math.max(result, max);
			min = Math.min(result, min);
			return;
		}

		for (int i = 0; i < 4; ++i) {
			if (cals[i] > 0) {
				--cals[i];
				switch(i) {
				case 0:
					solve(idx+1,result + numbers[idx]);
					break;
				case 1:
					solve(idx+1,result - numbers[idx]);
					break;
				case 2:
					solve(idx+1,result * numbers[idx]);
					break;
				case 3:
					solve(idx+1,result / numbers[idx]);
					break;
				}
				++cals[i];
			}
		}
	}

}

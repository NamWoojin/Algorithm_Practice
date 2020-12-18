import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1034_램프 {
	static int N, M, K, max = 0;
	static long ones = 0, lamps[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lamps = new long[M];
		for (int i = 0; i < N; ++i) {
			char[] chars = in.readLine().toCharArray();
			for (int j = 0; j < M; ++j) {
				if (chars[j] == '1')
					lamps[j] = lamps[j] | (1 << i);
			}
		}
		K = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; ++i) { // xor을 위한 111111... 숫자 만들기
			ones |= (1 << i);
		}

		solve(0);

		System.out.println(max);

	}

	static void solve(int idx) {
		if (idx == K) {
			max = Math.max(max, countLight());
			return;
		}

		for (int i = 0; i < M; ++i) {
			lamps[i] ^= ones;
			solve(idx + 1);
			lamps[i] ^= ones;
		}
	}

	static int countLight() {
		int total = 0;

		next: for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if ((lamps[j] & (1 << i)) == 0)
					continue next;
			}
			++total;
		}

		return total;
	}
}

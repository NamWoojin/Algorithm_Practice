import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17490_일감호에다리놓기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		if(M == 0) {
			System.out.println("YES");
		}else {
			int[] stones = new int[N];
			int[] minStones = new int[M];
			

			boolean[] construction = new boolean[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; ++i) {
				stones[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(in.readLine());
				int ii = Integer.parseInt(st.nextToken());
				int jj = Integer.parseInt(st.nextToken());
				int num = Math.min(ii, jj);
				if(Math.abs(ii-jj) != 1)
					num = N;
				construction[num-1] = true;
			}

			Arrays.fill(minStones, Integer.MAX_VALUE);

			int idx = 0;
			for (int i = 0; i < N; ++i) {
					minStones[idx % M] = Math.min(minStones[idx % M], stones[i]);
					if (construction[i])
						++idx;
			}

			for (int i = 0; i < M; ++i) {
				K -= minStones[i];
			}
			
			System.out.println(K < 0 ? "NO" : "YES");
		}
		
	}
}

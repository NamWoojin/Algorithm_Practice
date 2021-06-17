import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int[] trees = new int[N];
		long max = 0;
		long min = 0;
		for (int i = 0; i < N; ++i) {
			trees[i] = Integer.parseInt(st.nextToken());
			if (max < trees[i]) {
				max = trees[i];
			}
		}
		
		long answer = 0;
		while(min <= max) {
			long height = (min + max) / 2;
			if(canGet(height, M, trees)) {
				answer = height;
				min = height+1;
			}else {
				max = height-1;
			}
		}
		
		System.out.println(answer);

	}

	private static boolean canGet(long h, int m, int[] trees) {
		long sum = 0;
		for (int i = 0; i < trees.length; ++i) {
			long diff = trees[i] - h;
			if (diff > 0) {
				sum += diff;
			}
		}

		return sum >= m;
	}
}

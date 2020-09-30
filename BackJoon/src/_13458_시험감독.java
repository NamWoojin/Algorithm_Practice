import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13458_시험감독 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		long sum = 0L;
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; ++i) {
			++sum;
			A[i] -= B;
			if(A[i]>0)
				sum += (A[i] / C) + (A[i] % C > 0 ? 1 : 0);

		}
		System.out.println(sum);
	}
}

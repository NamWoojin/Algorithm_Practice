import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15961_회전초밥 {
	static int N, d, k, c, max = 0, count = 0;
	static int[] array;
	static int[] check;
	static int startPoint = 0;
	static int endPoint = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		array = new int[N];
		check = new int[d + 1];
		for (int i = 0; i < N; ++i) {
			array[i] = Integer.parseInt(in.readLine());
		}

		for (endPoint = 0; endPoint < k; ++endPoint) {
			if (++check[array[endPoint]] == 1) {
				++count;
			}
		}

		while (startPoint != N) {

			if (--check[array[startPoint++]] == 0)
				--count;
			
			if(endPoint==N)
				endPoint = 0;
			
			if (++check[array[endPoint++]] == 1)
				++count;

			max = check[c] == 0 ? Math.max(count+1, max):Math.max(count, max);
		}
		System.out.println(max);
	}
}

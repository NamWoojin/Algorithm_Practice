import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1107_리모컨 {
	static StringBuilder bigger = new StringBuilder(), smaller = new StringBuilder();
	static int count = 0;
	static int min = 0, max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		boolean[] broken = new boolean[10];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; ++i) {
			broken[Integer.parseInt(st.nextToken())] = true;
		}
		count = Math.abs(100 - N);
		min = N;
		max = N;
	}
	
	
	
}

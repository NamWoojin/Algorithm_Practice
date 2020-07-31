import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _15651 {
	static int N = 0;
	static int M = 0;
	static StringBuffer result = new StringBuffer();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		perm(0);
	}

	private static void perm(int idx) throws IOException {
		if (idx == M) {
			bw.write(result.toString());
			bw.flush();
			bw.newLine();
			
			return;
		}

		for (int i = 0; i < N; ++i) {
			result.append(i+1).append(" ");
			perm(idx + 1);
			result.setLength(result.length()-2);
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i<=N;++i) {
			list.add(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int value = -1;
		for(int i = 0; i<N;++i) {
			value = (value+K)%(N-i);
			sb.append(list.get(value)+", ");
			list.remove(value);
			value--;
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}
}

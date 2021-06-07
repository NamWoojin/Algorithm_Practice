import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//에라토스테네스의 체 이용

public class _1929_소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean arr[] = new boolean[N + 1];
		for (int i = 2; i <= N; ++i) {
			if (arr[i]) {
				continue;
			}
			int num = i + i;
			while (num <= N) {
				arr[num] = true;
				num += i;
			}
		}
		StringBuilder sb = new StringBuilder();
		int start = Math.max(M, 2);	//1은 소수에 포함되지 않음
		for (int i = start; i <= N; ++i) {
			if (!arr[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
}

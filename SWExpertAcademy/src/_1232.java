import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1232 {
	static class Node {
		int num = 0;
		String in = "";
		int next1 = 0;
		int next2 = 0;

		public Node(int num, String in, int next1, int next2) {
			super();
			this.num = num;
			this.in = in;
			this.next1 = next1;
			this.next2 = next2;
		}

		public Node(int num, String in) {
			super();
			this.num = num;
			this.in = in;
		}

	}

	static Node[] array;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for (int tc = 1; tc <= 10; ++tc) {
			StringTokenizer st;
			int N = Integer.parseInt(in.readLine());
			array = new Node[N+1];
			for (int i = 1; i <= N; ++i) {
				st = new StringTokenizer(in.readLine());
				array[i] = new Node(Integer.parseInt(st.nextToken()), st.nextToken());
				if (st.hasMoreTokens()) {
					array[i].next1 = Integer.parseInt(st.nextToken());
					array[i].next2 = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("#").append(tc).append(" ").append(Integer.parseInt(calculate(1)));
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}

	static String calculate(int idx) {

		if (array[idx].next1 != 0) {
			int nxt1 = Integer.parseInt(calculate(array[idx].next1));
			int nxt2 = Integer.parseInt(calculate(array[idx].next2));

			switch(array[idx].in) {
			case "+":
				return Integer.toString(nxt1 + nxt2);
			case "-":
				return Integer.toString(nxt1 - nxt2);
			case "*":
				return Integer.toString(nxt1 * nxt2);
			case "/":
				return Integer.toString(nxt1 / nxt2);
			}
		}

		return array[idx].in;

	}
}

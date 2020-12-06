import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 짧은 길이 *2 + 길이 차 * 2 - (길이 차 % 2)	//홀수일 때 1 빼기
 * 짧은 길이 : 시작점에서 도착점의 행 또는 열에 도달하는 길이
 */
public class _8382_방향전환_홍쌤 {
	static class Node {
		int r, c;
		int move;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		Node(int r, int c, int move) {
			this.move = move;
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Node end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			int a = Math.abs(start.r - end.r); // 행 거리
			int b = Math.abs(start.c - end.c); // 열 거리

			int sh = Math.min(a, b);
			int lo = Math.max(a, b);

			int dif = lo - sh;
			int ans = sh * 2 + dif * 2 - (dif % 2);
			System.out.println("#" + tc + " " + ans);

		}
	}
}

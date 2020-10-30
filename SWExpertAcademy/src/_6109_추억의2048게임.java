import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _6109_추억의2048게임 {
	public enum DIR {
		left, right, up, down
	}

	static int map[][], N, answer[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			DIR dir = DIR.valueOf(st.nextToken());
			map = new int[N][N];
			answer = new int[N][N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			switch (dir) {
			case left:
				left();
				break;
			case right:
				right();
				break;
			case up:
				up();
				break;
			case down:
				down();
				break;
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			for (int i = 0; i < N; ++i) {
				sb.append("\n");
				for (int j = 0; j < N; ++j) {
					sb.append(answer[i][j]).append(" ");
				}
				sb.setLength(sb.length() - 1);
				
			}

			System.out.println(sb.toString());
		}
	}

	public static void left() {
		for (int i = 0; i < N; ++i) {
			Deque<Integer> dq = new ArrayDeque<>();
			boolean prev = true;
			for (int j = 0; j < N; ++j) {
				if (map[i][j] != 0) {
					if (!dq.isEmpty() && prev && dq.peekLast() == map[i][j]) {
						dq.addLast(dq.pollLast() * 2);
						prev = false;
					} else {
						dq.addLast(map[i][j]);
						prev = true;
					}
				}
			}
			int idx = 0;
			while (!dq.isEmpty()) {
				answer[i][idx++] = dq.pop();
			}
		}
	}

	public static void right() {
		for (int i = 0; i < N; ++i) {
			Deque<Integer> dq = new ArrayDeque<>();
			boolean prev = true;
			for (int j = N-1; j >= 0; --j) {
				if (map[i][j] != 0) {
					if (!dq.isEmpty() && prev && dq.peekLast() == map[i][j]) {
						dq.addLast(dq.pollLast() * 2);
						prev = false;
					} else {
						dq.addLast(map[i][j]);
						prev = true;
					}
				}
			}
			int idx = N-1;
			while (!dq.isEmpty()) {
				answer[i][idx--] = dq.pop();
			}
		}
	}
	
	public static void up() {
		for (int i = 0; i < N; ++i) {
			Deque<Integer> dq = new ArrayDeque<>();
			boolean prev = true;
			for (int j = 0; j <N ; ++j) {
				if (map[j][i] != 0) {
					if (!dq.isEmpty() && prev && dq.peekLast() == map[j][i]) {
						dq.addLast(dq.pollLast() * 2);
						prev = false;
					} else {
						dq.addLast(map[j][i]);
						prev = true;
					}
				}
			}
			int idx = 0;
			while (!dq.isEmpty()) {
				answer[idx++][i] = dq.pop();
			}
		}
	}
	
	public static void down() {
		for (int i = 0; i < N; ++i) {
			Deque<Integer> dq = new ArrayDeque<>();
			boolean prev = true;
			for (int j = N-1; j >= 0; --j) {
				if (map[j][i] != 0) {
					if (!dq.isEmpty() && prev && dq.peekLast() == map[j][i]) {
						dq.addLast(dq.pollLast() * 2);
						prev = false;
					} else {
						dq.addLast(map[j][i]);
						prev = true;
					}
				}
			}
			int idx = N-1;
			while (!dq.isEmpty()) {
				answer[idx--][i] = dq.pop();
			}
		}
	}
}

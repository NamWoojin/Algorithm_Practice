import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _15686_드래곤커브_re {
	static class Node {
		int y;
		int x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };
	static boolean[][] map;
	static Stack<Integer> stack1, stack2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		map = new boolean[101][101];
		for (int i = 1; i <= N; ++i) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			stack1 = new Stack<>();
			stack2 = new Stack<>();
			map[y][x] = true;
			map[y + dy[d]][x + dx[d]] = true;
			stack1.push(d);
			Node start = new Node(y + dy[d], x + dx[d]);
			for (int j = 1; j <= g; ++j) {
				stack2 = (Stack<Integer>) stack1.clone();

				while (!stack1.isEmpty()) {
					int dir = (stack1.pop() + 1) % 4;
					start.y += dy[dir];
					start.x += dx[dir];
					map[start.y][start.x] = true;
					stack2.push(dir);
				}
				stack1 = (Stack<Integer>) stack2.clone();


			}

		}
		int count = 0;
		for (int r = 0; r < 100; ++r)
			for (int c = 0; c < 100; ++c)
				count += (map[r][c] && map[r + 1][c + 1] && map[r + 1][c] && map[r][c + 1]) ? 1 : 0;

		System.out.println(count);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _15686_드래곤커브 {
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
	static int[][] map;
	static int x, y, endY, endX;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		map = new int[101][101];
		for (int i = 1; i <= N; ++i) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			map[y][x] = i;
			map[y + dy[d]][x + dx[d]] = i;
			endY = y + dy[d];
			endX = x + dx[d];
			for (int j = 1; j <= g; ++j) {
				visited = new boolean[101][101];
				int startY = endY;
				int startX = endX;
				for (int k = 0; k < 4; ++k) {
					int yy = startY + dy[k];
					int xx = startX + dx[k];

					if (yy < 0 || xx < 0 || yy >= 101 || xx >= 101)
						continue;
					if (visited[yy][xx])
						continue;

					if (map[yy][xx] == i) {
						visited[yy][xx] = true;
						draw(new Node(yy, xx), new Node(endY + dy[(k + 3) % 4], endX + dx[(k + 3) % 4]), d, i);
					}
				}
				
				for(int r = 0; r<10;++r)
					System.out.println(Arrays.toString(map[r]));
				System.out.println();
			}
		}

	}

	private static void draw(Node prevNode, Node newNode, int dir, int number) {
		if (prevNode.y == y && prevNode.x == x) {
			endY = newNode.y;
			endX = newNode.x;
			map[newNode.y][newNode.x] = number;
			return;
		}
		for (int i = 0; i < 4; ++i) {
			int yy = prevNode.y + dy[i];
			int xx = prevNode.x + dx[i];

			if (yy < 0 || xx < 0 || yy >= 101 || xx >= 101)
				continue;
			if (visited[yy][xx])
				continue;

			if (map[yy][xx] == number) {
				visited[yy][xx] = true;
				draw(new Node(yy, xx), new Node(newNode.y + dy[(i + 3) % 4], newNode.x + dx[(i + 3) % 4]), i, number);
			}
		}
		
		map[newNode.y][newNode.x] = number;
	}

}

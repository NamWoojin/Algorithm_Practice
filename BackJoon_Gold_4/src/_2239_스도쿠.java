import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _2239_스도쿠 {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[][] map;
	static Stack<Node> zeros;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		zeros = new Stack<>();
		for (int i = 0; i < 9; ++i) {
			String str = in.readLine();
			for (int j = 0; j < 9; ++j) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 8; i >= 0; --i) {
			for (int j = 8; j >= 0; --j) {
				if (map[i][j] == 0)
					zeros.add(new Node(i, j));
			}
		}

		if (makeSudoku()) {
			for (int i = 0; i < 9; ++i) {
				for (int j = 0; j < 9; ++j) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	private static boolean makeSudoku() {
		if (zeros.isEmpty()) {
			return true;
		}
		Node n = zeros.pop();

		for (int i = 1; i <= 9; ++i) {
			if (horizontal(n.r, n.c, i) && vertical(n.r, n.c, i) && square(n.r, n.c, i)) {
				map[n.r][n.c] = i;
				if (makeSudoku()) {
					return true;
				}
			}
		}
		map[n.r][n.c] = 0;
		zeros.add(n);
		return false;
	}

	private static boolean horizontal(int r, int c, int num) {
		for (int i = 0; i < 9; ++i) {
			if (map[r][i] == num)
				return false;
		}
		return true;
	}

	private static boolean vertical(int r, int c, int num) {
		for (int i = 0; i < 9; ++i) {
			if (map[i][c] == num)
				return false;
		}
		return true;
	}

	private static boolean square(int r, int c, int num) {
		int startR = (r / 3) * 3;
		int startC = (c / 3) * 3;
		for (int i = startR; i < startR + 3; ++i) {
			for (int j = startC; j < startC + 3; ++j) {
				if (map[i][j] == num)
					return false;
			}
		}
		return true;
	}
}

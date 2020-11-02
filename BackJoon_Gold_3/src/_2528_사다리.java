import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2528_사다리 {
	static class Board {
		int left;
		int right;
		int dir;

		public Board(int left, int right, int dir) {
			super();
			this.left = left;
			this.right = right;
			this.dir = dir;
		}

	}

	static int N, L, meets[][];
	static Board[] boards;
	static int[] dir = { 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		boards = new Board[N];
		meets = new int[N - 1][L + 1];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			int length = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			if (dir == 0) {
				boards[i] = new Board(0, length, dir);
			} else {
				boards[i] = new Board(L - length, L, dir);
			}
			for (int j = boards[i].left; j <= boards[i].right; ++j) {
				if (i < N - 1)
					++meets[i][j];
				if (i > 0)
					++meets[i - 1][j];
			}
		}

		int level = 0;
		int time = 0;
		while (true) {
//			for(int i  =N-2; i>=0;--i)
//				System.out.println(Arrays.toString(meets[i]));
//			System.out.println();
			level = up(level);
			moveBoard();
			if(level == N-1)
				break;
			++time;
		}
		System.out.println(time);
	}

	private static int up(int floor) {
		if (floor == N - 1) {
			return floor;
		}
		for (int i = 0; i <= L; ++i) {
			if (meets[floor][i] == 2) {
				return up(floor + 1);
			}
		}
		return floor;
	}

	private static void moveBoard() {
		for (int i = 0; i < N; ++i) {
			Board b = boards[i];
			if(b.right - b.left == L)
				continue;
			b.right += dir[b.dir];
			b.left += dir[b.dir];

			if (b.dir == 0) {
				if (i < N - 1) {
					--meets[i][b.left - 1];
					++meets[i][b.right];
				}
				if (i > 0) {
					--meets[i - 1][b.left - 1];
					++meets[i - 1][b.right];
				}
				if (b.right == L) {
					b.dir = 1;
				}
			} else if (b.dir == 1) {
				if (i < N - 1) {
					++meets[i][b.left];
					--meets[i][b.right + 1];
				}
				if (i > 0) {
					++meets[i - 1][b.left];
					--meets[i - 1][b.right + 1];
				}
				if (b.left == 0) {
					b.dir = 0;
				}
			}
		}
	}
}

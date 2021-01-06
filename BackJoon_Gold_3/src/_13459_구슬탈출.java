import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13459_구슬탈출 {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		Node(Node n) {
			this.r = n.r;
			this.c = n.c;
		}
	}

	static int N, M;
	static boolean goalB, goalR;
	static Node B, R, O;
	static char[][] map;
	static boolean[][][][] visited;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		for (int i = 0; i < N; ++i) {
			map[i] = in.readLine().toCharArray();
			for (int j = 0; j < M; ++j) {
				switch (map[i][j]) {
				case 'B':
					B = new Node(i, j);
					map[i][j] = '.';
					break;
				case 'R':
					R = new Node(i, j);
					map[i][j] = '.';
					break;
				case 'O':
					O = new Node(i, j);
					break;
				}
			}
		}
		System.out.println(tilt(1) ? 1 : 0);
	}

	static boolean tilt(int count) {
		if (goalR || goalB) {
			if (!goalB && goalR) {
//				System.out.println(B.r + " " + B.c);
//				System.out.println(R.r + " " + R.c);
//				System.out.println(count);
				return true;
			}
			goalR = false;
			goalB = false;
			return false;
		}
		if (count > 10) {
			return false;
		}

		Node prevB = new Node(B);
		Node prevR = new Node(R);
		for (int dir = 0; dir < 4; ++dir) { // 상우하좌
			switch (dir) {
			case 0:
				if (B.r < R.r) { // B가 더 위에 있는 경우
					moveBall(dir, false);
					moveBall(dir, true);
				} else { // R가 더 위에 있는 경우
					moveBall(dir, true);
					moveBall(dir, false);
				}
				break;
			case 1:
				if (B.c < R.c) { // R이 더 오른쪽에 있는 경우
					moveBall(dir, true);
					moveBall(dir, false);
				} else { // R가 더 오른쪽에 있는 경우
					moveBall(dir, true);
					moveBall(dir, false);
				}
				break;
			case 2:
				if (B.r > R.r) { // B가 더 아래에 있는 경우
					moveBall(dir, false);
					moveBall(dir, true);
				} else { // R가 더 아래에 있는 경우
					moveBall(dir, true);
					moveBall(dir, false);
				}
				break;
			case 3:
				if (B.c < R.c) { // B가 더 왼쪽에 있는 경우
					moveBall(dir, false);
					moveBall(dir, true);
				} else { // R가 더 왼쪽에 있는 경우
					moveBall(dir, true);
					moveBall(dir, false);
				}
				break;
			}
			if (!visited[B.r][B.c][R.r][R.c]) { // 이전과 동일한 위치라면

				visited[B.r][B.c][R.r][R.c] = true;
				if (tilt(count + 1))
					return true;
				visited[B.r][B.c][R.r][R.c] = false;
			}

			B = new Node(prevB);
			R = new Node(prevR);
		}
		return false;
	}

	static void moveBall(int dir, boolean red) {
		Node Ball = red ? R : B;
		Node Other = red ? B : R;
		int i = Ball.r;
		int j = Ball.c;
		int prevI = i;
		int prevJ = j;
		while (true) {
			switch (dir) {
			case 0:
				--i;
				break;
			case 1:
				++j;
				break;
			case 2:
				++i;
				break;
			case 3:
				--j;
				break;
			}
			if (!(red ? goalB : goalR) && (i == Other.r && j == Other.c)) { // 다른 공이랑 같은 자리
				break;
			} else if (map[i][j] == '#') { // 벽이면
				break;
			}
			prevI = i;
			prevJ = j;

			if (map[i][j] == 'O') { // 구멍에 빠지면
				if (red)
					goalR = true;
				else
					goalB = true;
				break;
			}
		}

		if (red) {
			R.r = prevI;
			R.c = prevJ;
		} else {
			B.r = prevI;
			B.c = prevJ;
		}
	}
}

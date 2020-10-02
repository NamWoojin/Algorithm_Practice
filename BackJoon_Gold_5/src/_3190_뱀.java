import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3190_뱀 {
	static class direction {
		int x;
		char c;

		direction(int x, char c) {
			this.x = x;
			this.c = c;
		}
	}

	// 상,하,좌,우 => 1,2,3,4
	static int dr[] = { 0, -1, 1, 0, 0 };
	static int dc[] = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		int[][] arr = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			arr[r][c] = -1;
		}
		int L = Integer.parseInt(in.readLine());
		direction[] dirs = new direction[L];
		for (int i = 0; i < L; ++i) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			dirs[i] = new direction(x, c);
		}
		int headR = 0;
		int headC = 0;
		int tailR = 0;
		int tailC = 0;
		int time = 0;
		int dir = 4;
		int dirIdx = 0;
		while (true) {
			++time;
			arr[headR][headC] = dir;
			headR += dr[dir];
			headC += dc[dir];
			if (headR < 0 || headC < 0 || headR >= N || headC >= N || arr[headR][headC] > 0) {
				break;
			}

			if (arr[headR][headC] == 0) {
				int num = arr[tailR][tailC];
				arr[tailR][tailC] = 0;
				tailR += dr[num];
				tailC += dc[num];
			}
			
			if (dirIdx < L && dirs[dirIdx].x == time) {
				switch (dir) {
				case 1:
					dir = dirs[dirIdx].c == 'D' ? 4 : 3;
					break;
				case 2:
					dir = dirs[dirIdx].c == 'D' ? 3 : 4;
					break;
				case 3:
					dir = dirs[dirIdx].c == 'D' ? 1 : 2;
					break;
				case 4:
					dir = dirs[dirIdx].c == 'D' ? 2 : 1;
					break;
				}
				++dirIdx;
			}
		}
		System.out.println(time);
	}

}

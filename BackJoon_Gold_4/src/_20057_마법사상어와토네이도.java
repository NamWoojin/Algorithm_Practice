import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _20057_마법사상어와토네이도 {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };
	static int[][] move0 = new int[][] { { 0, 0, 2, 0, 0 }, { 0, 10, 7, 1, 0 }, { 5, 0, 0, 0, 0 }, { 0, 10, 7, 1, 0 },
			{ 0, 0, 2, 0, 0 } };
	static int[][] move1 = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 2, 7, 0, 7, 2 }, { 0, 10, 0, 10, 0 },
			{ 0, 0, 5, 0, 0 } };
	static int[][] move2 = new int[][] { { 0, 0, 2, 0, 0 }, { 0, 1, 7, 10, 0 }, { 0, 0, 0, 0, 5 }, { 0, 1, 7, 10, 0 },
			{ 0, 0, 2, 0, 0 } };
	static int[][] move3 = new int[][] { { 0, 0, 5, 0, 0 }, { 0, 10, 0, 10, 0 }, { 2, 7, 0, 7, 2 }, { 0, 1, 0, 1, 0 },
			{ 0, 0, 0, 0, 0 } };
	static int sum = 0, arr[][], N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int r = N / 2;
		int c = N / 2;
		int dir = 0;	//방향
		int dirCnt = 1;	//한 방향으로 이동할 최대 횟수
		int move = 0;	//한 방향으로 현재까지 이동한 횟수
		boolean change = false;//방향전환여부
		while (true) {
			r += dr[dir % 4];
			c += dc[dir % 4];
			if (r < 0 || c < 0 || r >= N || c >= N)
				break;
			++move;
			spread(r, c, dir % 4);

			if (dirCnt == move) {
				if (change) {
					++dirCnt;
					change=false;
				} else {
					change = true;
				}
				++dir;
				move= 0;
			}
		}
		
		System.out.println(sum);
	}

	private static void spread(int r, int c, int dir) {
		int[][] move = new int[N][];
		switch (dir) {
		case 0:
			move = move0;
			break;
		case 1:
			move = move1;
			break;
		case 2:
			move = move2;
			break;
		case 3:
			move = move3;
			break;
		}
		int y = arr[r][c];
		arr[r][c] = 0;
		int movedSand = 0;
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				if(move[i][j] == 0)
					continue;
				
				int posR = r + i - 2;
				int posC = c + j - 2;
				int ss = (int)(y * ((float)move[i][j] / 100));
//				System.out.println(ss+" "+y+" "+move[i][j]/100);
				if (posR < 0 || posC < 0 || posR >= N || posC >= N) {
					sum += ss;
				} else {
					arr[posR][posC] += ss;
				}
				movedSand += ss;
			}
		}
		int alphaR = r + dr[dir];
		int alphaC = c + dc[dir];
		if (alphaR < 0 || alphaC < 0 || alphaR >= N || alphaC >= N)
			sum += y - movedSand;
		else
			arr[alphaR][alphaC] += y - movedSand;
		
//		for(int i =0; i<N;++i)
//			System.out.println(Arrays.toString(arr[i]));
//		System.out.println();
	}
}

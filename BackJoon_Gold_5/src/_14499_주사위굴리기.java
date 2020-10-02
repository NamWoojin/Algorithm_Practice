import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14499_주사위굴리기 {
	static int[] dr = {0, 0, 0, -1, 1 };
	static int[] dc = {0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[] dice = new int[7];
		int[] dirS = { 6, 2, 1, 5 }; // 세로(밑,남,위,북)
		int[] dirG = { 6, 3, 1, 4 }; // 가로(밑,동,위,서)
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] order = new int[K];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < K; ++i) {
			order[i] = Integer.parseInt(st.nextToken());
		}
//		dice[6]=map[x][y];
		for (int i = 0; i < K; ++i) {
			int xx = x + dr[order[i]];
			int yy = y + dc[order[i]];

			if (xx < 0 || yy < 0 || xx >= N || yy >= M)
				continue;

			x = xx;
			y = yy;

			rollingDice(order[i], dirS, dirG);

			int bottom = dirS[0];
			int top = dirS[2];
			if(map[x][y] == 0) {	//밑면 값이 0이면
				map[x][y] = dice[bottom];
			}else {
				dice[bottom] = map[x][y];
				map[x][y] = 0;
			}
			
			System.out.println(dice[top]);
		}
	}

	private static void rollingDice(int dir, int[] dirS, int[] dirG) {
		switch (dir) {
		case 1:
			int num = dirG[0];
			for (int i = 1; i < 4; ++i) {
				dirG[i - 1] = dirG[i];
			}
			dirG[3] = num;

			dirS[0] = dirG[0];
			dirS[2] = dirG[2];
			break;
		case 2:
			num = dirG[3];
			for (int i = 3; i > 0; --i) {
				dirG[i] = dirG[i - 1];
			}
			dirG[0] = num;

			dirS[0] = dirG[0];
			dirS[2] = dirG[2];
			break;
		case 3:
			num = dirS[0];
			for (int i = 1; i < 4; ++i) {
				dirS[i - 1] = dirS[i];
			}
			dirS[3] = num;
			
			dirG[0] = dirS[0];
			dirG[2] = dirS[2];
			break;
		case 4:
			num = dirS[3];
			for (int i = 3; i > 0; --i) {
				dirS[i] = dirS[i - 1];
			}
			dirS[0] = num;
			
			dirG[0] = dirS[0];
			dirG[2] = dirS[2];
			break;
		}
	}
}

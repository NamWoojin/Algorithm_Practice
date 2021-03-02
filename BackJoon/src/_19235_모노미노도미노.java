import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19235_모노미노도미노 {
	static boolean green[][] = new boolean[6][4], blue[][] = new boolean[6][4];
	static int score = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		for (int count = 0; count < N; ++count) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 블록 배치
			switch (t) {
			case 1:
				put(t, y, y, green);
				put(t, x, x, blue);
				break;
			case 2:
				put(t, y, y + 1, green);
				put(t + 1, x, x, blue);
				break;
			case 3:
				put(t, y, y, green);
				put(t - 1, x, x + 1, blue);
				break;
			}

			// 행,열 찼는지 확인
			out: while (true) {
				for (int i = 2; i < 6; ++i) {
					boolean greenFull = true;
					for (int j = 0; j < 4; ++j) {
						if (!green[i][j])
							greenFull = false;
					}
					if (greenFull) {
						++score;
						green[i] = new boolean[4];
						blockDown(i, green);
						continue out;
					}
				}
				break;
			}
			out: while (true) {
				for (int i = 2; i < 6; ++i) {
					boolean blueFull = true;
					for (int j = 0; j < 4; ++j) {
						if (!blue[i][j])
							blueFull = false;
					}
					if (blueFull) {
						++score;
						blue[i] = new boolean[4];
						blockDown(i, blue);
						continue out;
					}
				}
				break;
			}

			// 특수구역 확인
			while (true) {
				boolean greenFull = false;
				for (int j = 0; j < 4; ++j) {
					if (green[1][j])
						greenFull = true;
				}
				if (greenFull) {
					move(5, green);
				} else
					break;
			}
			while (true) {
				boolean blueFull = false;
				for (int j = 0; j < 4; ++j) {
					if (blue[1][j])
						blueFull = true;
				}
				if (blueFull) {
					move(5, blue);
				} else
					break;
			}

		}

		int count = 0;
		for (int i = 0; i < 6; ++i) {
			for (int j = 0; j < 4; ++j) {
				if (green[i][j])
					++count;
				if (blue[i][j])
					++count;
			}
		}
		System.out.println(score);
		System.out.println(count);
	}

	static void put(int t, int num1, int num2, boolean[][] arr) {
		int r = 0;

		for (r = 0; r < 6; ++r) {
			if (arr[r][num1] || arr[r][num2]) { // 막히면
				--r;
				break;
			}
		}
		if (r == 6)
			--r;

		switch (t) {
		case 1:
			arr[r][num1] = true;
			break;
		case 2:
			arr[r][num1] = true;
			arr[r][num2] = true;
			break;
		case 3:
			arr[r][num1] = true;
			arr[r - 1][num1] = true;
			break;
		}
	}

	static void move(int r, boolean[][] arr) {
		for (int i = r; i > 0; --i) {
			arr[i] = arr[i - 1];
		}
		arr[0] = new boolean[4];
	}

	static void blockDown(int r, boolean[][] arr) {
		for (int j = 0; j < 4; ++j) {
			for (int i = r; i > 0; --i) {
				if(arr[i][j]) {	//블록이 있으면
					int k = i+1;
					for (; k<6 ; ++k) {
						if(arr[k][j])	//블록을 내릴 수 있는 위치 찾기
							break;
					}
					arr[i][j] = false;
					arr[k-1][j] = true;
				}
			}
		}
	}

}

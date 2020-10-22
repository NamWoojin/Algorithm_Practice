import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15683_감시 {
	static class cctv {
		int r, c, num;

		cctv(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}

	static int N, M, arr[][], min;
	static ArrayList<cctv> cctvs;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		cctvs = new ArrayList<cctv>();
		min = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0)
					++count;
				else if (arr[i][j] <= 5) {
					cctvs.add(new cctv(i, j, arr[i][j]));
				}
			}
		}

		choiceDir(0, arr, count);
		System.out.println(min);
	}

	private static void choiceDir(int idx, int[][] array, int count) {
		if (idx == cctvs.size()) {
			min = Math.min(count, min);
			return;
		}

		cctv c = cctvs.get(idx);
		int[][] tempArray = new int[N][];
		switch (c.num) {
		case 1:
			for (int i = 0; i < 4; ++i) {
				copyArray(array, tempArray);
				int tempCount = count;
				int rr = c.r;
				int cc = c.c;
				while (true) {
					rr += dr[i];
					cc += dc[i];
					if (rr < 0 || cc < 0 || rr >= N || cc >= M)
						break;
					if (tempArray[rr][cc] == 6)
						break;
					if (tempArray[rr][cc] == 0) {
						--tempCount;
						tempArray[rr][cc] = 9;
					}
				}
				choiceDir(idx + 1, tempArray, tempCount);
			}
			break;
		case 2:
			for (int i = 0; i < 2; ++i) {
				copyArray(array, tempArray);
				int tempCount = count;
				
				for (int j = i; j < 4; j += 2) {
					int rr = c.r;
					int cc = c.c;
					while (true) {
						rr += dr[j];
						cc += dc[j];
						if (rr < 0 || cc < 0 || rr >= N || cc >= M)
							break;
						if (tempArray[rr][cc] == 6)
							break;
						if (tempArray[rr][cc] == 0) {
							--tempCount;
							tempArray[rr][cc] = 9;
						}
					}
				}
				choiceDir(idx + 1, tempArray, tempCount);
			}
			break;
		case 3:
			for (int i = 0; i < 4; ++i) {
				copyArray(array, tempArray);
				int tempCount = count;
				
				for (int j = i; j <= i + 1; ++j) {
					int rr = c.r;
					int cc = c.c;
					while (true) {
						rr += dr[j % 4];
						cc += dc[j % 4];
						if (rr < 0 || cc < 0 || rr >= N || cc >= M)
							break;
						if (tempArray[rr][cc] == 6)
							break;
						if (tempArray[rr][cc] == 0) {
							tempArray[rr][cc] = 9;
							--tempCount;
						}
					}
				}
				choiceDir(idx + 1, tempArray, tempCount);
			}
			break;
		case 4:
			for (int i = 0; i < 4; ++i) {
				copyArray(array, tempArray);
				int tempCount = count;
				
				for (int j = i; j < i + 3; ++j) {
					int rr = c.r;
					int cc = c.c;
					while (true) {
						rr += dr[j % 4];
						cc += dc[j % 4];
						if (rr < 0 || cc < 0 || rr >= N || cc >= M)
							break;
						if (tempArray[rr][cc] == 6)
							break;
						if (tempArray[rr][cc] == 0) {
							tempArray[rr][cc] = 9;
							--tempCount;
						}
					}
				}
				choiceDir(idx + 1, tempArray, tempCount);
			}
			break;
		case 5:
			copyArray(array, tempArray);
			for (int i = 0; i < 4; ++i) {
				int rr = c.r;
				int cc = c.c;
				while (true) {
					rr += dr[i];
					cc += dc[i];
					if (rr < 0 || cc < 0 || rr >= N || cc >= M)
						break;
					if (tempArray[rr][cc] == 6)
						break;
					if (tempArray[rr][cc] == 0) {
						tempArray[rr][cc] = 9;
						--count;
					}
				}

			}
			choiceDir(idx + 1, tempArray, count);
			break;
		}
	}

	private static void copyArray(int[][] array, int[][] tempArray) {
		for (int i = 0; i < N; ++i) {
			tempArray[i] = array[i].clone();
		}
	}
}

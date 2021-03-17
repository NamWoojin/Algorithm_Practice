import java.util.Scanner;

public class Solution2 {
	static int N, M, maxX, maxY;
	static int[][] squares;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; ++tc) {
			N = sc.nextInt();
			M = sc.nextInt();
			squares = new int[N][4];

			// 사각형 입력받기
			for (int i = 0; i < N; ++i) {
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();
				int x2 = sc.nextInt();
				int y2 = sc.nextInt();
				if (x1 > x2) {
					// 작은 쪽이 x1에 오도록 자리바꾸기
					x1 ^= x2;
					x2 ^= x1;
					x1 ^= x2;
				}
				if (y1 > y2) {
					// 작은 쪽이 y1에 오도록 자리바꾸기
					y1 ^= y2;
					y2 ^= y1;
					y1 ^= y2;
				}
				squares[i][0] = x1;
				squares[i][1] = y1;
				squares[i][2] = x2;
				squares[i][3] = y2;

				if (maxX < x2) {
					maxX = x2;
				}
				if (maxY < y2) {
					maxY = y2;
				}
			}

			int minimum = N - M;
			int minK = 1;
			int maxK = maxX;
			if(maxK < maxY) {
				maxK = maxY;
			}
			//이진탐색
			while(true) {
				if(minK == maxK) {
					break;
				}
				int middle = solve((minK+maxK)/2);
				if(minimum > middle) {
					//중간 크기의 값이 제거해야 하는 최소 개수보다 작으면
					minK = (minK+maxK)/2 + 1;
				}else {
					maxK = (minK+maxK)/2;
				}
			}
			System.out.println("#" + tc + " " + minK);
		}
	}

	private static int solve(int K) {
		int max = 0;
		for (int i = 0; i <= maxX; ++i) {
			for (int j = 0; j <= maxY; ++j) {
				int count = 0;
				for (int n = 0; n < N; ++n) {
					// 종양이 K정사각형 안에 들어가는지 확인
					if (squares[n][0] >= i && squares[n][1] >= j && squares[n][2] <= i + K && squares[n][3] <= j + K) {
						++count;
					}
				}
				if(max < count) {
					max = count;
				}
			}
		}
		return max;
	}
}

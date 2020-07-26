package com.ssafy.algo;

import java.util.Scanner;

public class Solution22 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; ++tc) {
			int N = sc.nextInt();
			int num = sc.nextInt();
			int[][] pond = new int[N][N];
			for (int i = 0; i < num; i++) {
				int posR = sc.nextInt();
				int posC = sc.nextInt();
				int D = sc.nextInt();
				if (pond[posR][posC] != 1) { // 초기 위치 확인
					for (int j = 3; j > 0; --j) {
						pond[posR][posC] = 0;
						posR += dr[D - 1] * j;
						posC += dc[D - 1] * j;
						if (posR >= 0 && posC >= 0 && posR < N && posC < N) {
							if (pond[posR][posC] != 1)
								pond[posR][posC] = 1;
							else break;
						} else break;
					}
				}
			}

			int count = 0;	//살아있는 소금쟁이 수 탐색
			for (int k = 0; k < N; ++k) {
				for (int j = 0; j < N; ++j) {
					if (pond[k][j] == 1)
						++count;
				}
			}
			System.out.println("#" + tc + " " + count);
		}
		sc.close();
	}

}

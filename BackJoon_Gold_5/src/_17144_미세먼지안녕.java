import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17144_미세먼지안녕 {
	static int Air1 = -1;
	static int Air2 = -1;
	static int R, C;
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, -1, 0, 1 };
	static int[][] map;

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][0] == -1) {
					if (Air1 == -1)
						Air1 = i;
					else
						Air2 = i;
				}
			}
		}

		for (int i = 0; i < T; ++i) {
			int[][] tempMap = new int[R][C];
			for(int  r=0; r<R;++r) {
				for(int c = 0; c<C;++c) {
					if(map[r][c] == 0)
						continue;
					else if(map[r][c] < 5) {
						tempMap[r][c] += map[r][c];
						continue;
					}
					
					int count = 0;
					for (int k = 0; k < 4; ++k) {
						int rr = r + dr[k];
						int cc = c + dc[k];

						if (rr < 0 || cc < 0 || rr >= R || cc >= C)
							continue;
						if(map[rr][cc] == -1)
							continue;
						
						tempMap[rr][cc] += map[r][c] / 5;
						++count;
					}
					
					tempMap[r][c] += map[r][c] - (map[r][c] / 5) * count;
				}
			}//전체 탐색 끝
			
			map = tempMap;
			
			move(Air1 - 2, 0, false, 0);
			move(Air2 + 2, 0, true, 2);

//			for(int j = 0; j<R;++j) {
//				System.out.println(Arrays.toString(map[j]));
//			}
//			
//			System.out.println();
		}
		int sum = 0;
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				if (map[i][j] <= 0)
					continue;
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}

	private static void move(int r, int c, boolean clockWise, int arrow) {

		map[r + dr[arrow]][c + dc[arrow]] = map[r][c];
		map[r][c] = 0;

		if (c == 1 && (r == Air1 || r == Air2))
			return;

		if (((r == 0 || r == R-1) && (c == 0 || c == C-1)) || (c == C-1 && (r == Air1 || r == Air2))) {
			arrow += clockWise ? -1 : 1;
			if (arrow == 4)
				arrow = 0;
			else if (arrow == -1)
				arrow = 3;
		}
		
		move(r - dr[arrow], c - dc[arrow], clockWise, arrow);
	}
}

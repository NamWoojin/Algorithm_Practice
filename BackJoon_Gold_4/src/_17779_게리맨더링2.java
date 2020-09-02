import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17779_게리맨더링2 {
	static int N;
	static int[][] array;
	static int[] dr = { 1, 1 };
	static int[] dc = { -1, 1 };

	static class line {
		int r, c, dir, count;
		int move;

		line(int r, int c, int dir, int count, int move) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.count = count;
			this.move = move;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		array = new int[N][N];
//		separateArea(3,2,1,1);
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; ++j) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N - 2; ++i) {
			for (int j = 1; j < N-1; ++j) {
				for (int d1 = 1; d1 < N - 2; ++d1) {
					for (int d2 = 1; d2 < N - 2; ++d2) {
						if (i + d1 + d2 < N && j - d1 >= 0 && j + d2 < N) {
							min = Math.min(min, separateArea(i, j, d1, d2));
						}
					}
				}
			}
		}
		System.out.println(min);
	}

	private static int separateArea(int x, int y, int d1, int d2) {
		int[][] areas = new int[N][N];
		//영역 나누기
		Queue<line> queue = new LinkedList<>();
		queue.offer(new line(x, y, 0, 0, 1));
		queue.offer(new line(x, y, 1, 0, 1));
		while (!queue.isEmpty()) {	
			line l = queue.poll();
//			System.out.println(l.r+" "+l.c);
			areas[l.r][l.c] = 5;

			int rr = l.r + dr[l.dir];
			int cc = l.c + dc[l.dir];
			
			
				if (l.dir == 0 && l.count == d1) {
					if (l.move != 0) 
						queue.offer(new line(l.r, l.c, 1, 0, 0));
				} else if (l.dir == 1 && l.count == d2) {
					if (l.move != 0) 
						queue.offer(new line(l.r, l.c, 0, 0, 0));
				}
				else
					queue.offer(new line(rr,cc,l.dir,l.count+1,l.move));
			
		}
		
		out:for (int r = 0; r < N; ++r) {
			for (int c = 0; c < N; ++c) {
				if(areas[r][c] == 5)
					continue out;
				
				if (r < x + d1)
					areas[r][c] = 1;
				else
					areas[r][c] = 3;
			}
		}
		out:for (int r = N-1; r >=0; --r) {
			for (int c = N-1; c >=0; --c) {
				if(areas[r][c] == 5)
					continue out;
				
				if (c > y && r<= x+d2)
					areas[r][c] = 2;
				else if(c>= y-d1+d2 && r>x+d2)
					areas[r][c] = 4;
			}
		}
		
		int sum[] = new int[5];
		for(int r = 0; r<N;++r) {
			for(int c = 0; c<N;++c) {
				if(areas[r][c] == 5) {
					sum[0] += array[r][c];
					continue;
				}
				
				sum[areas[r][c]] += array[r][c];
			}
		}
		
		Arrays.sort(sum);
	
		return sum[4] - sum[0];
	}
}

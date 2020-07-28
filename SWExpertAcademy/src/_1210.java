import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1210 {
	private static int[] dr = { -1, 0, 0 };
	private static int[] dc = { 0, 1, -1 };
	// direction = »ó :0, ¿À: 1, ¿Þ: 2
	private static int[][] ladder;
	private static int answer = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; ++tc) {
			int N = Integer.parseInt(in.readLine());
			ladder = new int[100][100];
			int r = 99;
			int c = 0;
			for (int i = 0; i < 100; ++i) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 100; ++j) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if (ladder[i][j] == 2)
							c = j;
					
				}
			}
			
			up(0, r, c);
			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(answer);
		}
	}

	private static void up(int direction, int r, int c) {
		if (r == 0) {
			answer = c;
			return;
		}
		else {
			int oneCount = 0;
			int dir = 0;
			for (int i = 0; i < 3; ++i) {
				
				int rr = r + dr[i];
				int cc = c + dc[i];
				if(rr<0||cc<0||rr>=100||cc>=100)
					continue;
				if (ladder[rr][cc] == 1) {
					++oneCount;
					dir += i;
				}
			}
			if (oneCount == 1)
				up(dir, r + dr[dir], c + dc[dir]);
			else {
				if(dir == 3)
					up(direction,r+dr[direction],c+dc[direction]);
				else {
					if(direction == 0)
						up(dir,r + dr[dir],c + dc[dir]);
					else
						up(0,r+dr[0],c+dc[0]);
				}
				
//				if(dir == 1) {//»ó,¿ì
//					if(direction == 0)
//						up(dir,r + dr[dir],c + dc[dir]);
//					else
//						up(0,r+dr[0],c+dc[0]);
//				}else if(dir == 2) {
//					if(direction == 0)
//						up(dir,r + dr[dir],c + dc[dir]);
//					else
//						up(0,r+dr[0],c+dc[0]);
//				}
//				else {
//					up(direction,r+dr[direction],c+dc[direction]);
//				}
			}
		}
	}

}

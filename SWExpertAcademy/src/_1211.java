import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1211 {
	private static int[] dr = { 1, 0, 0 };
	private static int[] dc = { 0, 1, -1 };
	// direction = го :0, ©ю: 1, ©ч: 2
	private static int[][] ladder;
	private static int[] startPoints;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; ++tc) {
			in.readLine();
			ladder = new int[100][100];
			startPoints = new int[50];
			int min = 10000;
			int minindex = 0;
			int index = 0;
			for (int i = 0; i < 100; ++i) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 100; ++j) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(i == 0) {
						if(ladder[i][j] == 1) {
							startPoints[index++] = j;
						}
					}
				}
			}
			
			for(int i = 0;i<index;++i) {
				int count = down(0,0,startPoints[i],1);
				if(min>= count) {
					min = count;
					minindex = startPoints[i];
				}
			}
			
			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(minindex);
		}
	}

	private static int down(int direction,int r, int c,int count) {
		if (r == 99) {
			return count;
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
				 return down(dir, r + dr[dir], c + dc[dir],++count);
			
			else {
				if(dir == 3)
					return down(direction,r+dr[direction],c+dc[direction],++count);
				else {
					if(direction == 0)
						return down(dir,r + dr[dir],c + dc[dir],++count);
					else
						return down(0,r+dr[0],c+dc[0],++count);
				}
				
			}
		}
	}

}

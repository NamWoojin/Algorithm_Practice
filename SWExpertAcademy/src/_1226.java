import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1226 {
	static class Point{
		int r,c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static int N = 100;
	static int[][] maze;
	static int ans = 0;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		for(int tc = 1; tc<=10;++tc) {
			in.readLine();
			maze = new int[N][N];
			ans = 0;
			int StartR = 0,StartC = 0;
			for(int  i = 0; i<N;++i) {
				String str = in.readLine();
				for(int j = 0; j<N;++j) {
					maze[i][j] = str.charAt(j)-'0';
					if(maze[i][j] == 2) {
						StartR = i;
						StartC = j;
					}
				}
			}
			findWay(StartR,StartC);
			sb.append("#").append(tc).append(" ").append(ans);
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
	
	private static void findWay(int r,int c) {
		Queue<Point> queue = new LinkedList<>();
		maze[r][c] = 1;
		queue.add(new Point(r,c));
		
		while(!queue.isEmpty()) {
			Point pt = queue.poll();
			
			for(int i = 0;i<4;++i) {
				int rr = pt.r + dr[i];
				int cc = pt.c + dc[i];
				
				if(maze[rr][cc] == 1)
					continue;
				if(maze[rr][cc] == 3) {
					ans = 1;
					return;
				}
					
				maze[rr][cc] = 1;
				queue.add(new Point(rr,cc));
			}
		}
	}
}

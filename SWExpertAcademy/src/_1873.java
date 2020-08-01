import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1873 {
	private static int H;
	private static int W;
	private static int[] dr = {-1,1,0,0};//상하좌우
	private static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			int r = 0;
			int c = 0;
			char[][] field = new char[H][W];
			for (int i = 0; i < H; ++i) {
				String str = in.readLine();
				for(int j = 0 ; j<W;++j) {
					field[i][j] = str.charAt(j);
					if(field[i][j] == '^' ||field[i][j] == '>' ||field[i][j] == 'v' ||field[i][j] == '<') {
						r = i;
						c = j;
					}
				
				}
				
			}

			int N = Integer.parseInt(in.readLine());
			String commands = in.readLine();
			for (int i = 0; i < N; ++i) {
				char cmd =commands.charAt(i);
				switch(cmd) {
				case 'U':
					if(!GoOut(r-1,c) && field[r-1][c] == '.') 
						field[r--][c] = '.';
					field[r][c] = '^';
					break;
				case 'D':
					if(!GoOut(r+1,c) && field[r+1][c] == '.') 
						field[r++][c] = '.';
					field[r][c] = 'v';
					break;
				case 'L':
					if(!GoOut(r,c-1) && field[r][c-1] == '.') 
						field[r][c--] = '.';
					field[r][c] = '<';
					break;
				case 'R':
					if(!GoOut(r,c+1) && field[r][c+1] == '.') 
						field[r][c++] = '.';
					field[r][c] = '>';
					break;
				case 'S':
					int moveIndex = 0;
					switch(field[r][c]) {
					case '^':
						break;
					case 'v':
						moveIndex = 1;
						break;
					case '<':
						moveIndex = 2;
						break;
					case '>':
						moveIndex = 3;
						break;
					}
					int shellX = r;
					int shellY = c;
					while(true) {
						shellX += dr[moveIndex];
						shellY += dc[moveIndex];
						if(GoOut(shellX,shellY) || field[shellX][shellY] == '#')
							break;
						else if(field[shellX][shellY] == '*') {
							field[shellX][shellY] = '.';
							break;
						}
						
					}
					break;
					
				}
			}
			
			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			for(int i = 0; i<H;++i) {
				for(int j = 0; j<W;++j) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
			
		}
	}
	
	private static boolean GoOut(int r,int c) {	//필드 밖 : true, 아니면 false
		if(r<0||c<0||r>=H||c>=W)
			return true;
		return false;
	}

}

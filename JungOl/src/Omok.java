import java.util.Scanner;

public class Omok {
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 19;
		int[][] board = new int[N][N];
		for(int i = 0; i<N;++i) {
			for(int j = 0; j<N;++j) {
				board[i][j] = sc.nextInt();
			}
		}
		boolean endFlag = false;
		for(int i =0; i<N;++i) {
			for(int j = 0; j<N;++j) {
				if(board[i][j] != 0) {
					int color = board[i][j];
					for(int k = 0; k< 8; ++k) {
						int r = i+ dr[k];
						int c = j+ dc[k];
						if(r<0||c<0||r>=N||c>=N) 
							continue;
						if(board[r][c] == color) {
							int count = 2;
							for(int l = 0; l<4;++l) {
								r += dr[k];
								c += dc[k];
								if(board[r][c] != color) 
									break;
								else
									++count;
							}
							if(count==5) {
								System.out.println(color);
								System.out.println((i+1)+" "+(j+1));
								endFlag = true;
								break;
							}
						}
					}
					
				}
				if(endFlag)
					break;
			}
			if(endFlag)
				break;
			
		}
		if(!endFlag) {
			System.out.println(0);
		}
		sc.close();
	}

}

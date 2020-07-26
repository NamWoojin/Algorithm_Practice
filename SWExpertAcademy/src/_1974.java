import java.util.Scanner;

public class _1974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T;++tc) {
			boolean no = false;
			int[][] sudoku = new int[9][9];
			for(int i = 0; i<9; ++i) {
				for(int j = 0; j<9; ++j) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			
			//45
			for(int i =0;i<9;++i) {
				int vertical = 0;
				int horizontal = 0;
				for(int j = 0; j<9;++j) {
					horizontal += sudoku[i][j];
					vertical += sudoku[j][i];
				}
				if(vertical != 45 || horizontal != 45) {
					no = true;
					break;
				}
			}
			
			if(!no) {
				for(int k = 0; k<3;++k) {
					for(int l = 0; l<3;++l) {
						int square= 0;
						for(int i = 0; i<3;++i) {
							for(int j = 0; j<3;++j) {
								square += sudoku[k*3+i][l*3+j];
							}
						}
						if(square != 45) {
							no = true;
							break;
						}
							
					}
					if(no)
						break;
				}
				
			}
			
			System.out.print("#"+tc+" ");
			if(no)
				System.out.println(0);
			else
				System.out.println(1);
		}
		sc.close();
	}

}

import java.util.Scanner;

public class ≥Û¿€π∞ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T;++tc) {
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			for(int i = 0; i<N;++i) {
				String str =sc.next();
				for(int j = 0; j<N;++j) {
					farm[i][j] = str.charAt(j)-'0';
					//farm[i][j] = Integer.parseInt(str.substring(j,j+1));
				}
			}
			for(int i = 0 ;i<N;++i){
				for(int j = 0; j<N;++j) {
					System.out.print(farm[i][j]+" ");
				}
				System.out.println();
			}
			
		}
		
		
		sc.close();
	}
	
	
}

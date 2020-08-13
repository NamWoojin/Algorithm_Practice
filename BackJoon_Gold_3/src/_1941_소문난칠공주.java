import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1941_소문난칠공주 {
	static char[][] array;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		array =new char[5][5];
		for(int i = 0;i<5;++i) {
			String str = in.readLine();
			for(int j = 0;j<5;++j) {
				array[i][j] = str.charAt(j);
			}
		}
		int count = 0;
		for(int i =0; i<5;++i) {
			for(int j =0; j<5;++j) {
				count += princess(i,j);
			}
		}
		System.out.println(count);
	}
	
	private static int princess(int r, int c) {
		
//		int cntR = 0;
//		int cntC = 0;
//		int startR = -1;
//		int endR = -1;
//		int startC = -1;
//		int endC = -1;
//		for(int i = 0; i<5;++i) {
//			if(array[i][c] == 'S') {
//				if(startR == -1) 
//					startR = i;
//				endR = i;
//				++cntR;
//			}
//			if(array[r][i] == 'S') {
//				if(startC == -1)
//					startC = i;
//				endC = i;
//				++cntC;
//			}
//		}
//		if(array[r][c] == 'S')
//			--cntR;
//		
//		if(cntR+cntC>=4) {
//			int sumR = startR == endR ? Math.abs(r-startR) : endR-startR;
//			int sumC = startC == endC ? Math.abs(c-startC) : endC-startC;
//			if(sumR+sumC == 7) {
//				return 1;
//			}
//			else if(sumR + sumC <7) {
//				int count = 0;
//				if(sumR != 5)
//				return count;
//			}
//		}
		return 0;
	}
}
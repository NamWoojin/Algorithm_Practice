import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17136_색종이붙이기 {
	static boolean[][] mainArray;
	static int totalOne = 0;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		mainArray = new boolean[10][10];
		for (int i = 0; i < 10; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 10; ++j) {
				mainArray[i][j] = st.nextToken().equals("1") ? true : false;
				if(mainArray[i][j])
					++totalOne;
			}
		}
		check(mainArray,0,totalOne);

		if(min == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(min);
	}
	
	static int count[] = new int[6];
	static void check(boolean[][] tempArray,int paperCnt,int totalOne) {
		
		if(totalOne <= 0) {
			min = Math.min(paperCnt, min);
			return;
		}
		
		out: for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < 10; ++j) {
				if (tempArray[i][j]) {
					for(int k = 5; k>0;--k) {
						if(count[k]<5 && canCover(i,j,k,tempArray)) {
							boolean[][] temptemp = new boolean[10][];
							for(int a = 0; a<10;++a)
								temptemp[a] = tempArray[a].clone();
							for (int r = i; r < k + i; ++r) {
								for (int l = j; l < k + j; ++l) {
									temptemp[r][l] = false;
								}
							}
							++count[k];
							check(temptemp,paperCnt+1,totalOne-k*k);
							--count[k];
						}
					}
					break out;
				}//그 지점이 true일때 - 끝.
			}
		}//전체 탐색 - 끝.
		return;
	}

	static boolean canCover(int r, int c, int size,boolean[][] tempArray) {
		for (int k = r; k < size + r; ++k) {
			for (int l = c; l < size + c; ++l) {

				if (k >= 10 || l >= 10)
					return false;

				if (!tempArray[k][l])
					return false;
			}
		}
		return true;

	}
}

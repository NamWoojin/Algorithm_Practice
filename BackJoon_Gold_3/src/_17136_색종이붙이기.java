import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17136_색종이붙이기 {
	static boolean[][] array;
	static int countOne = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		array = new boolean[10][10];
		for(int i = 0; i<10;++i) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<10;++j) {
				array[i][j] = st.nextToken().equals("1") ? true:false;
				if(array[i][j]) {
					++countOne;
				}
			}
		}
		int ans = 0;
		for(int i = 5;i>0;--i) {
			ans+=check(i);
			if(countOne == 0)
				break;
		}
		if(countOne>0)
			System.out.println("-1");
		else
			System.out.println(ans);
	}
	
	private static int check(int size) {
		int count =0;
		for(int i =0; i< 10-size+1;++i) {
			out: for(int j = 0;j<10-size+1;++j) {
				if(count == 5)
					return count;
				
				if(array[i][j]) {
					boolean[][] tempArray = new boolean[10][10];
					for(int r = 0; r<10;++r)
						tempArray[r] = array[r].clone();
					
					for(int k = i; k<size+i;++k) {
						for(int l =j; l<size+j;++l) {
							if(!tempArray[k][l])
								continue out;
							else
								tempArray[k][l] = false;
						}
					}
					++count;
					countOne -= size*size;
					array =tempArray;
				}
				
			}
		}
		return count;
	}
}

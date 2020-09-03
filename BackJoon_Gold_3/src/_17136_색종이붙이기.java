import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17136_색종이붙이기 {
	static boolean[][] mainArray;
	static int cc;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		mainArray = new boolean[10][10];
		for (int i = 0; i < 10; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 10; ++j) {
				mainArray[i][j] = st.nextToken().equals("1") ? true : false;

			}
		}
		int num  = check(mainArray);
		
		
		boolean flag = true;
		out: for(int i =0; i<10;++i) {
			for(int j = 0; j<10;++j) {
				if(mainArray[i][j]) {
					System.out.println("-1");
					flag = false;
					break out;
				}
			}
		}
		if(flag)
			System.out.println(num);
	}

	static int[] count = new int[6];
	static boolean[][] arr =new boolean[10][10];
	private static int check(boolean[][] array) {
		int counter = 0;
		for (int i = 0; i < 10; ++i) {
			out: for (int j = 0; j < 10; ++j) {
				if (array[i][j]) {
					
					int num = 0;
					int min = Integer.MAX_VALUE;
					boolean[][] temp = new boolean[10][10];
					re : for (int q= 5; q > 0; --q) {
						if(count[q] == 5)
							continue;
						
						boolean[][] tempArray = new boolean[10][10];
						for (int r = 0; r < 10; ++r)
							tempArray[r] = array[r].clone();

						for (int k = i; k < q + i; ++k) {
							for (int l = j; l < q + j; ++l) {
									
								if(k> 10 || l > 10)
									continue re;
								
								if (!tempArray[k][l])
									continue re;
								else 
									tempArray[k][l] = false;
							}
						}
						
						
						++count[q];
						int re = check(tempArray)+1;
						if(min > re ) {
							min = re;
							temp  = arr;
							--count[num];
							num = q;
						}else {
							--count[q];
						}
						
					}
					if(num != 0) {
						array = temp;
						counter+= min;
//						System.out.println(counter);
					}
				}

			}
		}
		arr = array;
		return counter;
	}
}

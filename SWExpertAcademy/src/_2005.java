import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2005 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(in.readLine());
			int[][] array = new int[N][];
			for (int i = 0; i < N; ++i) {
				array[i] = new int[i + 1];
				array[i][0] = array[i][i] = 1;
			}
			if (N > 2) {
				for (int i = 2; i < N; ++i) {
					for (int j = 1; j < array[i].length - 1; ++j) {
						array[i][j] = array[i-1][j-1]+array[i-1][j];
					}
				}
			}
			System.out.print("#");
			System.out.println(tc);
			
			
			for(int i = 0;i<N;++i) {
				for(int j = 0;j<array[i].length;++j) {
					System.out.print(array[i][j]);
					System.out.print(" ");
				}
				System.out.println();
			}

		}
	}

}

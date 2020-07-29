import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1970 {
	private static int[] money = {50000,10000,5000,1000,500,100,50,10};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in   = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			int N =Integer.parseInt(in.readLine());
			int[] counts = new int[money.length];
			for(int i =0; i<money.length;++i) {
				if(N>=money[i]) {
					counts[i] = N/money[i];
					N %= money[i];
				}
			}
			
			System.out.print("#");
			System.out.print(tc);
			System.out.println();
			for(int i =0 ;i<counts.length;++i) {
				System.out.print(counts[i]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}

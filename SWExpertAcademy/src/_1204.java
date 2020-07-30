import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1204 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<= T;++tc) {
			in.readLine();
			int[] counts = new int[101];
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int max = 0;
			int maxIndex =0;
			for(int i = 0; i<1000;++i) {
				int num = Integer.parseInt(st.nextToken());
				++counts[num];
				if(max <= counts[num]) {
					max = counts[num];
					maxIndex = num;
				}
			}
			
			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(maxIndex);
		}
	}

}

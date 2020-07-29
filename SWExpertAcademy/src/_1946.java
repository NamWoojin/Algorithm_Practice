import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1946 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T; ++tc) {
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st;
			int count= 0;
			for(int i = 0; i< N;++i) {
				st = new StringTokenizer(in.readLine()," ");
				String alpha = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				for(int j = 0; j<num;++j) {
					System.out.print(alpha);
					++count;
					if(count == 10) {
						count = 0;
						System.out.println();
					}
				}
			}
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1222 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for(int tc = 1;tc<=10;++tc) {
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine(),"+");
			
			int sum =0;
			while(st.hasMoreTokens()) {
				sum+= Integer.parseInt(st.nextToken());
			}
			sb.append("#").append(tc).append(" ").append(sum);
			 
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
}

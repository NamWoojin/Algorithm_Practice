import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _3431 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int L = Integer.parseInt(st.nextToken());
			int U = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			sb.append("#").append(tc).append(" ");
			if(X > U) {
				sb.append(-1);
			}
			else if(X<L){
				sb.append(L-X);
			}
			else {
				sb.append(0);
			}
			out.write(sb.toString());
			out.flush();
			out.newLine();
			sb.setLength(0);
		}
		
	}

}


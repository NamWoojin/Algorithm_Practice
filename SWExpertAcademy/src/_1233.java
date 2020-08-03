import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1233 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for(int tc = 1;tc<= 10;++tc) {
			int N =Integer.parseInt(in.readLine());
			char[] arr = new char[N+1];
			StringTokenizer st;
			int i = 1;
			sb.append("#").append(tc).append(" ");
			for(i = 1;i<=N;++i) {
				st = new StringTokenizer(in.readLine()," ");
				arr[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
				if(st.hasMoreTokens()) {
					if(arr[i]>='0') {	//중간 노드에 숫자
						break;
					}
				}
				else {
					if(arr[i]<'0') {	//리프 노드에 기호
						break;
					}
				}
			}
			if(i != N) {
				for(;i<=N;++i) {
					in.readLine();
				}
				sb.append(0);
			}
			else
				sb.append(1);
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1976 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer result= new StringBuffer();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T;++tc) {
			int hour=0, minute = 0;
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			hour += Integer.parseInt(st.nextToken());
			minute += Integer.parseInt(st.nextToken());
			hour += Integer.parseInt(st.nextToken());
			minute += Integer.parseInt(st.nextToken());
			
			if(minute >=60) {
				minute -= 60;
				++hour;
			}
			if(hour>12)
				hour -= 12;
			
			result.append("#").append(tc).append(" ").append(hour).append(" ").append(minute);
			System.out.println(result.toString());
			result.setLength(0);
			
		}
	}

}

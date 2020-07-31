import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2007 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T;++tc) {
			String str = in.readLine();
			for(int i = 1;i<str.length();++i) {
				if(str.substring(0,i).equals(str.substring(i,i+i))) {
					System.out.print("#");
					System.out.print(tc);
					System.out.print(" ");
					System.out.println(i);
					break;
				}
			}
		}
	}

}
   
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1940 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			int N = Integer.parseInt(in.readLine());
			int speed = 0;
			int distance = 0;
			for(int  i = 0; i< N;++i) {
				StringTokenizer st =new StringTokenizer(in.readLine()," ");
				int mode =Integer.parseInt(st.nextToken());
				if(mode == 1) 
					speed += Integer.parseInt(st.nextToken());
				
				if(mode == 2) {
					speed -= Integer.parseInt(st.nextToken());
					if(speed <0)
						speed = 0;
				}
				
				distance += speed;
			}
			
			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(distance);
		}

	}

}

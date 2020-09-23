import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10157_자리배정 {
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(in.readLine());

		int num = 1;
		boolean changed = true;
		int sub = 0;
		int move = R-sub-1;
		int dir = 0;
		int r = 1;
		int c = 1;
		while (true) {
			if(num == K) {
				System.out.println(r+" "+c);
				break;
			}
			if(move <= 0) {
				System.out.println("0");
				break;
			}
			r += dr[dir%4];
			c += dc[dir%4];
			++num;
			--move;
//			System.out.println(r+" "+c+" "+num+" "+move);
			
			if(move == 0) {
				if(changed) {
					++sub;
					changed = false;
				}else {
					changed =true;
				}
				
				if(dir%2==0) {
					move = C-sub;
				}else {
					move = R-sub;
				}
				++dir;
			}
		}
	}
}

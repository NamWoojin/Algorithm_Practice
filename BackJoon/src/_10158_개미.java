import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10158_개미 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(in.readLine());

		int Tw = t % (2 * w);
		int Th = t % (2 * h);

		x += Tw;
		y += Th;

		if (x > w) {
			x = 2 * w - x;
		}
		if (y > h) {
			y = 2 * h - y;
		}

		if(x<0) x*=-1;
		if(y<0) y*=-1;
		
		System.out.println(x + " " + y);
	}
}

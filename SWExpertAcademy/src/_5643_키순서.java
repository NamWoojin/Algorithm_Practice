import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _5643_키순서 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T  = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			int N = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());
			ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
			for(int i = 0; i<M;++i) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
			}
		}
	}
}

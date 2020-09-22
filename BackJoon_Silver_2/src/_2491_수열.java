import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2491_수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr= new int[N];
		for(int i =0; i<N;++i) {
			arr[i]  = Integer.parseInt(st.nextToken());
		}
		
		int max = 1;
		
		for(int i =0; i<N;++i) {
			
			
		}
		
		System.out.println(max);
	}
}

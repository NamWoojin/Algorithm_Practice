import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20127_Y수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i<N;++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean up = arr[N-1] < arr[0];
		int k = -1;
		for(int i = 0; i<N-1;++i) {
		}
	}
}

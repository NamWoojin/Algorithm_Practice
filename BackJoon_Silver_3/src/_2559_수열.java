import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2559_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr=  new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<N;++i) {
			arr[i] =Integer.parseInt(st.nextToken()); 
		}
		
		int startIdx = 0;
		int endIdx = 0;
		int sum = 0;
		int max = 0;
		while(endIdx<K) {
			sum+=arr[endIdx++];
		}
		max = sum;
		
		while(endIdx<N) {
			sum -= arr[startIdx++];
			sum += arr[endIdx++];
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
	
}

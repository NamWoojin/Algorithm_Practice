import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1978_소수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i<N;++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int max = arr[N-1];
		boolean[] isNotPrime = new boolean[max+1];
		isNotPrime[1] = true;
		for(int i = 2; i<=max;++i) {
			if(isNotPrime[i])
				continue;
			int num = i+i;
			while(num <= max) {
				isNotPrime[num] = true;
				num += i;
			}
		}
		int count = 0;
		for(int i = 0; i<N;++i) {
			count += (isNotPrime[arr[i]]?0:1);
		}
		System.out.println(count);
	}
	
}

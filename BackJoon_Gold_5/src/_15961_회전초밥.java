import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15961_회전초밥 {
	static int N, d, k, c,max = 0;
	static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		array = new int[N];
		for (int i = 0; i < N; ++i) {
			array[i] = Integer.parseInt(in.readLine());
		}
		for (int i = 0; i < N; ++i) {
			boolean[] check = new boolean[d+1];
			max = Math.max(max,counter(i, 1,check,false));
		}
		System.out.println(max);
	}

	private static int counter(int idx,int count,boolean[] check,boolean coupon) {
		if(count == k) {
			return coupon?  count : count+1;
		}
		
		
		if(idx == N)
			idx = 0;
		
		if(!check[array[idx]]) {
			check[array[idx]] = true;
			if (c== array[idx])
				coupon = true;
			return counter(idx+1,count+1,check,coupon);
			
		}else {
			return counter(idx+1,count,check,coupon);
		}
		
	}

}

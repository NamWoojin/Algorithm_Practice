import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1859 {
	private static int[] arr;
	private static long max = 0;
	private static int N = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<= T;++tc) {
			max = 0;
			N = Integer.parseInt(in.readLine());
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			for(int i = 0; i<N;++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			calculate(0,0,0,0);
			
			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(max);
		}
	
	}
	
	private static void calculate(int index,long use,long get,long usenum) {
		if(index == N) {
			long sum = get+use;
			if(sum > max)
				max = sum;
			return;
		}
		
		
		calculate(index+1,use,get,usenum);	//¾Æ¹«°Íµµ¾ÈÇÔ
		calculate(index+1,use-arr[index],get,usenum+1);	//»ï
		if(usenum>0)
			calculate(index+1,use,get+arr[index],usenum-1);	//ÆÊ
		
	}

}

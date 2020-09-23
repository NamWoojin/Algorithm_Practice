import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1244_스위치켜고끄기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		boolean[] arr = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i =1;i<N+1;++i) {
			arr[i] = st.nextToken().equals("1") ?true: false;
		}
		
		int P = Integer.parseInt(in.readLine());
		for(int i =0; i<P;++i) {
			st=  new StringTokenizer(in.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num =  Integer.parseInt(st.nextToken());
			
			if(gender==1) {
				for(int j = num;j<arr.length;j+=num) {
					arr[j] = !arr[j];
				}
			}else {
				int startIdx = num;
				int endIdx = num;
				while(startIdx>1  && endIdx <N) {
					if(arr[startIdx-1] != arr[endIdx+1])
						break;
					
					--startIdx;
					++endIdx;
					
				}
				for(int j = startIdx; j<=endIdx;++j)
					arr[j] = !arr[j];
			}
		}
		
		for(int i = 1; i<arr.length;++i) {
			System.out.print((arr[i]?'1':'0') + " ");
			if(i%20 == 0)
				System.out.println();
		}
	}
}

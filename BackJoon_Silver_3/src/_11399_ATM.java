import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11399_ATM {
	 public static void main(String[] args) throws NumberFormatException, IOException {
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(in.readLine());
	        int [] array = new int[N];
	        StringTokenizer st =new StringTokenizer(in.readLine());
	        for (int i =0;i<N ;++i ) {
	            array[i]= Integer.parseInt(st.nextToken());
	        }
	        Arrays.sort(array);
	        int sum =0;
	        int add =0;
	        for(int i = 0;i<N;++i){
	            add += array[i];
	            sum += add;
	        }
	        System.out.println(sum);
	    }

}

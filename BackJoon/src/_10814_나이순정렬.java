import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _10814_나이순정렬 {
	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      
	      int N= sc.nextInt();   //회원의 수
	      int num[] = new int[N];
	      String name[] = new String[N];
	      
	        for (int i = 0; i < N; i++) {
	            num[i] = sc.nextInt();
	            name[i] = sc.next();
	        }
	        
	        int tmp = 0;
	        String ntmp;
	        
	        for(int i=0; i<N; i++) {
	           for(int j=0; j<N-1; j++) {
	              if(num[i] > num[j]) {
	                 tmp = num[i];
	                 num[i] = num[j];
	                 num[j] = tmp;
	                 
	                 ntmp = name[i];
	                 name[i] = name[j];
	                 name[j] = ntmp;
	              }
	           }
	        }

	        for (int i = 0; i < N; i++) {
	            System.out.print(num[i] + " " + name[i]);
	            System.out.println();
	        }
	   }


}

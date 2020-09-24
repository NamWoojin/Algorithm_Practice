import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14696_딱지놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(in.readLine());
		StringTokenizer st;
		while(--N>=0) {
			int[] cardA = new int[4];
			int[] cardB = new int[4];
			for(int i =0; i<2;++i) {
				st = new StringTokenizer(in.readLine());
				int n = Integer.parseInt(st.nextToken());
				switch(i) {
				case 0:
					for(int j=0;j<n;++j) {
						++cardA[Integer.parseInt(st.nextToken())-1];
					}
					break;
				case 1:
					for(int j=0;j<n;++j) {
						++cardB[Integer.parseInt(st.nextToken())-1];
					}
					break;
				}
			}
			
			for(int i =3; i>=0;--i) {
				if(cardA[i] > cardB[i]) {
					System.out.println('A');
					break;
				}else if(cardA[i]<cardB[i]) {
					System.out.println('B');
					break;
				}
				
				if(i==0) {
					System.out.println('D');
				}
				
			}
		}
	}
}

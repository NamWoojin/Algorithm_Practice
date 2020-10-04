import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1759_암호만들기 {
	static int alphaList = 0,L;
	static int[] moums = new int[] {'a'-'a','e'-'a','i'-'a','o'-'a','u'-'a'};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<C;++i) {
			alphaList = alphaList|(1<<(st.nextToken().charAt(0)-'a')); 
		}
		
		passwords(0,0,0,0);
	}
	
	private static void passwords(int cnt,int idx,int choosen,int moum) {
		if(cnt == L) {
			if(moum>=1 && L-moum >=2) {
				for(int i = 0; i<26;++i) {
					if((choosen & (1<<i)) != 0) {
						System.out.print((char)(i+'a'));
					}
				}
				System.out.println();
			}
			return;
		}
		
		if(idx == 26)
			return;
		
		if((alphaList & (1<<idx))!= 0) {
			boolean isMoum = false;
			for(int i = 0; i<5;++i) {
				if(idx == moums[i]) {
					isMoum = true;
					break;
				}
			}
			
			if(isMoum)
				passwords(cnt+1,idx+1,choosen|(1<<idx),moum+1);
			else
				passwords(cnt+1,idx+1,choosen|(1<<idx),moum);
		}
		passwords(cnt,idx+1,choosen,moum);
	}
}

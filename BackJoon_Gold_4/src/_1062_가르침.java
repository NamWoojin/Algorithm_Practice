import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1062_가르침 {
	static int N,K,words[],max = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new int[N];
		for (int i = 0; i <N; ++i) {
			String str = in.readLine();
			int num = 0;
			for(int j = 0; j<str.length();++j) {
				num = num|(1<<(str.charAt(j)-'a'));
		 	}
			words[i] = num;
		}
		int number = 0;
		number = number|(1<<'a'-'a');
		number = number|(1<<'t'-'a');
		number = number|(1<<'n'-'a');
		number = number|(1<<'i'-'a');
		number = number|(1<<'c'-'a');
		if(K>=5)
			choice(0,5,number);
		System.out.println(max);
	}
	
	private static void choice(int idx,int count,int num) {
		if(count ==  K) {
			count(num);
			return;
		}
		if(idx == 26)
			return;
		
		choice(idx+1,count,num);
		if((num&(1<<idx))==0)
			choice(idx+1,count+1,num|(1<<idx));
		
	}
	private static void count(int num) {
		int total = 0;
		next : for(int i = 0;i<N;++i) {
			int word = words[i];
			for(int j = 0; j<26;++j) {
				if((word&(1<<j))>0) {
					if((num&(1<<j))==0) {
						continue next;
					}
				}
			}
			++total;
		}
		max = Math.max(total, max);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13300_방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] room = new int[6][2];
		int count =0;
		for(int i =0; i<N;++i){
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			++room[y-1][s];
		}
		
		for(int i =0; i<6;++i) {
			for(int j = 0; j<2;++j) {
				count+=room[i][j]/K;
				if(room[i][j]%K>0)
					++count;
			}
		}
		System.out.println(count);
	}
}

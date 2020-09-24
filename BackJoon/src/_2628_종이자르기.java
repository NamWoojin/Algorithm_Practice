import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2628_종이자르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in  =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		boolean[] widthCut = new boolean[Integer.parseInt(st.nextToken())+1];
		boolean[] heightCut = new boolean[Integer.parseInt(st.nextToken())+1];
		widthCut[widthCut.length-1] = true;
		heightCut[heightCut.length-1] = true;
		
		int N = Integer.parseInt(in.readLine());
		while(--N>=0) {
			st  = new StringTokenizer(in.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			if(dir==0) {
				heightCut[idx] = true;
			}else {
				widthCut[idx] = true;
			}
		}
		
		int max = 0;
		int prevWidth = 0;
		int prevHeight = 0;
		for(int i =0 ; i<widthCut.length;++i) {
			if(widthCut[i]) {
				for(int j = 0; j<heightCut.length;++j) {
					if(heightCut[j]) {
						max = Math.max(max, (j-prevHeight)*(i-prevWidth));
						prevHeight=j;
					}
				}
				prevWidth = i;
				prevHeight= 0;
			}
		}
		System.out.println(max);
	}
}

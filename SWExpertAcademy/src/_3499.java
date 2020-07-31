import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			int N = Integer.parseInt(in.readLine());
			
			String[] result = new String[N];
			Queue<String> leftDeck = new LinkedList<>();
			Queue<String> rightDeck = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int border  =0;
			if(N %2 == 0)
				border = N/2;
			else
				border = N/2+1;
			
			for(int i = 0; i<N;++i) {
				if(i < border) 
					leftDeck.offer(st.nextToken());
				else
					rightDeck.offer(st.nextToken());
			}
			for(int i = 0; i<N;++i) {
				if(i%2 == 0)
					result[i] = leftDeck.poll();
				else
					result[i] = rightDeck.poll();
			}
			
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i<N;++i) {
				sb.append(result[i]).append(" ");
			}
			out.write(sb.toString());
			out.newLine();
			out.flush();
			sb.setLength(0);
		}
	}

}





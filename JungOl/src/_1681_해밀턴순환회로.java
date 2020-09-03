import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1681_해밀턴순환회로 {
	static int min = Integer.MAX_VALUE;
	static boolean isVisited[];
	static int N,costs[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N  =Integer.parseInt(in.readLine());
		isVisited = new boolean[N];
		costs = new int[N][N];
		for(int i =0; i<N;++i) {
			st= new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		isVisited[0] = true;
		Delivery(0,0,0);
		System.out.println(min);
	}
	
	private static void Delivery(int idx,int sum,int count) {
		
		if(sum > min)
			return;
		if(count == N-1) {
			sum += costs[idx][0];
			min = Math.min(min, sum);
			return;
		}
		
		for(int i =0; i<N;++i) {
			if(!isVisited[i] && costs[idx][i] != 0) {
				isVisited[i] = true;
				Delivery(i,sum+costs[idx][i],count+1);
				isVisited[i] = false;
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _2217_로프 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i  =0; i<N;++i) {
			pq.add(Integer.parseInt(in.readLine()));
		}
		
		int max = 0;
		while(!pq.isEmpty()) {
			max = Math.max(max, pq.poll() * (pq.size()+1));
		}
		System.out.println(max);
	}
}

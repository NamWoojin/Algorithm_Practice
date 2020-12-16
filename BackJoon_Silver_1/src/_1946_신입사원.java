import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1946_신입사원 {
	static class person implements Comparable<person>{
		int a;
		int b;
		person(int a, int b){
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(person o) {
			// TODO Auto-generated method stub
			return this.a - o.a;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			int N = Integer.parseInt(in.readLine());
			PriorityQueue<person> pq = new PriorityQueue<>();
			StringTokenizer st;	
			for(int i = 0; i<N;++i){
				st = new StringTokenizer(in.readLine());
				pq.add(new person(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			int count = 1;
			person BigB = pq.poll();
			while(!pq.isEmpty()) {
				if(BigB.b == 1) {	//b가 1이면 그 이후는 더 이상 BigB보다 클 수 없음.
					break;
				}
				person p = pq.poll();
				if(p.b < BigB.b) {
					++count;
					BigB = p;
				}
			}
			System.out.println(count);
		}
	}
	
}

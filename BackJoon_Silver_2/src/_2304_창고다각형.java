import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2304_창고다각형 {
	static class line implements Comparable<line>{
		int idx;
		int height;
		line(int idx,int height){
			this.idx= idx;
			this.height = height;
		}
		@Override
		public int compareTo(line o) {
			// TODO Auto-generated method stub
			return o.height-this.height;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in  =new BufferedReader(new InputStreamReader(System.in));
		int N  =Integer.parseInt(in.readLine());
		PriorityQueue<line> queue = new PriorityQueue<>();
		StringTokenizer st;
		while(--N>=0) {
			st = new StringTokenizer(in.readLine());
			queue.offer(new line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		line l = queue.poll();
		int size = l.height;
		int prevIdx = l.idx;
		int nextIdx = l.idx;
		while(!queue.isEmpty()) {
			l = queue.poll();
			if(l.idx <prevIdx) {
				size += (prevIdx - l.idx) * l.height;
				prevIdx = l.idx;
			}else if(l.idx >nextIdx){
				size += (l.idx-nextIdx) * l.height;
				nextIdx = l.idx;
			}
		}
		System.out.println(size);
	}
}

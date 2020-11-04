import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _10800_컬러볼 {
	static class Ball implements Comparable<Ball> {
		int color;
		int size;
		int idx;

		Ball(int c, int s, int idx) {
			this.color = c;
			this.size = s;
			this.idx = idx;
		}

		@Override
		public int compareTo(Ball o) {
			return o.size - this.size;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] answer = new int[N];
		PriorityQueue<Ball> q = new PriorityQueue<>();
		HashMap<Integer, Integer> map = new HashMap();
		HashMap<Integer, int[]> has = new HashMap();
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			q.add(new Ball(c,s,i));
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+s);
				++has.get(c)[s];
			}else {
				map.put(c,s);
				int[] temp = new int[2001];
				++temp[s];
				has.put(c,temp);
			}
		}
		
		while(!q.isEmpty()) {
			Ball b = q.poll();
			Iterator<Integer> iter = map.keySet().iterator();
			int sum = 0;
			while(iter.hasNext()) {
				int c = iter.next();
				if(c == b.color) {
					map.put(b.color,map.get(c) - b.size);
					--has.get(c)[b.size];
				}else {
					sum += map.get(c);
					sum -= has.get(c)[b.size] * b.size;
				}
			}
			answer[b.idx] = sum;
		}
		
		
		for(int i  =0;i<N;++i) {
			System.out.println(answer[i]);
		}
	}
}

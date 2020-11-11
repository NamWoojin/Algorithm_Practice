import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _17140_이차원배열과연산 {
	static class Node implements Comparable<Node>{
		int num, count;

		Node(int num, int count) {
			this.num = num;
		}

		@Override
		public int compareTo(Node o) {
			if(o.count == this.count)
				return this.num - o.num;
			return this.count - o.count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		int[][] A = new int[100][100];
		int rowMax = 3;
		int colMax = 3;
		for (int i = 0; i < 3; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; ++j) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time  = 0;
		while (true) {
			int max = 0;
			if(A[r][c] == k)
				break;
			if (rowMax >= colMax) {
				for (int i = 0; i < rowMax; ++i) {
					HashMap<Integer,Integer> map = new HashMap<>();
					PriorityQueue<Node> pq = new PriorityQueue<>();
					for(int j = 0; j<colMax;++j) {
						int num = A[i][j];
						if(num == 0)
							continue;
						if(map.containsKey(num)) {
							map.put(num, map.get(num)+1);
						}else {
							map.put(num,1);
						}
					}
					Iterator<Integer> iter = map.keySet().iterator();
					while(iter.hasNext()) {
						int key = iter.next();
						pq.add(new Node(key,map.get(key)));
					}
					int[] arr = new int[100];
					int idx = 0;
					while(!pq.isEmpty()) {
						Node n = pq.poll();
						arr[idx*2] = n.num;
						arr[idx*2+1] = n.count;
						++idx;
					}
					A[i] = arr;
					max = Math.max(idx*2, max);
				}
				colMax = max;
			} else {
				for (int i = 0; i < colMax; ++i) {
					HashMap<Integer,Integer> map = new HashMap<>();
					PriorityQueue<Node> pq = new PriorityQueue<>();
					for(int j = 0; j<rowMax;++j) {
						int num = A[j][i];
						if(num == 0)
							continue;
						if(map.containsKey(num)) {
							map.put(num, map.get(num)+1);
						}else {
							map.put(num,1);
						}
					}
					Iterator<Integer> iter = map.keySet().iterator();
					while(iter.hasNext()) {
						int key = iter.next();
						pq.add(new Node(key,map.get(key)));
					}
					int[] arr = new int[100];
					int idx = 0;
					while(!pq.isEmpty()) {
						Node n = pq.poll();
						arr[idx*2] = n.num;
						arr[idx*2+1] = n.count;
						++idx;
					}
					for(int p = 0; p<100;++p) {
						A[p][i] = arr[p];
					}
					max = Math.max(idx*2, max);
				}
				rowMax = max;
			}
			++time;
		}
		System.out.println(time);
	}
}

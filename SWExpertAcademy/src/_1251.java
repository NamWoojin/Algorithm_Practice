import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1251 {
	static class Node{
		int r; int c;
		Node(int r){
			this.r = r;
		}
	}
	static class distances implements Comparable<distances>{
		int startIdx;
		int endIdx;
		int distance;
		public distances(int startIdx, int endIdx, int distance) {
			super();
			this.startIdx = startIdx;
			this.endIdx = endIdx;
			this.distance = distance;
		}
		@Override
		public int compareTo(distances o) {
			// TODO Auto-generated method stub
			return this.distance - o.distance;
		}
		
	}
	static boolean[] isVisited;
	static distances[] distances;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(in.readLine());
			Node[] nodes = new Node[N];
			isVisited = new boolean[N];
			distances = new distances[N];
			StringTokenizer st =new StringTokenizer(in.readLine());
			for(int i = 0; i<N;++i) {
				nodes[i] = new Node(Integer.parseInt(st.nextToken()));
			}
			st =new StringTokenizer(in.readLine());
			for(int i = 0;i<N;++i) {
				nodes[i].c = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i<N;++i) {
				for(int j = i;j<N;++j) {
					
				}
			}
		}
	}
}

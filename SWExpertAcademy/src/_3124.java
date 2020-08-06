import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _3124 {
	static class Connect implements Comparable<Connect> {
		int from;
		int to;
		int weight;

		public Connect(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Connect o) {
			return this.weight - o.weight;
		}

	}

	static int[] parents;
	static int V;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {

			StringTokenizer st = new StringTokenizer(in.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ArrayList<Connect> arr = new ArrayList<>();
			parents = new int[V+1];
			for (int i = 0; i < E; ++i) {
				st = new StringTokenizer(in.readLine());
				arr.add(new Connect(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}
			arr.sort(null);
			long minSum = 0;
			int count = 0;
			make();
			for(int i = 0; i< arr.size();++i) {
				if(Union(arr.get(i).from,arr.get(i).to)) {//true:싸이클이 형성되지 않았다면
					minSum += arr.get(i).weight;
					if(++count == V-1) break;
				}
				
			}

			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(minSum);

		}
	}

	private static void make() {
		for(int i = 0; i<V+1;++i) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	private static boolean Union(int a, int b) {
		int aRoot = find(a);
		int bRoot =find(b);
		if(aRoot == bRoot) 
			return false;
		
		parents[bRoot] = aRoot;
		return true;
		
	}
}

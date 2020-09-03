import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1251 {
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		Node() {
		}
	}

	static class distance implements Comparable<distance> {
		int nodeNum;
		double dis;

		distance(int nodeNum, double dis) {
			this.nodeNum = nodeNum;
			this.dis = dis;
		}

		@Override
		public int compareTo(distance o) {
			// TODO Auto-generated method stub
			if (this.dis < o.dis)
				return -1;
			else if (this.dis == o.dis)
				return 0;

			return 1;
		}
	}

	static int N;
	static Node[] nodes;
	static boolean[] isVisited;
	static double E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(in.readLine());
			StringTokenizer st;
			nodes = new Node[N];
			isVisited = new boolean[N];

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; ++i) {
				nodes[i] = new Node();
				nodes[i].x = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; ++i) {
				nodes[i].y = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(in.readLine());
			long ans = Math.round(Prim()*E);
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static double Prim() {
		int count = 0;
		double sum = 0d;
		PriorityQueue<distance> pQueue = new PriorityQueue<>();
		pQueue.offer(new distance(0, 0));

		while (!pQueue.isEmpty()) {
			distance d = pQueue.poll();
			if (isVisited[d.nodeNum])
				continue;
			sum += d.dis;
			isVisited[d.nodeNum] = true;
			++count;
			
			if(count == N)
				break;

			for (int i = 0; i < N; ++i) {
				if (!isVisited[i]) {
					double length = Math.pow((nodes[d.nodeNum].x-nodes[i].x), 2)
							+ Math.pow((nodes[d.nodeNum].y - nodes[i].y), 2);
					pQueue.offer(new distance(i, length));
				}
			}
		}

		return sum;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _19535_ㄷㄷㄷㅈ_bfs {
	static class Line {
		int start, end;

		Line(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	static ArrayList<Integer>[] nodes;
	static boolean[] visited;
	static long Dtree, Gtree = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		nodes = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; ++i) {
			nodes[i] = new ArrayList<>();
		}
		int start  = 0;
		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(in.readLine());
			int idx = Integer.parseInt(st.nextToken())-1;
			int num = Integer.parseInt(st.nextToken())-1;
			nodes[num].add(idx);
			nodes[idx].add(num);
			start = num;
		}
		

//		for (int i = 0; i < N; ++i) { // ㅈ 찾기 : 연결된 노드 중 3개 고르는 조합 개수
//			if (nodes[i].size() > 2) {
//				Gtree += fact(nodes[i].size()) / (6 * fact(nodes[i].size() - 3));
//			}
//		}

		find(start);

//		System.out.println(Dtree + " " + Gtree);
		if (Dtree > Gtree * 3)
			System.out.println("D");
		else if (Dtree == Gtree * 3)
			System.out.println("DUDUDUNGA");
		else
			System.out.println("G");
	}

//	private static long fact(int num) {
//		if (num <= 1)
//			return 1;
//
//		return (fact(num - 1) * num);
//	}

	private static void find(int root) {
		Queue<Line> queue = new LinkedList<>();
		for(int i  =0; i<nodes[root].size();++i) {
			queue.offer(new Line(root,nodes[root].get(i)));
		}
		while (!queue.isEmpty()) {
			Line line = queue.poll();
//			System.out.println(line.start +" "+ line.end);
			Dtree += 1L* (nodes[line.start].size() - 1) * (nodes[line.end].size() - 1) ;
			if(!visited[line.start] && nodes[line.start].size()>=3) {
				visited[line.start] = true;
				int n = nodes[line.start].size();
				Gtree+= 1L * (n)*(n-1)*(n-2)/(3*2*1) ;
//				Gtree += fact(nodes[line.start].size()) / (6 * fact(nodes[line.start].size() - 3));
			}
			for(int i  =0; i<nodes[line.end].size();++i) {
				if(nodes[line.end].get(i) != line.start )
					queue.offer(new Line(line.end,nodes[line.end].get(i)));
			}
		}
	}
}

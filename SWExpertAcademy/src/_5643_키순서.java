import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _5643_키순서 {
	static class Node {
		ArrayList<Integer> up = new ArrayList<>();
		ArrayList<Integer> down = new ArrayList<>();
	}

	static boolean[] visited;
	static Node[] nodes;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());
			nodes = new Node[N];
			for (int i = 0; i < N; ++i) {
				nodes[i] = new Node();
			}
			for (int i = 0; i < M; ++i) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				nodes[b].down.add(a);
				nodes[a].up.add(b);
			}

			int count = 0;
			next: for (int i = 0; i < N; ++i) {
				visited = new boolean[N];
				scan(i, true);
				scan(i, false);
				for (int j = 0; j < N; ++j) {
					if (!visited[j])
						continue next;
				}
				++count;
			}
			System.out.println("#"+tc+" "+count);
		}
	}

	private static void scan(int idx, boolean up) {
		visited[idx] = true;
		ArrayList<Integer> array = up ? nodes[idx].up : nodes[idx].down;
		for (int i = 0; i < array.size(); ++i) {
			int num = array.get(i);
			if(!visited[num])
				scan(num,up);
		}
	}
}

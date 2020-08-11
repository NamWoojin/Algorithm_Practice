import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1219 {
	static class Node {
		int num;
		int next1 = -1;
		int next2 = -1;

		Node(int num) {
			this.num = num;
		}
	}

	static boolean[] isVisited;
	static Node[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			isVisited = new boolean[100];
			nodes = new Node[100];
			for (int i = 0; i < 100; ++i) {
				nodes[i] = new Node(i);
			}
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; ++i) {
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				if (nodes[n1].next1 == -1)
					nodes[n1].next1 = n2;
				else
					nodes[n1].next2 = n2;
			}
			sb.append("#").append(tc).append(" ");
			if (bfs())
				sb.append(1);
			else
				sb.append(0);

			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}

	static boolean bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(nodes[0]);
		isVisited[0] = true;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.num == 99)
				return true;
			if (node.next1 != -1 && !isVisited[node.next1]) {
				isVisited[node.next1] = true;
				queue.add(nodes[node.next1]);
			}
			if (node.next2 != -1 && !isVisited[node.next2]) {
				isVisited[node.next2] = true;
				queue.add(nodes[node.next2]);
			}
		}
		return false;
	}
}

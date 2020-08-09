import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2644 {
	static Node[] nodes;
	static boolean[] isVisited;
	static int person1;
	static int person2;
	static class Node {
		int num;
		ArrayList<Integer> tree = new ArrayList<>();
		int parent = 0;

		public Node(int num) {
			super();
			this.num = num;
		}

		public void add(int child) {
			tree.add(child);
		}

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st =new StringTokenizer(in.readLine());
		person1 = Integer.parseInt(st.nextToken());
		person2 = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(in.readLine());
		nodes = new Node[N+1];
		isVisited= new boolean[N+1];
		for(int i =0; i<N+1;++i) {
			nodes[i] = new Node(i);
		}
		for(int i = 0; i<m;++i) {
			st =new StringTokenizer(in.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			nodes[num1].add(num2);
			nodes[num2].add(num1);
			nodes[num2].parent = num1;
		}
		
		System.out.println(bfs(nodes[person1]));
	}
	
	static int bfs(Node person1) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(person1);
		isVisited[person1.num] = true;
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(--size>=0) {
				Node node = queue.poll();
				if(node.num == person2) {
					return count;
				}
				
				for(int i =0; i<node.tree.size();++i) {
					if(!isVisited[node.tree.get(i)] ) {
						isVisited[node.tree.get(i)] = true;
						queue.offer(nodes[node.tree.get(i)]);
					}
				}
			}
			++count;
		}
		return -1;
	}
}

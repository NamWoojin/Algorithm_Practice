import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _19542 {
	static Node[] nodes;
	static boolean[] isVisited;
	static int S;
	static int D;
	static int N;
	static int Count;

	public static int setDepth(int idx) {
		if (!nodes[idx].hasChild()) {
			nodes[idx].depth = 1;
			return 1;
		}
		int max = 0;
		for (int i = 0; i < nodes[idx].tree.size(); ++i) {
			int num = 1 + setDepth(nodes[idx].tree.get(i));
			max = Math.max(num, max);
		}
		nodes[idx].depth = max;
		return max;

	}
	
	public static void setPosition(int idx) {
		if(nodes[idx].parent == 0) {
			nodes[nodes[idx].parent].parent = idx;
			return;
		}
		nodes[nodes[idx].parent].deleteChild(idx);
		setPosition(nodes[idx].parent);
		nodes[nodes[idx].parent].add(nodes[nodes[idx].parent].parent);
		nodes[nodes[idx].parent].parent = idx;
	}
	
	public static int dfs(int idx,int count) {
		
		int newCount = count;
		for(int i = 0; i< nodes[idx].tree.size();++i) {
			int childNum = nodes[idx].tree.get(i);
			if(!isVisited[childNum]) {
				++newCount;
				isVisited[childNum] = true;
				newCount = dfs(nodes[childNum].num,newCount);
				++newCount;
			}
		}
		
		return newCount;
	}
	

	static class Node {
		int num;
		ArrayList<Integer> tree = new ArrayList<>();
		int parent = 0;
		int depth = 1;

		public Node(int num) {
			super();
			this.num = num;
		}

		public void add(int son) {
			tree.add(son);
		}

		public boolean hasChild() {
			return !tree.isEmpty();
		}
		
		public void deleteChild(int idx) {
			for(int i = 0 ;i<tree.size();++i) {
				if(tree.get(i) == idx)
					tree.remove(i);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		nodes = new Node[N + 1];
		isVisited = new boolean[N + 1];
		for (int i = 0; i < nodes.length; ++i) {
			nodes[i] = new Node(i);
		}
		for (int i = 0; i < N - 1; ++i) {
			String str = in.readLine();
			st = new StringTokenizer(str);
			int num = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			nodes[num].tree.add(child);
			nodes[child].parent = num;
		}
		setPosition(S);
		setDepth(S);
		for (int i = 0; i < nodes.length; ++i) {
			if (nodes[i].depth <= D)
				isVisited[i] = true;
		}

		
		System.out.println(dfs(S,0));
	}

}

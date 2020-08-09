import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class _19542_re {
	static Node[] nodes;
	static boolean[] isVisited;
	static int S;
	static int D;
	static int N;
	static int Count;
	
	public static int setDegree(int idx,int prevIdx) {
		if (idx != S &&!nodes[idx].hasDegree()) {	//리프노드 확인
			nodes[idx].degree = 1;
			return 1;
		}
		int max = 0;
		for (int i = 0; i < nodes[idx].tree.size(); ++i) {
			int n = nodes[idx].tree.get(i).num;
			if(n == prevIdx)
				continue;
			int num = 1 + setDegree(n,idx);	//간선 별 차수 계산
			max = Math.max(num, max);
		}
		nodes[idx].degree = max;	//제일 큰 차수 설정
		return max;

	}
	
	static class Node{
		int num;
		ArrayList<Node> tree = new ArrayList<>();	//연결 노드
		int degree = 1;								//차수
		Node(int num){
			this.num = num;
		}
		public boolean hasDegree() {	// 연결 노드 개수 여부 (연결노드개수 == 1 -> 리프노드)
			return !(tree.size() == 1);	
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());		//입력
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		nodes = new Node[N+1];	//node번호는 1부터 시작하므로
		isVisited = new boolean[N + 1];
		for(int i = 0; i<N+1;++i) {
			nodes[i] = new Node(i);
		}
		for (int i = 0; i < N - 1; ++i) {	//입력
			String str = in.readLine();
			st = new StringTokenizer(str);
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			nodes[num1].tree.add(new Node(num2));	//무방향그래프이므로 양쪽에 넣어줌
			nodes[num2].tree.add(new Node(num1));
		}
		setDegree(S,0);	//차수 계산
		for(int i= 0; i<N+1;++i) {
			if(nodes[i].degree<= D)
				isVisited[i] = true;	//해당 차수 이하인 노드는 방문처리
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(nodes[S]);
		isVisited[S] = true;
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(--size>=0) {
				Node node = queue.poll();
				for(int i =0; i<node.tree.size();++i) {
					int num = node.tree.get(i).num;
					
					if(!isVisited[num]) {
						isVisited[num] = true;
						queue.offer(nodes[num]);
						++count;
					}
				}
			}
		}
		
		return count*2;	//갔다가 돌아오므로 *2
		
	}
	
}

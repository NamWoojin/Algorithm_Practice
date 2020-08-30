import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _19535_ㄷㄷㄷㅈ_re {
	static class Node {
		ArrayList<Integer> array = new ArrayList<>();

		Node() {
		}

//		void remove(int num) {
//			for (int i = 0; i < array.size(); ++i) {	//연결 해제하기(0번으로 교체)
//				if (array.get(i) == num) {
//					array.set(i, 0);
//					return;
//				}
//			}
//		}

	}
	static Node[] nodes;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		nodes = new Node[N + 1];
		for (int i = 0; i < N + 1; ++i) {
			nodes[i] = new Node();
		}
		int root = 1;
		
		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(in.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			nodes[num].array.add(idx);
			nodes[idx].array.add(num);
			if (num == root)
				root = num;
		}
		nodes[0].array.add(root);
		int Dtree = 0, Gtree = 0;
				 
		for (int i = 1; i < N + 1; ++i) { // ㅈ 찾기 : 연결된 노드 중 3개 고르는 조합 개수
			if (nodes[i].array.size() > 2) {
				Gtree += fact(nodes[i].array.size()) / (6 * fact(nodes[i].array.size() - 3));
			}
		}
		
		Dtree = findD(0, root);
		
//		System.out.println(Dtree +" "+Gtree);
		if (Dtree > Gtree * 3)
			System.out.println("D");
		else if (Dtree == Gtree * 3)
			System.out.println("DUDUDUNGA");
		else
			System.out.println("G");
	}

	private static int fact(int num) {
		if (num <= 1)
			return 1;

		return (fact(num - 1) * num);
	}

	private static int findD(int prev, int next) {
//		nodes[prev].remove(next);	//서로 연결 해제하기(0번으로 교체)
//		nodes[next].remove(prev);

		int num = 0;
		for (int i = 0; i < nodes[next].array.size(); ++i) {
//			if (nodes[next].array.get(i) != 0 && nodes[nodes[next].array.get(i)].array.size() > 1) {	//연결된 노드가 0이 아니면서 다음 노드에 연결된 간선 수가 1개 초과일 때
//				num += findD(next, nodes[next].array.get(i));
//			}
			
			if (nodes[next].array.get(i) != prev && nodes[nodes[next].array.get(i)].array.size() > 1) {	//연결된 노드가 0이 아니면서 다음 노드에 연결된 간선 수가 1개 초과일 때
				num += findD(next, nodes[next].array.get(i));
			}
		}
		
		if (nodes[prev].array.size() > 1 && nodes[prev].array.size() > 1)			//양쪽 연결된 노드 개수 곱하기(서로의 연결 제외)
			return (nodes[prev].array.size() - 1) * (nodes[next].array.size() - 1) + num;
		else
			return num;

	}

}


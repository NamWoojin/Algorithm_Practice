import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//트리로 생각한 버전

public class _19535_ㄷㄷㄷㅈ {
	static class Node {
		int num;
		ArrayList<Integer> array = new ArrayList<>();

		Node(int num) {
			this.num = num;
		}
	}

	static Node[] nodes;
	static int Dtree = 0, Gtree = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		nodes = new Node[N + 1];
		for (int i = 0; i < N + 1; ++i) {
			nodes[i] = new Node(i);
		}
		int root = 1; // 루트 노드 찾기
		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(in.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			nodes[idx].array.add(num);
			if (num == root)
				root = num;
		}
		search(root, 1);
		System.out.println(Dtree + " " + Gtree);

		if (Dtree > Gtree * 3)
			System.out.println("D");
		else if (Dtree == Gtree * 3)
			System.out.println("DUDUDUNGA");
		else
			System.out.println("G");
	}

	private static void search(int node, int countD) {
		switch (countD) {// 위까지 3으로 내려왔을 때는 D+= 내 자식의 수
		case 3:
			Dtree += nodes[node].array.size();
			return;
		case 2:
			if (nodes[node].array.size() > 1) {
				Gtree += fact(nodes[node].array.size()) / (2 * fact(nodes[node].array.size() - 2));
			}
			break;
		case 1:
			if (nodes[node].array.size() > 2) {
				Gtree += fact(nodes[node].array.size()) / (6 * fact(nodes[node].array.size() - 3));
			}
			break;
		}

		for (int i = 0; i < nodes[node].array.size(); ++i) {
			search(nodes[node].array.get(i), countD + 1);
		}

		if (countD == 1) {
			for (int i = 0; i < nodes[node].array.size(); ++i) {
				search(nodes[node].array.get(i), 1);
			}
		}

	}

	private static int fact(int num) {
		if (num <= 1)
			return 1;

		return (fact(num - 1) * num);
	}
}

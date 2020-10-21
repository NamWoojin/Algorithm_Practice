import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _10888_음식배달 {
	static class Node {
		int r, c, num = 1;

		Node(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, storeNum, min, map[][];
	static ArrayList<Node> stores;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st;
			N = Integer.parseInt(in.readLine());
			stores = new ArrayList<>();
			map = new int[N][N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 1)
						stores.add(new Node(i, j, map[i][j]));
				}
			}
			storeNum = stores.size();
			subset(0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}

	private static void subset(int choice, int idx) {
		if (idx >= storeNum) {
			if(choice > 0)
				findMin(choice);
			return;
		}

		subset(choice, idx + 1);
		subset(choice | (1 << idx), idx + 1);
	}

	private static void findMin(int choice) {
		int total = 0;
		for (int i = 0; i < storeNum; ++i) {
			if ((choice & (1 << i)) > 0)
				total += stores.get(i).num;
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == 1) {
					int mindis = Integer.MAX_VALUE;
					for (int k = 0; k < storeNum; ++k) {
						if ((choice & (1 << k)) > 0) {
							Node n = stores.get(k);
							mindis = Math.min(mindis, Math.abs(i - n.r) + Math.abs(j - n.c));
						}
					}
					total += mindis;
				}
			}
		}
		min = Math.min(min, total);
	}
}

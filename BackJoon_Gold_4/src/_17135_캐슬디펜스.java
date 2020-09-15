import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _17135_캐슬디펜스 {
	static int N, M, D, max = 0;

	static class Node implements Comparable<Node> {
		int r, c;
		boolean delete = false;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		Node(Node n) {
			this.r = n.r;
			this.c = n.c;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.c - o.c;
		}
	}

	static ArrayList<Node> enemies = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken())-1;
		enemies = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; ++j) {
				if (st.nextToken().equals("1")) {
					enemies.add(new Node(i, j));
				}
			}
		}
		enemies.sort(null);
		subset(0, 0, 0);
		System.out.println(max);

	}

	public static void subset(int idx, int c_idx, int num) {
		if (c_idx == 3) {
			countMax(num);
			return;
		}

		if (idx == M) {
			return;
		}

		subset(idx + 1, c_idx, num);
		subset(idx + 1, c_idx + 1, num | (1 << idx));

	}

	public static void countMax(int num) {
		int[] pos = new int[3];
		int count = 0;
		for (int i = 0; i < M; ++i) {
			if ((num & (1 << i)) > 0)
				pos[count++] = i;
		}
		count = 0;
		ArrayList<Node> temp = new ArrayList<>();
		for (int i = 0; i < enemies.size(); ++i) {
			temp.add(new Node(enemies.get(i)));
		}
		while (temp.size() > 0) {
			for (int i = 0; i < 3; ++i) {
				int minDis = Integer.MAX_VALUE;
				int minidx = -1;
				for (int j = 0; j < temp.size(); ++j) {
					Node n = temp.get(j);
					int dis = Math.abs(n.r - N+1) + Math.abs(n.c - pos[i]);
					if (dis <= D && dis < minDis) {
						minidx = j;
						minDis = dis;
					}
				}
				if(minidx != -1)
					temp.get(minidx).delete = true;
			}
			for (int i = temp.size() - 1; i >= 0; --i) {
				Node n = temp.get(i);
				if (n.delete) {
					++count;
					temp.remove(i);
				} else {
					if (n.r == N - 1) {
						temp.remove(i);
					} else {
						++temp.get(i).r;
					}
				}
			}
		}
		max = Math.max(count, max);
	}
}

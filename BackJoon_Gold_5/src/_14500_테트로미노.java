import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14500_테트로미노 {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M, size, map[][], max = 0,addNum = 100000;
	static Node[] nodes = new Node[4];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		size = N * M;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		choice(0, 0,0);
		System.out.println(max);
	}

	private static void choice(int idx, int choice,int sum) {
		if (choice == 4) {
			if (sum > max &&connectionNode()) {
				max = sum;
			}
			return;
		}
		if (idx == size) {
			return;
		}

		choice(idx + 1, choice,sum);
		int r = idx/M;
		int c = idx%M;
		if (choice == 0 || (choice > 0 && (Math.abs(nodes[choice - 1].r - r) + Math.abs(nodes[choice - 1].c - c)) <= 3)) {
			nodes[choice] = new Node(r, c);
			map[r][c] += addNum;
			choice(idx + 1, choice + 1,sum + map[r][c] % addNum);
			map[r][c] %= addNum;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static boolean connectionNode() {
		Queue<Node> q = new LinkedList<>();
		q.offer(nodes[0]);
		map[nodes[0].r][nodes[0].c] += addNum;
		int connection = 1;
		while (!q.isEmpty()) {
			Node n = q.poll();
			for (int i = 0; i < 4; ++i) {
				int rr = n.r + dr[i];
				int cc = n.c + dc[i];
				if (rr < 0 || cc < 0 || rr >= N || cc >= M)
					continue;

				if(map[rr][cc] / addNum == 1 ) {
					++connection;
					q.offer(new Node(rr,cc));
					map[rr][cc] += addNum*2;
				}
				
			}
		}

		return connection == 4;
	}
}

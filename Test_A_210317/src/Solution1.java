
import java.util.Scanner;

public class Solution1 {
	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, map[][], maxConnect, minLength, nodeCount;
	static Node[] nodes;
	static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; ++tc) {
			N = sc.nextInt();
			map = new int[N][N];
			nodes = new Node[12];
			nodeCount = 0;
			maxConnect = 0;
			minLength = Integer.MAX_VALUE;
			// 입력 받기
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1) {
						nodes[nodeCount++] = new Node(i,j);
					}
				}
			}

			solve(0,0,0);
			System.out.println("#"+tc+" "+minLength);
		}
	}

	private static void solve(int index, int connection, int length) {
		if (index == nodeCount) {
			if (maxConnect < connection) {
				// 연결 개수 더 많으면
				maxConnect = connection;
				minLength = length;
			} else if (maxConnect == connection) {
				// 같으면 최소 길이 선택
				if(length < minLength)
					minLength = length;
			}
			return;
		}

		Node n = nodes[index];
		for (int i = 0; i < 4; ++i) {
			int rr = n.r;
			int cc = n.c;
			int count = 0;
			while (true) {
				rr += dr[i];
				cc += dc[i];

				if (rr < 0 || cc < 0 || rr >= N || cc >= N) {
					// 범위 밖으로 나가면 == 연결이 되면
					connect(index, i); // 연결하기
					solve(index + 1, connection + 1, length + count);
					disconnect(index, i); // 연결해제
					break;
				}
				if (map[rr][cc] == 0) {
					// 전선 배치 가능
					++count;
				} else {
					// 전선 배치 불가능
					break;
				}
			}
		}
		solve(index + 1, connection, length);
	}

	//전선 연결
	private static void connect(int index, int dir) {
		Node n = nodes[index];
		int rr = n.r;
		int cc = n.c;
		while (true) {
			rr += dr[dir];
			cc += dc[dir];

			if (rr < 0 || cc < 0 || rr >= N || cc >= N) {
				break;
			}
			map[rr][cc] = 2;
		}
	}

	//전선해제
	private static void disconnect(int index, int dir) {
		Node n =  nodes[index];
		int rr = n.r;
		int cc = n.c;
		while (true) {
			rr += dr[dir];
			cc += dc[dir];

			if (rr < 0 || cc < 0 || rr >= N || cc >= N) {
				break;
			}
			map[rr][cc] = 0;
		}
	}
}

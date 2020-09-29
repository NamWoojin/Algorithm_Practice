

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2589_보물섬 {
	static class Node {
		int r, c, count;

		Node(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean visited[][],arr[][];
	static int N,M;
	public static int execute() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(path));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new boolean[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			for (int j = 0; j < M; ++j) {
				arr[i][j] = (str.charAt(j) == 'L');
			}
		}
		

		int maxLength = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (arr[i][j] && !visited[i][j]) {
					maxLength = Math.max(maxLength, findTwoLand(i,j));
				}
			}
		}

		return maxLength; // 리턴값을 수정하세요
	} // end of execute

	private static int findTwoLand(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c, 0));
		visited[r][c] = true;
		int max = 0;
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			boolean move = false;
			for (int k = 0; k < 4; ++k) {
				int rr = n.r + dr[k];
				int cc = n.c + dc[k];

				if (rr < 0 || cc < 0 || rr > N - 1 || cc > M - 1 || visited[rr][cc] || !arr[rr][cc])
					continue;

				move = true;
				queue.offer(new Node(rr, cc, n.count + 1));
				visited[rr][cc] = true;
			}
			if (!move) {
				max = Math.max(findMinLength(n),max);
			}
		}
		
		return max;
	}
	
	private static int findMinLength(Node one) {
		boolean v[][] = new boolean[N][M];
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(one.r, one.c, 0));
		v[one.r][one.c] = true;
		int distance =0;
		while (!q.isEmpty()) {
			Node n = q.poll();
			boolean move = false;
			for (int k = 0; k < 4; ++k) {
				int rr = n.r + dr[k];
				int cc = n.c + dc[k];

				if (rr < 0 || cc < 0 || rr > N - 1 || cc > M - 1 || v[rr][cc] ||!arr[rr][cc])
					continue;

				move= true;
				q.offer(new Node(rr, cc, n.count + 1));
				v[rr][cc] = true;
			}
			if (!move) {
				distance = n.count;
			}
		}
		return distance;
	}
	public static void main(String[] args) throws IOException {
		System.out.println(execute());
	}
} // end of class
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16236_아기상어 {

	static class Node{
		int r, c;
		int size;

		Node() {
		}

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		Node(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}

		
		public int comparePos(Node o) {
			if(this.r == o.r)
				return this.c - o.c;
			return this.r - o.r;
		}
	}

	static int N;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] arr;
	static int length;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		Node babyShark = new Node();
		ArrayList<Node> fishes = new ArrayList<>();
		arr = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					arr[i][j] = 0;
					babyShark = new Node(i, j, 2);
				} else if (arr[i][j] != 0) {
					fishes.add(new Node(i, j, arr[i][j]));
				}
			}
		}
		Node target = findNearFish(babyShark);
		int totalLength = 0;
		int eatNum = 0;
		while(target != null) {
			target.size = babyShark.size;
			babyShark = target;
			arr[target.r][target.c] = 0;
			totalLength += length;
			if(++eatNum  == babyShark.size) {
				++babyShark.size;
				eatNum = 0;
			}
			target = findNearFish(babyShark);
		}
		System.out.println(totalLength);
	}

	private static Node findNearFish(Node babyShark) {
		boolean[][] visited = new boolean[N][N];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(babyShark.r, babyShark.c));
		visited[babyShark.r][babyShark.c] = true;
		length = 0;
		Node target = null;
		boolean findAns = false;
		while (!queue.isEmpty() && !findAns) {
			int size = queue.size();
			while (--size >= 0) {
				Node n = queue.poll();
				for (int i = 0; i < 4; ++i) {
					int rr = n.r + dr[i];
					int cc = n.c + dc[i];
					if(rr <0 || cc<0|| rr>=N|| cc>=N)
						continue;
					
					if(!visited[rr][cc]&& arr[rr][cc] <= babyShark.size) {
						Node node= new Node(rr,cc);
						visited[rr][cc] =true;

						if(arr[rr][cc] == 0 || arr[rr][cc] == babyShark.size)
							queue.offer(node);
						else {
							if(target == null)target = node;
							else 
								target = target.comparePos(node) < 0 ? target :node;
							findAns = true;
						}
					}
				}
			}
			++length;
		}
		return target;
	}
}

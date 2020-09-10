import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5656_벽돌깨기 {
	static int[][] array, tempArray;
	static int[] top, tempTop;
	static int N, W, H,all, max = 0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			array = new int[H][W];
			top = new int[W];
			all = 0;
			for (int i = 0; i < H; ++i) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; ++j) {
					array[i][j] = Integer.parseInt(st.nextToken());
					if(array[i][j]!=0)
						++all;
					if (top[j] == 0 && array[i][j] != 0)
						top[j] = i;
				}
			}
			dfs(0,0);
			System.out.println(max);
		}
	}

	private static void dfs(int count, int sum) {
		if (count == N) {
			
			max = Math.max(all-sum, max);
			return;
		}

		for (int i = 0; i < W; ++i) {
			if (top[i] != 0) {
				copying();
				int num = breaking(top[i], i);
				align();
				dfs(count+1,sum+num);
				recovering();
			}
		}
	}

	private static int breaking(int r, int c) {
		boolean[][] visited = new boolean[H][W];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		visited[r][c] = true;
		int count = 0;
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			int num = array[n.r][n.c];
			array[n.r][n.c] = 0;
			++count;
			for (int k = 0; k < 4; ++k) {
				int cnt = 0;
				int rr = n.r;
				int cc = n.c;
				while(++cnt<num) {
					rr += dr[k];
					cc += dc[k];
					
					if(rr<0||cc<0||rr>=H||cc>=W)
						break;
					if(visited[rr][cc])
						continue;
					
					visited[rr][cc] = true;
					queue.offer(new Node(rr,cc));
				}
			}
		}
//		for(int i = 0; i<H;++i)
//			System.out.println(Arrays.toString(array[i]));
//		System.out.println();
		return count;
	}

	private static void align() {
		for(int i = 0;i<W;++i) {
			int down = H-1;
			int up= H-1;
			boolean find = false;
			for(int j = H-1;j>0;--j) {
				if(array[j][i] == 0) {
					find = true;
				}else {
					if(find){
						array[down][i] = array[up][i];
						array[up][i] = 0;
						--top[i];
					}
					--down;
				}
				--up;
			}
		}
//		for(int i = 0; i<H;++i)
//			System.out.println(Arrays.toString(array[i]));
//		System.out.println();
	}

	private static void copying() {
		tempArray = new int[H][];
		for (int j = 0; j < array.length; ++j) {
			tempArray[j] = array[j].clone();
		}
		tempTop = top.clone();
	}

	private static void recovering() {
		array = tempArray;
		top = tempTop;
	}

}

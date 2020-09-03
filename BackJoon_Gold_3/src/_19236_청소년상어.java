import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//미완
public class _19236_청소년상어 {
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static Node shark;

	static class Node {
		int r, c;
		int dir;
		int count = 0;

		Node(int r, int c, int dir) {
			this.dir = dir;
			this.r = r;
			this.c = c;
		}
		Node(int r, int c, int dir,int count) {
			this.dir = dir;
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}

	// 상어 = -1, 물고기 없음 = 0
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] pond = new int[4][4];
		Node[] nodes = new Node[17];
		for (int i = 0; i < 4; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 4; ++j) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				pond[i][j] = num;
				nodes[num] = new Node(i, j, dir);
			}
		}

		shark = new Node(0, 0, nodes[pond[0][0]].dir);
		shark.count = pond[0][0];
		nodes[pond[0][0]] = null;
		pond[0][0] = -1;

		moveFish(pond, nodes);

	}

	private static int moveFish(int[][] pond, Node[] nodes) {
		for (int i = 1; i < 17; ++i) {
			if (nodes[i] == null)
				continue;

			int r = nodes[i].r;
			int c = nodes[i].c;
			for (int j = 0; j < 8; ++j) {
				int rr = r + dr[nodes[i].dir % 8];
				int cc = r + dc[nodes[i].dir % 8];

				if (rr < 0 || cc < 0 || rr >= 4 || cc >= 4 || pond[rr][cc] == -1) {
					++nodes[i].dir;
					continue;
				}
				
				if(pond[rr][cc] == 0) {
					pond[rr][cc] = pond[r][c];
					pond[r][c] = 0;
					continue;
				}

				int num = pond[rr][cc];
				nodes[i].dir ^= nodes[num].dir;
				nodes[num].dir ^= nodes[i].dir;
				nodes[i].dir ^= nodes[num].dir;

				pond[rr][cc] ^= pond[r][c];
				pond[r][c] ^= pond[rr][cc];
				pond[rr][cc] ^= pond[r][c];

				break;
			}
		}

		return moveShark(pond, nodes);
	}

	private static int moveShark(int[][] pond, Node[] nodes) {
		int rr = shark.r;
		int cc = shark.c;
		int max = 0;
		pond[shark.r][shark.c] = 0;
		while (true) {
			rr += dr[shark.dir % 8];
			cc += dc[shark.dir % 8];
			if (rr < 0 || cc < 0 || rr >= 4 || cc >= 4) {
				break;
			}
			Node prevShark = shark;
			Node prevFish = nodes[pond[rr][cc]];
			nodes[pond[rr][cc]] = null;
			int fishNum = pond[rr][cc];
			int[][] tempPond = new int[4][];
			for(int i =0; i<4;++i) {
				tempPond[i] = pond[i].clone();
			}
			tempPond[rr][cc] = -1;
			
			
			shark = new Node(rr,cc,nodes[pond[rr][cc]].dir,shark.count+fishNum);
			max= Math.max(max,moveFish(tempPond,nodes) +prevShark.count);
			
			shark = prevShark;
			nodes[pond[rr][cc]] = prevFish;
		}

		return max;
	}

}

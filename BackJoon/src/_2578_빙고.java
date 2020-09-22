import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2578_빙고 {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, -1, 0, 1 }; // 상,우상,우,우하
	static int[] dc = { 0, 1, 1, 1 };
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[5][5];
		Node[] nodes = new Node[26];
		StringTokenizer st;
		for (int i = 0; i < 5; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				nodes[arr[i][j]] = new Node(i, j);
			}
		}
		
		int bingoCount = 0;
		out: for (int i = 0; i < 5; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; ++j) {
				Node n = nodes[Integer.parseInt(st.nextToken())];
				arr[n.r][n.c] = 0;
				bingoCount += bingo(n.r, n.c);
				
				if (bingoCount >= 3) {
					System.out.println(i * 5 + j + 1);
					break out;

				}
			}
		}
	}

	static int bingo(int r, int c) {
		int bingoCount = 0;
		for (int i = 0; i < 4; ++i) {
			if (i % 2 == 1) { // 대각선 방향은 (0,0)~(4,4) 또는 (4,0)~(0,4)만 확인하면 됨 그 이외에는 continue
				if (r != c && r != 4 - c)
					continue;
			}
			
			if(findBingo(r,c,i))
				++bingoCount;
		}
		return bingoCount;
	}
	
	static boolean findBingo(int r, int c,int dir) {
		int rr = r;
		int cc = c;
		int count=0;
		while(true) {
			rr+=dr[dir];
			cc+=dc[dir];
			if(rr>4 || cc>4 || rr<0 || cc<0)
				break;
			++count;
			if(arr[rr][cc] != 0)
				return false;
		}
		rr = r;
		cc = c;
		while(true) {
			rr-=dr[dir];
			cc-=dc[dir];
			if(rr>4 || cc>4 || rr<0 || cc<0)
				break;
			++count;
			if(arr[rr][cc] != 0)
				return false;
		}
		if(count==4)
			return true;
		return false;
	}
}

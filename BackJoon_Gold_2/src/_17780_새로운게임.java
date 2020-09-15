import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17780_새로운게임 {
	static class Node {
		int r, c;
		int dir;
		int num;
		Deque<Integer> upNode = new ArrayDeque<>();

		Node(int num, int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.num = num;
		}

		Node(int num, int r, int c, int dir, Deque<Integer> deque) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.num = num;
			this.upNode = deque;
		}
	}

	static int dr[] = { 0, 0, -1, 1 };
	static int dc[] = { 1, -1, 0, 0 };
	static int N, K;
	static int[][] board;
	static Deque<Integer> nodeNum;
	static Node[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		nodeNum = new LinkedList<>();
		nodes = new Node[K + 1];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1)
					board[i][j] = 11;
				else if (board[i][j] == 2)
					board[i][j] = 22;
			}
		}
		for (int i = 1; i <= K; ++i) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()) - 1;
			nodeNum.add(i);
			nodes[i] = new Node(i, r, c, dir);
			board[r][c] += i;
		}
		System.out.println(tern());
	}

	private static int tern() {
		int count = 0;

		while (!nodeNum.isEmpty()) {
			int size = nodeNum.size();
			
			++count;
			while (--size >= 0) {
				for (int i = 0; i < N; ++i) {
					System.out.println(Arrays.toString(board[i]));
				}
				System.out.println();
				Node n = nodes[nodeNum.poll()];
				int r = n.r;
				int c = n.c;
				board[r][c] -= n.num;// 보드 원상태 복구
				if (n.upNode.size() >= 3) {
					return count-1;
				}
				r += dr[n.dir];
				c += dc[n.dir];

				if (r < 0 || c < 0 || r > N - 1 || c > N - 1) {
					switch (n.dir) {
					case 0:
						n.dir = 1;
						break;
					case 1:
						n.dir = 0;
						break;
					case 2:
						n.dir = 3;
						break;
					case 3:
						n.dir = 2;
						break;
					}
					if(board[n.r+dr[n.dir]][n.c+dc[n.dir]] == 22)
						return -1;
					
					board[n.r][n.c] += n.num;
					++size;
					nodeNum.push(n.num);
					continue;
				}

				if(move(n, r, c))
					return count;
				
				System.out.println(count);
				
			}
			if (count > 1000)
				return -1;
			
		}

		return count;
	}

	private static boolean move(Node n, int r, int c) {
		System.out.println(n.num+" "+n.r+" "+n.c+" "+n.dir);
		// 0 : 아무 말도 없는 흰색 칸
		// 1~10 : 어떤 말이 있는 흰색 칸
		// 11: 아무 말도 없는 빨간 칸
		// 12~21: 어떤 말이 있는 빨간 칸
		// 22: 아무 말도 없는 파란 칸
		if (board[r][c] == 0) {
			board[r][c] += n.num;
			n.r = r;
			n.c = c;
			nodeNum.offer(n.num);

		} else if (board[r][c] < 11) {
			int num = board[r][c];
			nodes[num].upNode.push(n.num);
			while (!n.upNode.isEmpty()) {
				nodes[num].upNode.push(n.upNode.pollFirst());
			}
			if(nodes[num].upNode.size() >=3)
				return true;

		} else if (board[r][c] == 11) {
			Deque<Integer> tempS = new ArrayDeque<>();
			int newNum =n.num;
			if(!n.upNode.isEmpty())	//비어있지 않다면 맨 위가 새로운 밑
				newNum = n.upNode.pop();
			
			while (!n.upNode.isEmpty()) {
				tempS.push(n.upNode.pop());
			}
			tempS.push(n.num);
			
			
			board[r][c] += newNum;
			nodes[newNum].r = r;
			nodes[newNum].c = c;
			nodes[newNum].upNode = tempS;
			System.out.println(nodes[newNum].r+" "+nodes[newNum].c);
			nodeNum.offer(newNum);

		} else if (board[r][c] < 22) {
			Queue<Integer> tempS = new LinkedList<>();
			
			while (!n.upNode.isEmpty()) {
				tempS.offer(n.upNode.pop());
			}
			tempS.offer(n.num);
			int num = board[r][c] - 11;
			
			while (!tempS.isEmpty()) {
				nodes[num].upNode.push(tempS.poll());
			}
			
			if(nodes[num].upNode.size() >=3)
				return true;

		} else {
			switch (n.dir) {
			case 0:
				n.dir = 1;
				break;
			case 1:
				n.dir = 0;
				break;
			case 2:
				n.dir = 3;
				break;
			case 3:
				n.dir = 2;
				break;
			}
			int rr = r + dr[n.dir]*2;
			int cc = c + dc[n.dir]*2;
			
			if (rr < 0 || cc < 0 || rr > N - 1 || cc > N - 1)
				return false;
			if(board[rr][cc] == 22) {
				board[n.r][n.c] += n.num;
				nodeNum.push(n.num);
			}
			move(n, rr, cc);
		}
		
		return false;
	}
}

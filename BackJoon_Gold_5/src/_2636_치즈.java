import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2636_치즈 {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int arr[][], R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		int time = 0;
		int lastCnt = 0;
		for (int i = 0; i < R; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					++lastCnt;
			}
		}

		mark(0, 0, -1); // 바깥 체크
		
		int cnt = lastCnt;
		while (cnt>0) {
			lastCnt = cnt;
			for (int i = 1; i < R - 1; ++i) {
				for (int j = 1; j < C - 1; ++j) {

					if (arr[i][j] == 1) {
						boolean gone = false;
						boolean inside = false;
						for (int k = 0; k < 4; ++k) {
							int rr = i + dr[k];
							int cc = j + dc[k];
							// 사방에 위치한 것이 이번 턴에 사라질 자리가 아니고, 치즈가 아니고, 치즈사이 구멍이 아니라면 사라져야 하는 위치이다.
							if (arr[rr][cc] != time + 2 && arr[rr][cc] != 1 && arr[rr][cc] != 0) {
								gone = true;
							}
							if (arr[rr][cc] == 0) {
								inside = true;
							}
						}

						if(gone){
							if (inside) // 사라지는 노드 중 내부 공기가 닿아 있으면 그 공기있던 자리는 외부에 노출된다.
								mark(i, j, time + 2);
							arr[i][j] = time + 2;
							--cnt;
						}
					}

				}
			}
			++time;
		}
		System.out.println(time);
		System.out.println(lastCnt);

	}

	private static void mark(int r, int c, int in) {
		Queue<Node> markQ = new LinkedList<>();
		markQ.offer(new Node(r, c));
		arr[r][c] = in;
		while (!markQ.isEmpty()) {
			Node n = markQ.poll();
			
			for (int i = 0; i < 4; ++i) {
				int rr = n.r + dr[i];
				int cc = n.c + dc[i];
				if (rr < 0 || cc < 0 || rr >= R || cc >= C)
					continue;
				if (arr[rr][cc] == 0) {
					arr[rr][cc] = in;
					markQ.offer(new Node(rr, cc));
				}
			}
		}
	}

}

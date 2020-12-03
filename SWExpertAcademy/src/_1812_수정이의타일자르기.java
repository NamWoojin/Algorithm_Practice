import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1812_수정이의타일자르기 {
	static class Square implements Comparable<Square> {
		int r;
		int c;

		Square(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Square o) {
			int minO = Math.min(o.r, o.c);
			int minThis = Math.min(this.r, this.c);
			return minO - minThis;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; ++i) {
				pQueue.offer(Integer.parseInt(st.nextToken()));
			}
			Queue<Integer> Queue = new LinkedList<>();
			Queue<Integer> temp = new LinkedList<>();
			while (!pQueue.isEmpty()) {
				Queue.offer((int) Math.pow(2, pQueue.poll())); // 한 변의 길이로 계산해서 넣어주기
			}

			PriorityQueue<Square> squares = new PriorityQueue<>();

			int count = 1;
			while (true) {
				squares.clear();
				squares.offer(new Square(M, M));
				while (!Queue.isEmpty()) {
					int line = Queue.poll();
					// 사각형 넣어보고
					// 들어가면 들어감 처리
					Square sq = squares.peek();
					
					if (sq != null && sq.r >= line && sq.c >= line) {
						squares.poll();
						if (sq.r != line) {
							squares.offer(new Square(sq.r - line, sq.c));
						}
						if (sq.c != line) {
							squares.offer(new Square(sq.c - line, line));
						}
					}
					else {
						// 안들어가면 temp에 넣기
						temp.offer(line);
					}
				}
				if (temp.isEmpty()) {
					break;
				} else {
					Queue = temp;
					temp = new LinkedList<>();
					++count;
				}
			}

			System.out.println("#" + tc + " " + count);
		}
	}
}

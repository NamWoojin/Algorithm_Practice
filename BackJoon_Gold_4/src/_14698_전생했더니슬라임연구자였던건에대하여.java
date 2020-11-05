import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14698_전생했더니슬라임연구자였던건에대하여 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
//			long[] arr = new long[N];
			PriorityQueue<Long> pq = new PriorityQueue<>();
			Queue<Long> q = new LinkedList<>();
			for (int i = 0; i < N; ++i) {
				pq.add(Long.parseLong(st.nextToken()));
//				arr[i] = Long.parseLong(st.nextToken());
			}
//			Arrays.sort(arr);
			long answer = 1;
			while (pq.size() + q.size() > 1) {	//슬라임이 하나 남을때까지
				long num1 = 0;
				long num2 = 0;
				if(q.isEmpty())
					num1 = pq.poll();
				else if(pq.isEmpty()){
					num1 = q.poll();
				}else {
					if(pq.peek() > q.peek()) {
						num1 = q.poll();
					}else {
						num1 = pq.poll();
					}
				}
				
				if(q.isEmpty())
					num2 = pq.poll();
				else if(pq.isEmpty()){
					num2 = q.poll();
				}else {
					if(pq.peek() > q.peek()) {
						num2 = q.poll();
					}else {
						num2 = pq.poll();
					}
				}
				long mul = (num1 * num2);
				q.add(mul);
				answer = ((answer%1000000007) * mul)%1000000007;
			}
			System.out.println(answer%1000000007);

//			if (N == 1)
//				System.out.println(answer);
//			else {
//				int idx = 0;
//				while (!(idx == N && q.size() == 1)) { // 슬라임이 하나 남을때까지
//					long num1 = 0;
//					long num2 = 0;
//					if (q.isEmpty())
//						num1 = arr[idx++];
//					else if (idx == N) {
//						num1 = q.poll();
//					} else {
//						if (arr[idx] > q.peek()) {
//							num1 = q.poll();
//						} else {
//							num1 = arr[idx++];
//						}
//					}
//
//					if (q.isEmpty())
//						num2 = arr[idx++];
//					else if (idx == N) {
//						num2 = q.poll();
//					} else {
//						if (arr[idx] > q.peek()) {
//							num2 = q.poll();
//						} else {
//							num2 = arr[idx++];
//						}
//					}
//
//					long mul = (num1 * num2)>Long.MAX_VALUE ? (num1 * num2) % 1000000007 : (num1 * num2);
//					q.add(mul);
//					answer *= mul;
//				}
//				System.out.println(answer % 1000000007);
//			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _8275_햄스터 {
	static int orders[][], N, X, M, area[], answer[], answerSum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			area = new int[N];
			orders = new int[M][3];
			answerSum = -1;
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(in.readLine());
				orders[i][0] = Integer.parseInt(st.nextToken()) - 1;
				orders[i][1] = Integer.parseInt(st.nextToken()) - 1;
				orders[i][2] = Integer.parseInt(st.nextToken());

			}
			
			fillArea(0,0);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			if (answerSum == -1) {
				sb.append(-1);
			} else {
				for (int i = 0; i < N; ++i) {
					sb.append(answer[i]).append(" ");
				}
			}
			System.out.println(sb);
		}
	}

	private static void fillArea(int idx,int sum) {
		if (idx == N) {
			findCorrect(0,sum);
			return;
		}

		for (int i = 0; i <= X; ++i) {
			area[idx] = i;
			fillArea(idx + 1,sum+i);
		}
	}

	private static void findCorrect(int idx,int total) {
		if (idx == M) {
			if(total > answerSum) {
				answer = area.clone();
				answerSum = total;
			}
			return;
		}
		int sum = 0;
		for (int i = orders[idx][0]; i <= orders[idx][1]; ++i) {
			sum += area[i];
		}
		if (sum == orders[idx][2]) {
			findCorrect(idx + 1,total);
		}
	}

	/*
	 * 누적합을 사용해서 풀 수도 있다!
	 */
}

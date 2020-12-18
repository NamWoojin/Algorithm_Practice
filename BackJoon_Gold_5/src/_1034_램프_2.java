import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1034_램프_2 {
	static int N, M, K, max = 0;
	static long ones = 0, lamps[];
	static long zeros[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lamps = new long[M];
		zeros = new long[N][2];	//0의 개수, 0의 위치
		for (int i = 0; i < N; ++i) {
			char[] chars = in.readLine().toCharArray();
			for (int j = 0; j < M; ++j) {
				if (chars[j] == '1')
					lamps[j] = lamps[j] | (1 << i);
				else {
					++zeros[i][0];
					zeros[i][1] = zeros[i][1] | (1 << j);
				}
			}
		}
		K = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; ++i) { // xor을 위한 111111... 숫자 만들기
			ones |= (1 << i);
		}

		for(int i = 0; i< N;++i) {
			//0의 개수가 K개이거나, 0의 개수가 K개보다 크면서 K를 뺀 나머지가 짝수일 경우
			if(zeros[i][0] == K || (zeros[i][0] - K > 0 && (zeros[i][0]- K)%2 == 0)) {
				change(0, i);
			}
		}

		System.out.println(max);

	}

	static void change(int idx, int num) {
		if(idx == N) {
			max = Math.max(countLight(),max);
			return;
		}
		
		if((zeros[num][1]&(1<<idx))>0)
			lamps[idx] ^= ones;
		change(idx+1,num);
		if((zeros[num][1]&(1<<idx))>0)
			lamps[idx] ^= ones;
	}

	static int countLight() {
		int total = 0;

		next: for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if ((lamps[j] & (1 << i)) == 0)
					continue next;
			}
			++total;
		}

		return total;
	}
}

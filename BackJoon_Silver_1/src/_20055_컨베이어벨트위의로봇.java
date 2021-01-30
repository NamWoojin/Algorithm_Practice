import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20055_컨베이어벨트위의로봇 {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int length = N * 2;
		int[][] arr = new int[length][2];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < length; ++i) {
			arr[i][0] = Integer.parseInt(st.nextToken());
		}

		int level = 0;
		int upIdx = 0;
		int downIdx = N - 1;
		while (true) {
			++level;

			// 벨트 회전
			upIdx = (upIdx + length - 1) % length;
			downIdx = (downIdx + length - 1) % length;
			// 내려가는 위치 확인
			if(arr[downIdx][1] == 1)
				arr[downIdx][1] = 0;
			
			int idx = downIdx;
			while (idx != upIdx) {
				if (arr[idx][1] == 1) { // 이 칸에 로봇이 있으면
					int nextIdx = (idx + 1) % length;
					if(arr[nextIdx][0] > 0 &&arr[nextIdx][1] == 0) {	//다음 칸이 이동할 수 있는 칸이면
						--arr[nextIdx][0];
						arr[nextIdx][1] = 1;
						arr[idx][1] = 0;
					}
				}
				idx = (idx + length - 1) % length;
			}
			
			// 내려가는 위치 확인
			if(arr[downIdx][1] == 1)
				arr[downIdx][1] = 0;
			
			// 올라가는 위치 올리기
			if(arr[upIdx][1] == 0 && arr[upIdx][0] >0) {
				--arr[upIdx][0];
				arr[upIdx][1] = 1;
			}
			
			//내구도 0인 칸의 개수 세기
			int zero = 0;
			for(int i =0; i<length;++i) {
				if(arr[i][0] == 0)
					++zero;
			}
			if(zero >= K)
				break;
		}
		System.out.println(level);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3234_준환이의양팔저울 {
	// 오른쪽에 하나도없는 경우~ 오른쪽에 N-1개 올리는 경우
	static int[] array;
	static int[] sel;
	static boolean[] check;
	static boolean[] isLeft;
	static int N, cnt, totalSum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(in.readLine());
			array = new int[N];
			sel = new int[N];
			check = new boolean[N];
			isLeft = new boolean[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; ++i) {
				array[i] = Integer.parseInt(st.nextToken());
				totalSum += array[i];
			}

			cnt = 0;
			perm(0);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(cnt);
			System.out.println(sb.toString());
		}
	}

//	static void powerSet(int idx, int sumL, int sumR) { // 부분집합 만들기
//		if (sumR > sumL)
//			return;
//
//		if (idx == N) {
//			++cnt;
//			return;
//		}
//		//추를 순서대로 올리면서 비교, 순서에 맞춰서 올릴때에도 오른쪽인 왼쪽보다 크면 안됨
//		powerSet(idx + 1, sumL+sel[idx], sumR);
//		powerSet(idx + 1, sumL, sumR + sel[idx]);
//	}
	static void powerSet(int idx) {
		if (idx == N) {
			int sumL = 0, sumR = 0;
			for (int i = 0; i < N; i++) {
				if (isLeft[i])
					sumL += sel[i];
				else
					sumR += sel[i];
				if (sumR > sumL)
					return;
			}
			cnt++;
			return;
		}
		isLeft[idx] = true;
		powerSet(idx + 1);
		isLeft[idx] = false;
		powerSet(idx + 1);
	}

	static void perm(int idx) { // 순열 만들기
		// 모두 골랐다.
		if (idx == N) {
//			powerSet(0, 0, 0);
			powerSet(0);
			return;
		}
		for (int i = 0; i < N; i++) {
			// 안고른 놈에 대해서만
			if (!check[i]) {
				check[i] = true;// 고른걸로 체크해두고
				sel[idx] = array[i];
				perm(idx + 1);
				check[i] = false;// 다시 돌아왔을땐 체크해제
			}
		}
	}
}


public class 부분집합의_합중최대 {
	static int[] arr;
	static boolean[] sel;
	static int N;
	static int max = 0;
	static void powerSet(int idx) {
		if (idx == N) {
			int sum =0;
			//sel이 true인 인덱스의 arr의 원소들을 모두 더하면 부분집합의 합
			for (int i = 0; i < N; i++) {
				if(sel[i])
					sum += arr[i];
			}
			if(max < sum)
				max = sum;
			return;
		}
		// idx번째 원소를 고른걸로 체크해두고 다음 원소로 이동
		sel[idx] = true;
		powerSet(idx + 1);
		// idx번째 원소를 안고른걸로 체크해두고 다음 원소로 이동
		sel[idx] = false;
		powerSet(idx + 1);
	}

	public static void main(String[] args) {
		N = 3;
		arr = new int[N];
		sel = new boolean[N];

		arr[0] = 10;
		arr[1] = -17;
		arr[2] = 54;
		powerSet(0);
		System.out.println(max);
	}

}

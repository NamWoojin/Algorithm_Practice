
public class 부분집합의_합중최대 {
	static int[] arr;
	static boolean[] sel;
	static int N;
	static int max = 0;
	static void powerSet(int idx) {
		if (idx == N) {
			int sum =0;
			//sel�� true�� �ε����� arr�� ���ҵ��� ��� ���ϸ� �κ������� ��
			for (int i = 0; i < N; i++) {
				if(sel[i])
					sum += arr[i];
			}
			if(max < sum)
				max = sum;
			return;
		}
		// idx��° ���Ҹ� ���ɷ� üũ�صΰ� ���� ���ҷ� �̵�
		sel[idx] = true;
		powerSet(idx + 1);
		// idx��° ���Ҹ� �Ȱ��ɷ� üũ�صΰ� ���� ���ҷ� �̵�
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

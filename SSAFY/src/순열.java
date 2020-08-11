import java.util.Arrays;

public class 순열 {
	static int N = 3;
	static int[] arr = {1,3,5};
	static int[] sel = new int[3];	//arr�� ���� ũ��...?
	static boolean[] check = new boolean[3];
	static void perm(int idx) {
		if(idx == 3) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for(int i = 0; i<N;++i) {
			//���� ���� ���ڿ� ���ؼ��� ����
			if(!check[i]) {
				check[i] = true;
				sel[idx] = arr[i];	//������ ���� = 3 -> 3�� Ʈ��
				perm(idx +1);
				check[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) {
		perm(0);
	}

}


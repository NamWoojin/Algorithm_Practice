import java.util.Arrays;

public class 조합 {
	static int[] arr = {1,2,3};
	static int N = 3;
	static int R = 2;
	static int[] sel = new int[2];
	static void comb(int upArrow,int downArrow) {
		if(downArrow ==R) {	//�Ʒ� ȭ��ǥ�� ������ ���
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(upArrow == N) {	//�� ȭ��ǥ�� ������ �ƿ�
			return;
		}
		
		//�� ȭ��ǥ ��ġ�� ���ڸ� �Ʒ� ȭ��ǥ ��ġ�� ��´�.
		//���� ȭ��ǥ +1, �Ʒ� ȭ��ǥ +1
		//���� ȭ��ǥ +1, �Ʒ� ȭ��ǥ �״��		
		
		sel[downArrow] = arr[upArrow];
		comb(upArrow+1,downArrow+1);
		comb(upArrow+1,downArrow);
	}
	public static void main(String[] args) {
		comb(0,0);
	}

}

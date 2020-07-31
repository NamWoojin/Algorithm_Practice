import java.util.Arrays;

public class 중복순열 {
	static int N = 3;
	static int[] arr = {1,3,5};
	static int[] sel = new int[3];
	static void perm(int idx) {
		if(idx == 3) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for(int i = 0; i<N;++i) {
			sel[idx] = arr[i];	//원소의 개수 = 3 -> 3진 트리
			perm( idx +1);
		}
		
	}
	
	public static void main(String[] args) {
		
	}

}


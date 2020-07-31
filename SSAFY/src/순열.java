import java.util.Arrays;

public class 순열 {
	static int N = 3;
	static int[] arr = {1,3,5};
	static int[] sel = new int[3];	//arr과 같은 크기...?
	static boolean[] check = new boolean[3];
	static void perm(int idx) {
		if(idx == 3) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for(int i = 0; i<N;++i) {
			//고르지 않은 숫자에 대해서만 수행
			if(!check[i]) {
				check[i] = true;
				sel[idx] = arr[i];	//원소의 개수 = 3 -> 3진 트리
				perm(idx +1);
				check[i] = false;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		perm(0);
	}

}


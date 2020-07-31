import java.util.Arrays;

public class 조합 {
	static int[] arr = {1,2,3};
	static int N = 3;
	static int R = 2;
	static int[] sel = new int[2];
	static void comb(int upArrow,int downArrow) {
		if(downArrow ==R) {	//아래 화살표가 나가면 출력
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(upArrow == N) {	//위 화살표가 나가면 아웃
			return;
		}
		
		//위 화살표 위치의 숫자를 아래 화살표 위치에 담는다.
		//위에 화살표 +1, 아래 화살표 +1
		//위에 화살표 +1, 아래 화살표 그대로		
		
		sel[downArrow] = arr[upArrow];
		comb(upArrow+1,downArrow+1);
		comb(upArrow+1,downArrow);
	}
	public static void main(String[] args) {
		comb(0,0);
	}

}

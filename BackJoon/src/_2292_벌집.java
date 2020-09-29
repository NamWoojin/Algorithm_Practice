import java.util.Scanner;

public class _2292_벌집 {
	public static int execute(int N) {

		// 구현하세요.
		int start = 1;
		int addNum = 6;
		int count = 1;
		while (start < N) {
			++count;
			start += addNum;
			addNum += 6;
		}
		
		return count; // 리턴값을 수정하세요
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(execute(sc.nextInt())); // 3
	}

}

import java.util.Scanner;

public class _2164 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(in.readLine());
//		LinkedList<Integer> queue = new LinkedList<Integer>();
//		for(int i = 1;i<=N;++i)
//			queue.add(i);
//			
//		
//		while(queue.size() != 1) {
//			queue.poll();
//			queue.add(queue.poll());
//		}
//		System.out.println(queue.get(0));
//	}
	
	
	
	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(in.readLine());
//		int[] array = new int[N];
//		int idx = 0;
//		if(N %2 == 1) {
//			array[idx] = N;
//			++idx;
//		}
//		for(int i =2;i<=N;i+=2) {
//			array[idx] =i;
//			++idx;
//		}
//		
//		while(true) {
//			if(idx < 2)
//				break;
//			int num = array[1];
//			for(int i = 2;i<idx;++i) {
//				array[i-2] = array[i];
//			}
//			array[idx-1] = num;
//			--idx;
//		}
//		
//		System.out.println(array[1]);
//
//	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//1. N�� ���� ����� 2�� �������� ã�´�.
		//2. (N - �� ������) * 2 �� ��.
		
		int n = 1;
		while( n < N ) {
			n *= 2;
		}
		//���⼭ n�� N���� ū 2�� ������.
		n /= 2; // ���� ������
		if(N == 1)
			System.out.println(1);
		else
			System.out.println( ( N - n ) * 2 );
		
	}
}

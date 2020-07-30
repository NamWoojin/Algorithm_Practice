import java.util.Scanner;

public class _1926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int  i = 1; i<=N;++i) {
			int num = 0;
			int number = i;
			while(number>=1) {
				
				if((number%10)%3 == 0) {
					if(number%10 != 0)
						++num;
				}
				number /= 10;
			}
			switch(num) {
			case 0:
				System.out.print(i);
				break;
			case 1:
				System.out.print("-");
				break;
			case 2:
				System.out.print("--");
				break;
			case 3:
				System.out.println("---");
				break;
			}
			System.out.print(" ");
		}
		
		sc.close();
	}

}

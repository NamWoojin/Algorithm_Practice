import java.util.Scanner;

public class hwjava02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[10];
		while(true) {
			int num = sc.nextInt();
			if(num == 0)
				break;
			else 
				++array[num/10];
		}
		
		for(int i = 0; i<array.length;++i) {
			if(array[i] != 0)
				System.out.println(i +" : "+ array[i]+"°³");
		}
		sc.close();
	}
	
}

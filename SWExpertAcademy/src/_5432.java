import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5432 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		char[] arr = new char[] {};

		for (int tc = 1; tc <= T; ++tc) {
			arr = in.readLine().toCharArray();
			int cutNum = 0;
			
			for (int i = 0; i < arr.length - 1; ++i) {
				if (arr[i] == '(' && arr[i + 1] == ')') {
					
					arr[i] = arr[i + 1] = '@';
				}
			}
			
			for (int i = 0; i < arr.length; ++i) {
				int pointerNum = 0;
				
				if (arr[i] == ')') {
					for (int j = i - 1; j >= 0; --j) {
						if (arr[j] == '@')
							++pointerNum;
						else if (arr[j] == '(') {
							arr[i] = arr[j] = '-';
							cutNum += pointerNum/2 + 1;
							break;
						}
					}
				}
			}

			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(cutNum);
		}

	}

}
/*
2
()(((()())(())()))(())
(((()(()()))(())()))(()())
*/
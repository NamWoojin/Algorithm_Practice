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
			boolean[] pointers = new boolean[arr.length];
			for (int i = 0; i < arr.length - 1; ++i) {
				if (arr[i] == '(' && arr[i + 1] == ')') {
					pointers[i] = true;
					arr[i] = arr[i + 1] = '-';
				}
			}

			boolean endFlag = false;
			while (!endFlag) {
				
				for (int i = 0; i < arr.length; ++i) {
					if (pointers[i] && i != 0) {
						int num = i - 1;
						while (arr[num] != '(') {
							--num;
							if (num == 0)
								break;
						}
						for (int k = i+2; k < arr.length; ++k) {
							if (arr[k] == '(')
								break;
							else if (arr[k] == ')') {
								int pointerNum = 0;
								for (int r = num; r < k; ++r) {
									if (pointers[r])
										++pointerNum;

								}
								cutNum += pointerNum + 1;
								arr[num] = arr[k] = '-';
								i = k;
								break;
							}
						}
					}
				}

				boolean end = true;
				for (int i = 0; i < arr.length; ++i) {
					if (arr[i] != '-') {
						end = false;
						break;
					}
				}
				if (end)
					endFlag = true;
			}

			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(cutNum);
		}

	}

}

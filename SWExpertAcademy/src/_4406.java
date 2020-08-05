import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class _4406 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			ArrayList<Character> arr = new ArrayList<>();
			char[] array = in.readLine().toCharArray();
			for (int i = 0; i < array.length; ++i) {
				if (!(array[i] == 'a' || array[i] == 'e' || array[i] == 'i' || array[i] == 'o' || array[i] == 'u') ){
					arr.add(array[i]);
				}
			}
			
			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			for(int i= 0;i<arr.size();++i)
				System.out.print(arr.get(i));
			System.out.println();

		}

	}
}


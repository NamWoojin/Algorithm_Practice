import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1208 {
	static int[] array = new int[100];

	public static void minMax(int count) {
		if (count == 0)
			return;

		int max = 0;
		int min = 100;
		int maxindex = 0;
		int minindex = 0;
		for (int l = 0; l < array.length; ++l) {
			if (array[l] > max) {
				max = array[l];
				maxindex = l;
			}
			if (array[l] < min) {
				min = array[l];
				minindex = l;
			}
		}
		--array[maxindex];
		++array[minindex];
		
		if(array[maxindex]-array[minindex] == 1 ||array[maxindex]-array[minindex] == 0)	//평탄화 완료 여부 확인
			count = 1;
		
		minMax(--count);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; ++tc) {
			int D = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int i = 0;
			for (i = 0; st.hasMoreTokens(); ++i) {
				array[i] = Integer.parseInt(st.nextToken());
			}

			minMax(D);

			int max = 0;
			int min = 100;
			for (int l = 0; l < array.length; ++l) {

				if (array[l] > max)
					max = array[l];

				if (array[l] < min)
					min = array[l];

			}

			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(max - min);
		}
	}
}

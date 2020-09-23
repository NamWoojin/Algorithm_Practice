import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2477_참외밭 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] square = new int[4];
		for (int i = 0; i < 6; ++i) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int dir = Integer.parseInt(st.nextToken()) - 1;
			int size = Integer.parseInt(st.nextToken());
			if(square[dir] == 0)
				square[dir] = size;

		}

		int big = (square[0] > square[1] ? square[0] : square[1]) * (square[2] > square[3] ? square[2] : square[3]);
		int small = (square[0] < square[1] ? square[0] : square[1]) * (square[2] < square[3] ? square[2] : square[3]);

		System.out.println((big - small) * N);

	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2477_참외밭 {
	static class line {
		int dir;
		int size;

		line(int dir, int size) {
			this.dir = dir;
			this.size = size;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		line[] square = new line[9];
		for (int i = 0; i < 6; ++i) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int dir = Integer.parseInt(st.nextToken()) - 1;
			int size = Integer.parseInt(st.nextToken());
			square[i] = new line(dir, size);
		}
		for (int i = 0; i < 3; ++i) {
			square[i + 6] = square[i];
		}
		int big = Math.max(Math.max(square[0].size, square[2].size), square[4].size)
				* Math.max(Math.max(square[1].size, square[3].size), square[5].size);
		int small = 0;
		for (int i = 0; i < 6; ++i) {
			if (square[i].dir == square[i + 2].dir && square[i + 1].dir == square[i + 3].dir) {
				small = square[i + 1].size * square[i + 2].size;
				break;
			}
		}
		System.out.println((big - small) * N);

	}
}

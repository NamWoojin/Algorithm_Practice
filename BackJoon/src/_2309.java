import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _2309 {
	static int[] heights = new int[9];
	static int[] choice = new int[7];
	static boolean flag = false;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; ++i) {
			heights[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(heights);
		calculate(0,0,0);
	}

	private static void calculate(int idx, int s_idx, int sum) throws IOException {
		if(flag)
			return;
		if (s_idx == 7) {
			if (sum == 100) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < s_idx; ++i) {
					sb.append(choice[i]);
					sb.append("\n");
				}
				bw.write(sb.toString());
				bw.flush();
				bw.close();
				flag = true;
				return;
			} else
				return;

		}
		else if (idx == 9 || idx - s_idx > 2)
			return;

		choice[s_idx] = heights[idx];
		calculate(idx + 1, s_idx + 1, sum + choice[s_idx]);
		calculate(idx + 1, s_idx, sum);

	}

}

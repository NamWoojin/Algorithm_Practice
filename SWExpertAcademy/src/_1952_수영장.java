import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1952_수영장 {
	static int oD, oM, tM, oY, min;
	static int usePlan[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			oD = Integer.parseInt(st.nextToken());
			oM = Integer.parseInt(st.nextToken());
			tM = Integer.parseInt(st.nextToken());
			oY = Integer.parseInt(st.nextToken());

			usePlan = new int[12];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 12; ++i) {
				usePlan[i] = Integer.parseInt(st.nextToken());
			}

			min = oY;

			threeMonth(0, 0);
			oneMonth(0, 0);
			oneDay(0, 0);
			
			System.out.println("#"+tc+" "+min);
		}
	}

	private static void threeMonth(int month, int pay) {
		if (month >= 12) {
			min = Math.min(pay, min);
			return;
		}

		if (usePlan[month] != 0) {
			threeMonth(month + 3, pay + tM);
			oneMonth(month + 3, pay + tM);
			oneDay(month + 3, pay + tM);
		} else {
			threeMonth(month + 1, pay);
		}
	}

	private static void oneMonth(int month, int pay) {
		if (month >= 12) {
			min = Math.min(pay, min);
			return;
		}
		
		if (usePlan[month] != 0) {
			threeMonth(month + 1, pay + oM);
			oneMonth(month + 1, pay + oM);
			oneDay(month + 1, pay + oM);
		} else {
			oneMonth(month + 1, pay);
		}
	}

	private static void oneDay(int month, int pay) {
		if (month >= 12) {
			min = Math.min(pay, min);
			return;
		}
		
		if (usePlan[month] != 0) {
			threeMonth(month + 1, pay + oD*usePlan[month]);
			oneMonth(month + 1, pay + oD*usePlan[month]);
			oneDay(month + 1, pay + oD*usePlan[month]);
		} else {
			oneDay(month + 1, pay);
		}
	}

}

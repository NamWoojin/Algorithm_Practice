import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//회의실 배정
public class _1931 {
	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;

		@Override
		public int compareTo(Meeting o) {
			if (this.end != o.end)
				return this.end - o.end;
			else
				return this.start - o.start;

		}

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Meeting[] meetings = new Meeting[N];
		StringTokenizer st;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(meetings);
		int count = 0;
		int time = 0;
		for (int i = 0; i < N; ++i) {
			if (meetings[i].start >= time) {
				++count;
				time = meetings[i].end;
			}
		}
		System.out.println(count);
	}
}

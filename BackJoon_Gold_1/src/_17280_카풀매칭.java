import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17280_카풀매칭 {

	static class driver implements Comparable<driver> {
		int min;
		int max;
		ArrayList<Integer> passengers;

		driver(int min, int max) {
			this.min = min;
			this.max = max;
		}

		@Override
		public int compareTo(driver o) {
			// TODO Auto-generated method stub
			return this.passengers.size() - o.passengers.size();
		}

	}

	static boolean[] passengerCheck;
	static driver[] drivers;
	static int[] passengers;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			passengers = new int[N];
			drivers = new driver[M];
			passengerCheck = new boolean[N];

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; ++i)
				passengers[i] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(in.readLine());
				drivers[i] = new driver(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				drivers[i].passengers = new ArrayList<>();
			}


			for (int i = 0; i < M; ++i) {	//운전자별로 태울 수 있는 승객의 수 계산
				for (int j = 0; j < N; ++j) {
					if (passengers[j] >= drivers[i].min && passengers[j] <= drivers[i].max) {
						drivers[i].passengers.add(j);
					}
				}
			}
			
			Arrays.sort(drivers);	//태울 수 있는 승객 수 적은 운전자 순서대로 정렬
			
			int i =0;
			while(i< M && drivers[i++].passengers.size() == 0) {}
			if(i == M)
				System.out.println(0);
			else
				System.out.println(matchPassenger(--i));
		}

	}

	public static int matchPassenger(int idx) {
		if (idx == M) {
			return 0;
		}
		int max = 0;
		boolean can = false;
		for (int i = 0; i < drivers[idx].passengers.size(); ++i) {
			if (!passengerCheck[drivers[idx].passengers.get(i)]) {
				can = true;
				passengerCheck[drivers[idx].passengers.get(i)] = true;
				max = Math.max(matchPassenger(idx + 1) + 1, max);
				
			}
		}
		
		if(!can && idx < M) max=matchPassenger(idx+1);	//태울 수 있는 승객 없으면
		
		return max;
	}
}

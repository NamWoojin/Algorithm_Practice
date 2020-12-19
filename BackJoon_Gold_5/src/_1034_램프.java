import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class _1034_램프 {
	static int N, M, K, max = 0;
	static HashMap<String, Integer> lamps;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		lamps = new HashMap<>();
		for (int i = 0; i < N; ++i) {	//(같은 행 배치, 개수) 해시맵에 저장
			String str = in.readLine();
			int count = lamps.containsKey(str) ? lamps.get(str) + 1 : 1;
			lamps.put(str, count);

		}
		K = Integer.parseInt(in.readLine());

		Iterator<String> iter = lamps.keySet().iterator();
		while (iter.hasNext()) {
			String str = iter.next();		//행 배치
			int zeros = countZeros(str);	//행의 0의 개수
			if (zeros <= K && (K - zeros) % 2 == 0) {	//행의 0의 개수가 K개 이하이면서, 0의 개수 - K 가 짝수라면
				max = Math.max(max, lamps.get(str));	//전부 불을 킬 수 있는 최대 행의 개수
			}
		}

		System.out.println(max);
	}

	static int countZeros(String lamp) {	//0의 개수 세기
		int count = 0;
		char[] arr = lamp.toCharArray();
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] == '0')
				++count;
		}
		return count;
	}


}

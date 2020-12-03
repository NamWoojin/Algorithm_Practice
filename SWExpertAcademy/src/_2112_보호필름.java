import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2112_보호필름 {
	
	
	static int D, W, K;
	static boolean[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			arr = new boolean[D][W];

			for (int i = 0; i < D; ++i) {	//입력받기
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; ++j) {
					arr[i][j] = st.nextToken().equals("1") ? true : false;
				}
			}
			int result = 0;
			for(int num = 0; num < D;++num) {	//약품 사용할 개수 정하기
				result = change(0,0,num);
				if(result != -1)
					break;
			}
			
			
			System.out.println("#"+tc+" "+result);
		}
	}

	private static int change(int idx, int count,int k) {
		if (count == k) {
			if (findEqual()) {
				return count;
			}
			return -1;
		}
		
		if (idx == D) {
			return -1;
		}

		int result = -1;
		
		result = change(idx + 1, count,k);	//약품 사용 x
		if (result == -1) {
			boolean[] temp = arr[idx].clone();
			Arrays.fill(arr[idx], true);
			result = change(idx + 1, count + 1,k);	//약품 사용 (true)
			if (result == -1) {
				Arrays.fill(arr[idx], false);
				result = change(idx + 1, count + 1,k);	//약품 사용(false)
			}
			arr[idx] = temp;	//원상복구
		}
		return result;

	}

	private static boolean findEqual() {	//동일 특성 K개인지 검사
		next: for (int j = 0; j < W; ++j) {
			int count = 1;
			for (int i = 0; i < D - 1; ++i) {
				if (arr[i][j] == arr[i + 1][j]) {
					++count;
				} else {
					count = 1;
				}

				if (count == K)
					continue next;
			}
			return false;
		}
		return true;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 이분탐색 문제
 */

public class _1920_수찾기 {
	static int N;
	static int numArray[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		numArray = new int[N];
		for (int i = 0; i < N; ++i) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArray);	//배열 정렬
		
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; ++i) {
			int num = Integer.parseInt(st.nextToken());
			sb.append((BinarySearch(0,N-1,num)?"1":"0") + "\n");
		}
		System.out.println(sb.toString());
	}
	
	//이분탐색
	static boolean BinarySearch(int startIdx, int endIdx, int num) {
		if(startIdx > endIdx) {	//배열 안에서 같은 수를 못찾았을 때
			return false;
		}
		
		int mid = (startIdx + endIdx) /2;
		boolean result = false;
		if(numArray[mid] < num) {	//중간값이 num보다 크면
			result = BinarySearch(mid+1,endIdx,num);
		}else if(numArray[mid] > num) {	//중간값이 num보다 작으면
			result = BinarySearch(startIdx,mid-1,num);
		}else {	//num과 중간 값이 같으면
			result = true;
		}
		
		return result;
		
	}
}

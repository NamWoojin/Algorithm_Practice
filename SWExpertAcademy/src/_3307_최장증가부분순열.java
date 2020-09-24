import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3307_최장증가부분순열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			int N =Integer.parseInt(in.readLine());
			int[] arr = new int[N];
			int[] LIS = new int[N];	//자신을 끝으로 하는 LIS 최장길이
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i] =Integer.parseInt(st.nextToken());
			}
			
			int max =0;
			for(int i =0; i<N;++i) {
				LIS[i] = 1;	//자신만으로 LIS구성했을 때의 길이 1
				for (int  j= 0; j < i; ++j) {
					//앞쪽 원소보다 자신이 큰 경우
					if(arr[j]<arr[i] && LIS[i] < LIS[j]+1) {
						LIS[i] = LIS[j]+1;
					}
				}
				max = Math.max(max,LIS[i]);
			}
			
			//소팅한 후 최대값 출력(배열의 순서가 상관 없을 때)
			//반복을 통한 최대값 찾은 후 출력
			//처리과정에서 max찾기
			System.out.println("#"+tc+" "+max);
			
		}
	}
}

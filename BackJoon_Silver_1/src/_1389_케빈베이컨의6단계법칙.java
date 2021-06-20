import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1389_케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] friends = new int[N + 1][N + 1];
	
		for (int i = 0; i <= N; ++i) {
			Arrays.fill(friends[i], 99999999);	//초기값 설정
			friends[i][i] = 0;					//자신-자신은 0으로 설정
		}

		for (int i = 0; i < M; ++i) {	//간선 정보 입력
			st = new StringTokenizer(in.readLine());
			int person1 = Integer.parseInt(st.nextToken());
			int person2 = Integer.parseInt(st.nextToken());
			friends[person1][person2] = 1;
			friends[person2][person1] = 1;
		}

		//Floyd Warshall
		for (int k = 1; k <= N; ++k) {
			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
				}
			}
		}

		//최소값 구하기
		int min = Integer.MAX_VALUE;
		int person = 0;
		for(int i = 1; i<=N;++i) {
			int sum = 0;
			for(int j = 1; j<=N;++j) {
				sum += friends[i][j];
			}
			if(min > sum) {
				person = i;
				min = sum;
			}
		}
		
		System.out.println(person);
	}

}

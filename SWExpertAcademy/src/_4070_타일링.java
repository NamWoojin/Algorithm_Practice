import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Dy[N] = 2 x N 직사각형을 채우는 경우의 수
 * Dy[0] = ?
 * Dy[1] = 1
 * Dy[2] = 3
 * => 공통점이 있는 것끼리 묶기!
 * 
 * 이 문제에서는 가장 마지막에 어떤 형태로 채웠냐에 따라 나누기
 * 	1) 가로 2개로 끝나는 경우. 
 * 	2) 세로 1개로 끝나는 경우. 
 * 	3)큰 네모로 끝나는 경우.
 * => 각 그룹을 어떻게 빨리 계산하는지에 따라 달라짐
 * 
 * 1) 가로 2개, 큰 네모로 끝나는 경우 => 이전이전 단계의 값 = Dy[N-2] * 2
 * 2) 세로 한개로 끝나는 경우 => 이전 단계의 값 = Dy[N-1]
 * 
 * 이 때 변수의 크기가 커져 long long으로도 부족.
 * 
 * Big Integer 구현하기.
 * => 숫자 하나를 배열로 옮겨서 표현하기
 * 
 */
public class _4070_타일링 {
	static int[] Dy;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(in.readLine());
			
		}
	}
	
	private static int solve(int i) {
		
		return Dy[i-1] + Dy[i-2]*2;
	}
}

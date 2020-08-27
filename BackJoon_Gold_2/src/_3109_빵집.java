
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//가능한 많이 연결하려면 최대한 위쪽에 붙여서 연결한다. 
public class _3109_빵집 {
	static int[] dr = { -1, 0, 1 };
	static int R, C, count = 0;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		for (int i = 0; i < R; ++i) {
			map[i] = in.readLine().toCharArray();
		}

		for (int i = 0; i < R; ++i) // 모든 행의 위치에서 파이프 놓기 시작
			findLoad(i, 0);

		System.out.println(count);
	}

	public static boolean findLoad(int r, int c) {
		if (c == C-1) {
			map[r][c] = '-';
			++count;
			return true;
		}

		int nr, nc = c + 1;
		
		for (int i = 0; i < 3; ++i) {
			nr = r + dr[i];

			if (nr < 0 || nr >= R)
				continue;

			if (map[nr][nc] == '.') { 	// 벽X & 파이프가 놓여있지 않은 일반 땅
				map[nr][nc] = '-'; 		// 파이프 놓기
				if (findLoad(nr, nc)) {	//이 파이프 선택이 끝까지 도달했는지
					return true;		//성공했음 반환
				}
				//같은 곳에 방문하면 같은 시나리오를 다시 반복하게 됨. 이를 방지하기 위해 다시 원상태로 복구시키지 않음.
			}
		}
		return false;

	}

}

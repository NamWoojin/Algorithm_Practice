import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1767_프로세서연결하기 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static ArrayList<int[]> array;
	static int arr[][], N, max, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st;
			array = new ArrayList<int[]>();
			N = Integer.parseInt(in.readLine());
			arr = new int[N][N];
			max = 0;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
						array.add(new int[] { i, j });
					}
				}
			}
//			connect(0,0);
			go(0, arr, 0, 0);

			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(min);

		}
	}

	private static boolean isAvailable(int r, int c, int d,int[][] tempArr) {
		int nr = r, nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) // 끝까지 간 경우(전선을 놓을 수 있는 경우)
				break;

			if (tempArr[nr][nc] >= 1) // 해당 위치에 코어나 전선이 있는 경우
				return false;
		}
		return true;
	}

	static void go(int idx, int[][] tempArr, int cCnt, int count) {
		//현재까지 연결된 코어 수 + 앞으로 처리해야할 남은 코어수 : 기대할 수 있는 최대 코어 수
		if(cCnt+array.size()-idx < max)return;	//가지치기
		
		if (idx == array.size()) {
//			System.out.println(cCnt + " "+ count);
			if (cCnt > max) {
				max = cCnt;
				min = count;
			} else if (cCnt == max) {
				if(min > count)
					min = count;
			}
			
			return;
		}

		
		for (int i = 0; i < 4; ++i) {
			int r = array.get(idx)[0];
			int c = array.get(idx)[1];
			if (isAvailable(r, c, i,tempArr)) {
				int[][] tempTemp = new int[N][];
				for (int j = 0; j < N; ++j)
					tempTemp[j] = tempArr[j].clone();
				int cnt = 0;

				while (true) {
					r += dr[i];
					c += dc[i];
					if (r < 0 || r >= N || c < 0 || c >= N)
						break;
					
					tempTemp[r][c] = 2;
					++cnt;
				}
				go(idx + 1, tempTemp, cCnt + 1, cnt + count);
			}
		}
		go(idx + 1, tempArr, cCnt, count);

	}
}

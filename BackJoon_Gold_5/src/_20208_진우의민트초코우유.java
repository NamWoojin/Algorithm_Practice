import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20208_진우의민트초코우유 {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static Node home, mincho[];
	static int N, M, H, minchoNum = 0, max = 0, visited = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		mincho = new Node[10];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; ++j) {
				String str = st.nextToken();
				if (str.equals("2")) {
					mincho[minchoNum++] = new Node(i, j);
				} else if (str.equals("1")) {
					home = new Node(i, j);
				}
			}
		}
		dfs(home.r, home.c, M, 0, false);
		System.out.println(max);
	}

	static void dfs(int r, int c, int power, int count, boolean arriveHome) {
		if (arriveHome) { // 집에 도착했을 때
			max = Math.max(max, count);
			return;
		}

		for (int i = 0; i < minchoNum; ++i) {
			if ((visited & (1 << i)) > 0) // 이미 방문한 민초라면 건너뛰기
				continue;

			int distance = Math.abs(r - mincho[i].r) + Math.abs(c - mincho[i].c);
			if (distance > power) // 지금 체력으로 갈 수 없는 거리라면 건너뛰기
				continue;

			visited |= (1 << i); // 방문처리
			dfs(mincho[i].r, mincho[i].c, power - distance + H, count + 1, false);
			visited ^= (1 << i); // 방문처리 해제
		}

		int distHome = Math.abs(r - home.r) + Math.abs(c - home.c);
		if (distHome <= power && count > max) { // 현재 위치에서 집에 갈 수 있는 체력이 남았다면, 최댓값보다 count가 크다면
			dfs(home.r, home.c, power - distHome, count, true);
		}
	}
}

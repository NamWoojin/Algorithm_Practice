import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1247 {
	private static boolean[] visited;
	private static int[][] routes;
	private static int N;
	private static int[] company;
	private static int[] home;
	private static int min = 100000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			min = 100000;
			N = Integer.parseInt(in.readLine());
			routes = new int[N][2];
			company = new int[2];
			home = new int[2];
			visited = new boolean[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; ++i) {
				routes[i][0] = Integer.parseInt(st.nextToken());
				routes[i][1] = Integer.parseInt(st.nextToken());
			}
			
			findWay(0, 0, company[0], company[1]);
			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(min);
		}
	}

	private static void findWay(int idx, int length, int posX, int posY) {
		if (idx == N) {
			length += Math.abs(posX - home[0]) + Math.abs(posY - home[1]);
			if (min > length)
				min = length;
			return;
		}

		for (int i = 0; i < N; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				findWay(idx + 1, length + Math.abs(posX - routes[i][0]) + Math.abs(posY - routes[i][1]), routes[i][0],
						routes[i][1]);
				visited[i] = false;
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _17472_다리만들기2 {
	static int N, M;
	static int[][] map;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int[][]islands;
	static class Road implements Comparable<Road> {
		int startPoint;
		int endPoint;
		int length;

		Road(int startPoint, int endPoint, int length) {
			this.startPoint = startPoint;
			this.endPoint = endPoint;
			this.length = length;
		}

		@Override
		public int compareTo(Road o) {
			// TODO Auto-generated method stub
			if(this.length == o.length)
				return this.startPoint - o.startPoint;
			return this.length - o.length;
		}

	}

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					map[i][j] = 9;
			}
		}
		int count = separateIslands();
		// 입력받기, 섬 나누기 끝. count = 섬의 개수
		islands = new int[count][count];
		findRoad(count);

		System.out.println(choiceRoad(count));
	}

	private static int separateIslands() {
		int num = 1;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 9) {
					dfs(i,j,num);
					++num;
				}

			}
		}
		return num - 1;
	}
	static void dfs(int r, int c, int n) {
		map[r][c] = n;
		for(int d = 0; d<4;++d) {
			int nr = r+dr[d];
			int nc =c+dc[d];
			if(nr>=0 && nc>=0&& nr <N&& nc<M&& map[nr][nc] == 9)
				dfs(nr,nc,n);
		}
	}
	
	private static int choiceRoad(int count) {
		
		boolean[] visited = new boolean[count];
		visited[0] = true;
		int dist = 0;
		List<Integer> sel = new ArrayList<>();
		sel.add(0);
		while(sel.size() != count) {
			int min = 987654321;
			int minIdx = -1;
			for(int n : sel) {
				for( int i = 0; i < count; i++) {
					if(islands[n][i] != 0 && !visited[i] && islands[n][i] < min) {
						min = islands[n][i];
						minIdx = i;
					}
				}
			}
			if( minIdx == -1) {
				dist = -1;
				break;
			}
			dist += min;
			sel.add(minIdx);
			visited[minIdx] = true;
		}
		
		return dist;
	}

	private static void findRoad(int count) {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] > 0) {
					for (int k = 0; k < 4; ++k) {
						int rr = i + dr[k];
						int cc = j + dc[k];

						if (rr < 0 || cc < 0 || rr > N - 1 || cc > M - 1)
							continue;

						if (map[rr][cc] == 0) {
							makeRoad(i, j, k, map[i][j]-1);
						}
					}

				}
			}
		}
	}

	private static void makeRoad(int r, int c, int dir, int startIslandNum) {
		int rr = r;
		int cc = c;
		int length = 0;
		while (true) {
			rr += dr[dir];
			cc += dc[dir];

			if (rr < 0 || cc < 0 || rr > N - 1 || cc > M - 1)
				break;

			if (map[rr][cc] != 0) {
				if (length == 1)
					break;
				int endNum = map[rr][cc]-1;
				if( islands[startIslandNum][endNum] > 0 ) {
					islands[startIslandNum][endNum] = Math.min(islands[startIslandNum][endNum], length);
					islands[endNum][startIslandNum] = islands[startIslandNum][endNum];
				}
				else {
					islands[startIslandNum][endNum] = length;
					islands[endNum][startIslandNum] = length;
				}
//				pQueue.offer(new Road(startIslandNum, map[rr][cc], length));
				break;
			}
			++length;
		}
	}
}

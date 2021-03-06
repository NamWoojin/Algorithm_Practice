import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17142_연구소3 {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M, map[][], minTime = Integer.MAX_VALUE, zeros = 0;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static Node choice[];
	static ArrayList<Node> viruses = new ArrayList<>();
	static boolean canFill = false;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		choice = new Node[M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					++zeros;
				else if (map[i][j] == 2) {
					viruses.add(new Node(i, j));
				}
			}
		}
		Comb(0, 0);
		if (canFill)
			System.out.println(minTime);
		else
			System.out.println(-1);

	}

	static void Comb(int idx, int count) {
		if (count == M) {
			bfs();
			return;
		}

		if (idx == viruses.size()) {
			return;
		}

		choice[count] = viruses.get(idx);
		Comb(idx + 1, count + 1);
		Comb(idx + 1, count);
	}

	static void bfs() {
		int time = 0;
		int count = 0;
		boolean visited[][] = new boolean[N][N];
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < M; ++i) {
			Node n = choice[i];
			visited[n.r][n.c] = true;
			q.add(n);
		}
		boolean meetZero = false;
		boolean prevMeetVirus = false;	//이전 시간에 비활성바이러스를 활성화시켰는지
		while (!q.isEmpty()) {
			int size = q.size();
			if (time >= minTime) {
				return;
			}
			meetZero = false;
			while (--size >= 0) {
				Node n = q.poll();
				for (int i = 0; i < 4; ++i) {
					int rr = n.r + dr[i];
					int cc = n.c + dc[i];

					if (rr < 0 || cc < 0 || rr >= N || cc >= N) // 범위 밖에 나갈 경우
						continue;
					if (visited[rr][cc]) // 이미 방문한 곳일 경우
						continue;
					if (map[rr][cc] == 1) // 벽이 위치한 곳일 경우
						continue;

					visited[rr][cc] = true;
					q.add(new Node(rr, cc));
					if (map[rr][cc] == 0) {
						++count;
						meetZero = true;
					}
				}
			}
			
			if(prevMeetVirus) {	//이전에 활성화 시켰으면서
				if(meetZero) {	//이번에 0인 자리를 1로 바꾸었다면
					++time;		//1초 추가
				}
				prevMeetVirus = false;
			}
			if(meetZero) {
				++time;
			}else {	//0을 만나지 않은 경우 비활성 바이러스를 만난 것.
				prevMeetVirus = true;
			}
		}
		
		if (zeros == count) {
			canFill = true;
			minTime = Math.min(minTime, meetZero?time-1:time);	//마지막 바이러스는 퍼지지 않았으므로 1초 제외한다.
		}

	}

}

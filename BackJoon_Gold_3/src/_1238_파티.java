import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1238_파티 {
	static class Node {
		int end, time;

		Node(int end, int time) {
			this.end = end;
			this.time = time;
		}
	}

	static int max = 0, N, M, X,map[][],distance[],XtoStart[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()) - 1;
		map = new int[N][N];
		visited = new boolean[N];
		for(int i =0; i<N;++i) {
			Arrays.fill(map[i],Integer.MAX_VALUE);
			map[i][i] = 0;
		}
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken());
			map[s][e] = t;
		}
		

		XtoDistance();
		
		for (int i = 0; i < N; ++i) {
			int sum = XtoStart[i] + dijkstra(i);
			max = Math.max(sum, max);
		}
		System.out.println(max);
	}

	private static void XtoDistance() {
		XtoStart = new int[N];
		visited = new boolean[N];
		for(int i =0; i<N;++i) {
			XtoStart[i] = map[X][i];
		}
		visited[X] = true;
		for(int i = 0; i<N-1;++i) {
			int idx = 0;
			int min = Integer.MAX_VALUE;
			for(int j = 0; j<N;++j) {
				if(!visited[j]) {
					if(min > XtoStart[j]) {
						idx = j;
						min = XtoStart[j];
					}
				}
			}
			
			visited[idx] = true;
			
			for(int j = 0; j<N;++j) {
				if(!visited[j] && map[idx][j]+min>0&& XtoStart[j] > map[idx][j]+min) {
					XtoStart[j] = map[idx][j]+min;
				}
			}
		}
	}
	
	private static int dijkstra(int start) {
		distance = new int[N];
		visited = new boolean[N];
		for(int i =0; i<N;++i) {
			distance[i] = map[start][i];
		}
		visited[start] = true;
		
		for(int i = 0; i<N-1;++i) {
			int idx = 0;
			int min = Integer.MAX_VALUE;
			for(int j = 0; j<N;++j) {
				if(!visited[j]) {
					if(min > distance[j]) {
						idx = j;
						min = distance[j];
					}
				}
			}
			
			
			visited[idx] = true;
			if(idx == X) {
				return distance[idx];
			}
			for(int j = 0; j<N;++j) {
				if(!visited[j] && map[idx][j]+min>0&&distance[j] > map[idx][j]+min) {
					distance[j] = map[idx][j]+min;
				}
			}
		}
		return distance[X];
	}

	
}

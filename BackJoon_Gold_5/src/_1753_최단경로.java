import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1753_최단경로 {
	static class link {
		int end;
		int weight;

		link(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}

	// 정점이 2만개라 인접행렬 안됨
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(in.readLine()) - 1; // (정점-1)

		ArrayList<link>[] links = new ArrayList[V];
		for (int i = 0; i < V; ++i) // 객체 만들기
			links[i] = new ArrayList<>();

		for (int i = 0; i < E; ++i) { // 인접리스트 입력받기 (정점 -1)
			st = new StringTokenizer(in.readLine());
			links[Integer.parseInt(st.nextToken()) - 1]
					.add(new link(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
		}

		int[] array = new int[V];
		boolean[] visited = new boolean[V];
		Arrays.fill(array, Integer.MAX_VALUE);
		array[K] = 0;

		for (int i = 0; i < V; ++i) {
			int min = Integer.MAX_VALUE;
			int current = -1;

			for (int j = 0; j < V; ++j) {
				if (!visited[j] && min > array[j]) {
					min = array[j];
					current = j;
				}
			}

			if(current == -1)
				break;
			

			for (link l : links[current]) {
				if (!visited[l.end] && array[l.end] > array[current] + l.weight) {
					array[l.end] = array[current] + l.weight;
				}
			}
			visited[current] = true;

		}
		for(int i = 0; i<V;++i) {
			if (array[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(array[i]);
		}
		
	}
}

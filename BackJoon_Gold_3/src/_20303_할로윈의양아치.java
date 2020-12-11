import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class _20303_할로윈의양아치 {
	static class Group {
		int people;
		int candies;

		Group(int people, int candies) {
			this.people = people;
			this.candies = candies;
		}
	}

	static int N, M, K, candy[];
	static ArrayList<Group> groups = new ArrayList<>();
	static ArrayList<Integer> friends[];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		candy = new int[N];
		friends = new ArrayList[N];
		visited = new boolean[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; ++i) {
			candy[i] = Integer.parseInt(st.nextToken());
			friends[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			friends[a].add(b);
			friends[b].add(a);
		}

		makeGroup(); // 그룹만들기

//		int[][] backpack = new int[groups.size() + 1][K];
//
//		for (int i = 1; i < groups.size() + 1; ++i) {
//			Group g = groups.get(i - 1);
//			for (int j = 0; j < K; ++j) {
//				if (j >= g.people) { // 가능한 사람 수라면
//					int prev = Math.max(j - g.people, 0);
//					backpack[i][j] = Math.max(g.candies + backpack[i - 1][prev], backpack[i - 1][j]);
//				}else {
//					backpack[i][j] = backpack[i - 1][j];
//				}
//			}
//		}
//		System.out.println(backpack[groups.size()][K - 1]);
		
		int[] backpack = new int[K];
		for(int i = 0; i< groups.size();++i) {
			Group g = groups.get(i);
			for(int j = K-1; j>= g.people;--j) {
				backpack[j] = Math.max(g.candies + backpack[j-g.people], backpack[j]);
			}
		}
		System.out.println(backpack[K-1]);
	}

	static int people, candies;

	static void makeGroup() {
		for (int i = 0; i < N; ++i) {
			if (visited[i]) // 이미 그룹에 속한 아이라면
				continue;
			people = 1;
			candies = candy[i];
			visited[i] = true;
			findFriends(i);
			groups.add(new Group(people, candies));
		}
	}

	static void findFriends(int idx) {
		Iterator<Integer> iter = friends[idx].iterator();
		while (iter.hasNext()) {
			int num = iter.next();
			if (visited[num])
				continue;
			++people;
			candies += candy[num];
			visited[num] = true;
			findFriends(num);
		}
	}
}

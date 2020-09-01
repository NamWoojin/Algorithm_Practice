import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _1941_소문난칠공주 {
	static char[][] array;
	static int count = 0;

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		array = new char[5][5];
		for (int i = 0; i < 5; ++i) {
			String str = in.readLine();
			for (int j = 0; j < 5; ++j) {
				array[i][j] = str.charAt(j);
			}
		}
		
		count = 0;
		ArrayList<Node> arr = new ArrayList<>();
		Comb(0, arr);
		System.out.println(count);
	}

	private static void Comb(int pos, ArrayList<Node> arr) {
		

		if (arr.size() == 7) {

			int sCount = 0;
			for (int i = 0; i < arr.size(); ++i) {
				Node node = arr.get(i);

				if (array[node.r][node.c] == 'S')
					++sCount;
			}
			if (sCount >= 4) { // 7개 고른것 중 4개 이상 S이면
				princess(arr);
			}
			return;
		}
		
		if (pos == 25)
			return;

		Comb(pos + 1, arr); // 안고르고 넘어가기
		ArrayList<Node> temp = new ArrayList<>(arr);
		temp.add(new Node(pos / 5, pos % 5));
		Comb(pos + 1, temp); // 고르고 넘어가기

	}

	private static void princess(ArrayList<Node> arr) {
		
		// 인접했는지 판단
		Queue<Node> queue = new LinkedList<>();
		queue.offer(arr.get(0));
		boolean[] isVisited = new boolean[7];
		isVisited[0] = true;
		int cnt = 0;
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			++cnt;
			for (int i = 0; i < 4; ++i) {
				int rr = n.r + dr[i];
				int cc = n.c + dc[i];
				
				for(int j = 0; j<7;++j) {
					if(!isVisited[j] && arr.get(j).r == rr && arr.get(j).c == cc) {
						isVisited[j] = true;
						queue.offer(arr.get(j));
					}
				}
			}
		}
		if(cnt == 7) {
			
			++count;
		}

	}
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
	static class Node{
		int r,c;
		Node(int r,int c){
			this.r = r;
			this.c = c;
		}
	}
	private static void solution(int sizeOfMatrix, int[][] matrix) {
		// TODO: 이곳에 코드를 작성하세요.
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		boolean[][] visited = new boolean[sizeOfMatrix][sizeOfMatrix];
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < sizeOfMatrix; ++i) {
			for (int j = 0; j < sizeOfMatrix; ++j) {
				if (matrix[i][j] == 1 && !visited[i][j]) {
					Queue<Node> q = new LinkedList<>();
					q.offer(new Node(i,j));
					visited[i][j] = true;
					int cnt = 1;
					while(!q.isEmpty()) {
						Node n  =q.poll();
						for(int k = 0; k<4;++k) {
							int rr = n.r + dr[k];
							int cc = n.c + dc[k];
							if(rr<0|| cc<0||rr>=sizeOfMatrix || cc>= sizeOfMatrix)
								continue;
							if(visited[rr][cc] || matrix[rr][cc] == 0)
								continue;
							++cnt;
							q.offer(new Node(rr,cc));
							visited[rr][cc]  = true;
						}
					}
					array.add(cnt);
				}
			}
		}
		array.sort(null);
		System.out.println(array.size());
		for(int i = 0; i<array.size();++i) {
			System.out.print(array.get(i)+" ");
		}
	}

	private static class InputData {
		int sizeOfMatrix;
		int[][] matrix;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
			for (int i = 0; i < inputData.sizeOfMatrix; i++) {
				String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
				for (int j = 0; j < inputData.sizeOfMatrix; j++) {
					inputData.matrix[i][j] = Integer.parseInt(buf[j]);
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.sizeOfMatrix, inputData.matrix);
	}
}
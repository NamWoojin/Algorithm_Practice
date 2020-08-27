import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18809_Gaaaaaaaaaarden {
	static class Node {
		int r, c, placeNum;

		Node(int r, int c, int placeNum) {
			this.r = r;
			this.c = c;
			this.placeNum = placeNum;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<Node> canPlace;
	static int[][] garden;
	static int N, M, G, R;
	static int greenStart, redStart;
	static int[] array;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		garden = new int[N][M];
		canPlace = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; ++j) {
				garden[i][j] = Integer.parseInt(st.nextToken());
				if (garden[i][j] == 2)
					canPlace.add(new Node(i, j, 0));
			}
		}
		array = new int[canPlace.size()];

		choiceGreen(0, 0);
		System.out.println(max);
	}

	private static void choiceGreen(int idx, int c_idx) {
		if (c_idx == G) {
			choiceRed(0, 0);
			return;
		}
		if (idx == canPlace.size())
			return;

		choiceGreen(idx + 1, c_idx);
		array[idx] = 3;
		choiceGreen(idx + 1, c_idx + 1);
		array[idx] = 0;
	}

	private static void choiceRed(int idx, int c_idx) {
		if (c_idx == R) {
			spreadSeed();
			return;
		}
		if (idx == canPlace.size())
			return;

		choiceRed(idx + 1, c_idx);
		if (array[idx] == 0) {
			array[idx] = 4;
			choiceRed(idx + 1, c_idx + 1);
			array[idx] = 0;
		}

	}

	private static void spreadSeed() {
		int[][] tempGarden = new int[N][M];
		for (int i = 0; i < N; ++i) {
			tempGarden[i] = garden[i].clone();
		}

		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < array.length; ++i) {
			if (array[i] != 0) {
				queue.offer(new Node(canPlace.get(i).r, canPlace.get(i).c, array[i]));
				tempGarden[canPlace.get(i).r][canPlace.get(i).c] = array[i];
			}
		}
		
		

		int greenNum = 3;
		int redNum  = 4;
		int flowerNum = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			greenNum += 2;
			redNum += 2;
			
			while (--size >= 0) {
				Node n = queue.poll();
				
				if(tempGarden[n.r][n.c] == -1)
					continue;
				
				for (int i = 0; i < 4; ++i) {
					int rr = n.r + dr[i];
					int cc = n.c + dc[i];

					if (rr < 0 || cc < 0 || rr >= N || cc >= M)
						continue;
					
					if (tempGarden[rr][cc] == 0) {
						continue;
					} 
					else if (tempGarden[rr][cc] == 1 || tempGarden[rr][cc] == 2) {	//아무 씨앗도 없는 자리
						tempGarden[rr][cc] = n.placeNum+2;
						queue.offer(new Node(rr, cc, n.placeNum+2));	//greenNum이나 redNum이 들어감
					}
					else if ((tempGarden[rr][cc] == greenNum || tempGarden[rr][cc] == redNum)	//이번턴에 뿌린 배양액이면서 현재 node와 다른 배양액
							&& tempGarden[rr][cc] != n.placeNum+2) {
						tempGarden[rr][cc] = -1;
						++flowerNum;
					}
				}
			}
		}

		if (flowerNum > max) {
			max = flowerNum;
		}

	}

	// 초록땅 정하기
	// 빨간땅 정하기
	// 번져서 꽃개수 세기

}

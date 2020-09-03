import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1767_프로세서연결하기 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static ArrayList<Node> array;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			array = new ArrayList<>();
			StringTokenizer st;
			N = Integer.parseInt(in.readLine());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1 && i != 0 && i != N && j != 0 && j != N) {
						array.add(new Node(i, j));
					}
				}
			}
			
			count(0,arr,0,0);
			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			System.out.println(minLength);

		}
	}
	static int maxConnection = 0;
	static int minLength = Integer.MAX_VALUE;
	static void count(int idx, int[][] tempArr,int connection,int num) {
		if (idx == array.size()) {
			if(connection == maxConnection) {
				minLength = Math.min(num, minLength);
			}else if(connection > maxConnection) {
				maxConnection = connection;
				minLength = num;
			}
			return;
		}
		
		re: for (int i = 0; i < 4; ++i) {
			int[][] tempTemp = new int[N][N];
			for (int j = 0; j < N; ++j)
				tempTemp[j] = tempArr[j].clone();
			
			int count = 0;
			int r = array.get(idx).r;
			int c = array.get(idx).c;
			while (r > 0 && c > 0 && r < N-1 && c < N-1) {
				r += dr[i];
				c += dc[i];
				if (tempTemp[r][c] == 1 || tempTemp[r][c] == 2)
					continue re;

				tempTemp[r][c] = 2;
				++count;
				
			}
			count(idx + 1, tempTemp,connection + 1,num + count);
		}
		count(idx + 1, tempArr,connection,num);
		
	}
}

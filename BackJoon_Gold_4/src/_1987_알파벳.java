import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1987_알파벳 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] array;
	static boolean[][] isVisited;
	static int R,C;
	static class Node {
		int r=0, c=0, count=0;

		Node(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		array = new char[R][];
		isVisited = new boolean[R][C];
		for (int i = 0; i < R; ++i) {
			array[i] = in.readLine().toCharArray();
		}
		
		System.out.println(bt(0,0,(1<<array[0][0]-'A')));

	}

	
	public static int bt(int r, int c,int count) {
		int max = 0;
		for (int i = 0; i < 4; ++i) {
			int rr = r + dr[i];
			int cc = c + dc[i];
			
			if(rr<0||cc<0||rr>=R||cc>=C)
				continue;
			
			if((count&(1<<(array[rr][cc]-'A')))==0) {
				max = Math.max(bt(rr,cc,(count|(1<<(array[rr][cc]-'A')))),max);
			}
		}
		
		if(max == 0)
			return 1;
		else return max+1;
	}
	
}

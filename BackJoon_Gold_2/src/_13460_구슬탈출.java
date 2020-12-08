import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13460_구슬탈출 {
	static class Node{
		int r,c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static Node B,R,O;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for(int i = 0; i<N;++i) {
			map[i] = st.nextToken().toCharArray();
			for(int j = 0; j< M;++j) {
				switch(map[i][j]) {
				case 'B':
					B = new Node(i,j);
					break;
				case 'R':
					R = new Node(i,j);
					break;
				case 'O':
					O = new Node(i,j);
					break;
				}
			}
		}
		
//		solve(1);
	}
	
//	private static boolean solve(int moves) {
//		if(moves > 10) {
//			return false;
//		}
//	}
}

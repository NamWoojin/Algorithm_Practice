import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _10026_적록색약 {
	static class Node{
		int r, c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static char[][] map;
	static int N, canDistinguish = 0, cantDistinguish = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new char[N][];
		for(int i = 0;i < N;++i) {
			map[i] = in.readLine().toCharArray();
		}
		candistingGuish();
		cantdistingGuish();
		System.out.println(canDistinguish +" "+cantDistinguish);
	}
	
	static void candistingGuish() {
		boolean[][] isVisitedCan = new boolean[N][N];
		for(int i = 0; i<N;++i) {
			for(int j = 0 ; j<N;++j) {
				if(!isVisitedCan[i][j]) {
					Queue<Node> queue = new LinkedList<>();
					queue.add(new Node(i,j));
					isVisitedCan[i][j] = true;
					char color = map[i][j];
					while(!queue.isEmpty()) {
						Node n = queue.poll();
						
						for(int k = 0; k<4;++k) {
							int rr = n.r + dr[k];
							int cc = n.c + dc[k];
							
							if(rr<0 || cc<0||rr>=N || cc>= N)
								continue;
							if(isVisitedCan[rr][cc] || map[rr][cc] != color)
								continue;
							isVisitedCan[rr][cc] = true;
							queue.add(new Node(rr,cc));
						}
					}
					++canDistinguish;
				}
				
			}
		}
	}
	
	static void cantdistingGuish() {
		boolean[][] isVisitedCant = new boolean[N][N];
		for(int i = 0; i<N;++i) {
			for(int j = 0 ; j<N;++j) {
				
				if(!isVisitedCant[i][j]) {
					Queue<Node> queue = new LinkedList<>();
					queue.add(new Node(i,j));
					isVisitedCant[i][j] = true;
					char color = map[i][j];
					while(!queue.isEmpty()) {
						Node n = queue.poll();
						
						for(int k = 0; k<4;++k) {
							int rr = n.r + dr[k];
							int cc = n.c + dc[k];
							
							if(rr<0 || cc<0||rr>=N || cc>= N)
								continue;
							if(isVisitedCant[rr][cc])
								continue;
							if((color == 'B') == (map[rr][cc] == 'B')) {	//둘다 파랑이거나, 둘다 파랑이 아니거나
								isVisitedCant[rr][cc] = true;
								queue.add(new Node(rr,cc));
							}
						}
					}
					++cantDistinguish;
				}
			}
		}
	}
	
}

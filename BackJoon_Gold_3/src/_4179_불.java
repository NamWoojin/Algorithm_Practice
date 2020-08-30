import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4179_불 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static class Node{
		int r,c,count;
		Node(int r,int c,int count){
			this.r = r;
			this.c = c;
			this.count = count;
		}
		Node(){}
	}
	static class fire{
		int r,c;
		fire(int r,int c){
			this.r = r;
			this.c = c;
		}
		fire(){}
	}
	static char[][] array;
	static int R,C;
	public static void main(String[] args) throws IOException {
		BufferedReader in  =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine());
		R =Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		array = new char[R][C];
		Queue<Node> jQueue = new LinkedList<>();
		Queue<fire> fireQueue = new LinkedList<>();
		for(int i = 0; i<R;++i) {
			String str = in.readLine();
			for(int j = 0; j <C;++j) {
				array[i][j] = str.charAt(j);
				if(array[i][j] == 'J')
					jQueue.add(new Node(i,j,0));
				else if(array[i][j] == 'F')
					fireQueue.add(new fire(i,j));
			}
		}
		
		System.out.println(bfs(jQueue,fireQueue));
		
	}
	
	public static String bfs(Queue<Node> jQueue, Queue<fire> fireQueue) {
		
		while(!jQueue.isEmpty() || !fireQueue.isEmpty()) {
			int jsize = jQueue.size();
			int fsize = fireQueue.size();
			while(--fsize>=0) {
				fire n  = fireQueue.poll();
				
				for(int i =0; i<4;++i) {
					int rr = n.r + dr[i];
					int cc = n.c + dc[i];
					
					if(rr<0||cc<0||rr>=R||cc>=C)
						continue;
					
					if (array[rr][cc] != '#' && array[rr][cc] != 'F') {
						array[rr][cc] = 'F';
						fireQueue.add(new fire(rr,cc));
					}
				}
			}
			while(--jsize >= 0) {
				Node n  = jQueue.poll();
				
				if(n.r == 0||n.r==R-1 || n.c == 0|| n.c == C-1)
					return Integer.toString(n.count+1);
				
				for(int i =0; i<4;++i) {
					int rr = n.r + dr[i];
					int cc = n.c + dc[i];
					
					if(rr<0||cc<0||rr>=R||cc>=C)
						continue;
					if (array[rr][cc] == '.') {
						array[rr][cc] = 'J';
						jQueue.add(new Node(rr,cc,n.count+1));
					}
				}
			}
			
		}
		
		return "IMPOSSIBLE";
	}
}

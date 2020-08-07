import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class _1861 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N;
	static int[][] rooms;
	static int roomnum;
	static class Node {
		int r;
		int c;
		int posNum;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public Node(int r, int c, int posNum) {
			super();
			this.r = r;
			this.c = c;
			this.posNum = posNum;
		}

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;++tc) {
			N = Integer.parseInt(in.readLine());
			int roomNum = N*N;
			int maxCount =0;
			rooms = new int[N][N];
			
			for(int i = 0;i<N;++i) {	//입력받기
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j<N;++j) {
					rooms[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i = 0;i<N;++i) {
				for(int j = 0; j<N;++j) {
					
					if(rooms[i][j] != -1) {
						roomnum = rooms[i][j];
						int max = Counts(i,j);
						if(maxCount == max) {	//최대값 같을 경우
							roomNum = Math.min(roomnum, roomNum);
						}
						else if(maxCount<max) {
							maxCount = max;
							roomNum = roomnum;
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(roomNum).append(" ").append(maxCount);
			System.out.println(sb.toString());
			sb.setLength(0);
			
		}
	}
	
	
	
	private static int Counts(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(r,c,rooms[r][c]));
		rooms[r][c] = -1;
		int count=1;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int posNum = node.posNum;
			int rr, cc;
			for (int i = 0; i < 4; ++i) {
				rr = node.r + dr[i];
				cc = node.c + dc[i];
				if (rr < 0 || cc < 0 || rr >= N || cc >= N)
					continue;
				if(rooms[rr][cc] ==-1)
					continue;
				
				if (rooms[rr][cc] == posNum +1) {	//1만큼 큰 값이 있을 때
					queue.offer(new Node(rr, cc,rooms[rr][cc]));
					++count;
					rooms[rr][cc] = -1;
				}else if (rooms[rr][cc] == posNum -1) {	//1만큼 작은 값이 있을 때
					queue.offer(new Node(rr, cc,rooms[rr][cc]));
					++count;
					--roomnum;	//시작 위치 변경
					rooms[rr][cc] = -1;
				}
			}
		}
		return count;
	}
}

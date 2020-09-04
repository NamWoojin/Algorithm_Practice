import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _4796_의석이의우뚝선산 {
	static class Node implements Comparable<Node>{
		int pos;
		int num;
		Node(int pos,int num){
			this.pos = pos;
			this.num = num;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return o.num-this.num;
		}
		
	}
	
	
	static PriorityQueue<Node> pQueue = new PriorityQueue<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc =1;tc<=T;++tc) {
			pQueue = new PriorityQueue<>();
			int N = sc.nextInt();
			int[] array = new int[N];
			boolean[] visited = new boolean[N];
			for(int i =0; i<N;++i) {
				array[i] = sc.nextInt();
				pQueue.offer(new Node(i,array[i]));
			}
			int count = 0;
			while(!pQueue.isEmpty()) {
				Node n = pQueue.poll();
				if(n.pos == 0 || n.pos == N-1)
					continue;
				if(visited[n.pos])
					continue;
				
				if(array[n.pos-1]>array[n.pos] || array[n.pos+1] > array[n.pos])
					continue;
				
				visited[n.pos] = true;
				int back = n.pos-1;
				int front = n.pos;
				int backCount= 0;
				int frontCount =0;
				while(array[back] < array[front]) {
					visited[front] = true;
					++backCount;
					--back;
					--front;
					if(back<0)
						break;
				}
				
				back = n.pos;
				front = n.pos+1;
				while(array[back] > array[front]) {
					visited[back] = true;
					++frontCount;
					++back;
					++front;
					if(front>=N)
						break;
				}
				count += backCount * frontCount;
			}
			System.out.println("#"+tc+" "+count);
		}
		
		
		
	}
}



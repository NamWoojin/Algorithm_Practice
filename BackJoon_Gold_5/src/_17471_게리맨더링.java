import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17471_게리맨더링 {
	static class Case implements Comparable<Case>{
		boolean[] choice;
		int diff;
		
		Case(boolean[] choice,int diff){
			this.choice = choice;
			this.diff = diff;
		}
		
		void choiceCheck(int num) {
			choice[num] = true;
		}

		@Override
		public int compareTo(Case o) {
			// TODO Auto-generated method stub
			return this.diff - o.diff;
		} 
	}
	static int N;
	static PriorityQueue<Case> pQueue = new PriorityQueue<>();
	static int[] peoples;
	static ArrayList<Integer>[] nodes;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in  =new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(in.readLine());
		peoples = new int[N];
		nodes = new ArrayList[N];
		for(int i = 0; i<N;++i) {
			nodes[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i  = 0; i<N;++i) {
			peoples[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i<N;++i) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j  =0; j<n;++j) {
				nodes[i].add(Integer.parseInt(st.nextToken())-1);
			}
		}
		
		separate(0,0,0,new boolean[N]);
		int ans = -1;
		while(!pQueue.isEmpty()) {
			Case c = pQueue.poll();
			if(isConnection(c,true))
				if(isConnection(c,false)) {
					ans = c.diff;
					break;
				}
					
		}
		System.out.println(ans);
		
	}
	
	private static void separate(int idx,int aPeople, int bPeople,boolean[] choice) {
		if(idx == N) {
			pQueue.offer(new Case(choice,Math.abs(aPeople-bPeople)));
			return;
		}
		
		boolean[] tempChoice = choice.clone();
		tempChoice[idx] = true;
		separate(idx+1,aPeople+peoples[idx],bPeople,tempChoice);
		
		boolean[] tempChoice2 = choice.clone();
		tempChoice2[idx] = false;
		separate(idx+1,aPeople,bPeople+peoples[idx],tempChoice2);
	}
	
	private static boolean isConnection(Case c,boolean check) { 
		boolean[] visited = new boolean[N];
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i =0; i<N;++i) {
			if(c.choice[i]==check) {
				queue.offer(i);
				visited[i] = true;
				break;
			}
		}
		while(!queue.isEmpty()) {
			int n = queue.poll();
			for(int i = 0; i<nodes[n].size();++i) {
				int num = nodes[n].get(i);
				if(!visited[num] && c.choice[num] == check) {
					queue.offer(num);
					visited[num]  =true;
				}
			}
		}
		
		for(int i = 0; i<visited.length;++i) {
			if(c.choice[i] != (visited[i] == check))
				return false;
		}
		return true;
	}
}

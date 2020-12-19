import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class _1339_단어수학 {
	static class Node implements Comparable<Node>{
		char alpha;
		int num;
		
		Node(char alpha, int num){
			this.alpha = alpha;
			this.num = num;
		}
		
		@Override
		public int compareTo(Node o) {
			return o.num - this.num;
		}

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		HashMap<Character, Integer> map = new HashMap<>();
		char[][] strings = new char[N][];
		
		for (int i = 0; i < N; ++i) {	//각 알파벳의 자리값 계산 
			strings[i] = in.readLine().toCharArray();
			int pos = strings[i].length - 1;
			for (int j = 0; j < strings[i].length; ++j) {
				int num = map.containsKey(strings[i][j])?map.get(strings[i][j]):0;	//이미 저장된 값이면 저장된 것 가져오기, 아니면 0
				map.put(strings[i][j], num + (int)Math.pow(10, pos--));	//자릿수 값 더해서 해시맵에 넣기
			}
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Iterator<Character> iter = map.keySet().iterator();
		while(iter.hasNext()) {	//알파벳과 자리값 정보 가지는 Node를 우선순위 큐에 넣어서 정렬
			char alpha = iter.next();
			int num = map.get(alpha);
			pq.add(new Node(alpha,num));
		}
		
		int num = 9;
		while(!pq.isEmpty()) {	//자리값이 큰 알바벳부터 큰 수 할당
			Node n = pq.poll();
			map.put(n.alpha, num--);
		}
		
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {	//할당받은 수에 따른 계산하기
			for (int j = 0; j < strings[i].length; ++j) {
				sb.append(map.get(strings[i][j]));
			}
			sum += Integer.parseInt(sb.toString());
			sb.setLength(0);
		}
		
		System.out.println(sum);
		
		
	}
}

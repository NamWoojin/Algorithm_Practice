import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1238 {
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		for(int tc = 1;tc<=10;++tc) {
			adj = new ArrayList[101];
			visited = new boolean[101];
			for(int i =0; i<101;++i) {
				adj[i] = new ArrayList<>();
			}
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			int Length = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i<Length/2;++i) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if(!adj[from].contains(to))
					adj[from].add(to);
			}
			sb.append("#").append(tc).append(" ").append(bfs2(start));
			out.write(sb.toString());
			out.newLine();
			out.flush();
			sb.setLength(0);
		}
	}
	private static int bfs2(int current) {
		Queue<Integer>  queue = new LinkedList<Integer>();
		queue.offer(current);
		visited[current] = true;
		int size,max = 0;
		while(!queue.isEmpty()) {	//ť�� ���������
			max = 0;	//���� ������ �Ѿ�����Ƿ� �ִ� �ʱ�ȭ
			size = queue.size();
			while(--size>=0) {	//�� ��������
				current = queue.poll();
				if(current>max)	// �ִ� Ȯ��
					max = current;
				for(int i = 0; i< adj[current].size();++i) {
					int num =adj[current].get(i);
					
					if(!visited[num]) {
						visited[num] = true;
						//�湮 ���� true : ���ôٹ������� queue�� ����ϱ� ������ ���� level���� ���� ���ڸ� ����Ű�� ��찡 �߻�. �̸� �����ϱ� ���� ��� �� �湮���� ����.
						queue.offer(num);	//ť�� ����Ű��
					}
				}			
			}
		}	
		return max;
	}
	
}

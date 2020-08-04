import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _3289 {
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sf = new StringBuffer();
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int T =Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T;++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parents =new int[n];
			for(int i =0; i<n;++i) {
				parents[i] = i;
			}
			sf.append("#").append(tc).append(" ");
			for(int i =0;i<m;++i) {
				st = new StringTokenizer(in.readLine()," ");
				int num = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				if(num == 1){
					sf.append(Equal(a,b));
				}
				else {
					union(a,b);
				}
			}
			out.write(sf.toString());
			out.flush();
			out.newLine();
			sf.setLength(0);
		}
	}
	static int Equal(int a, int b) {
		if(a == b)
			return 1;
		if(find(a) == find(b))
			return 1;
		return 0;
	}
	static void union(int a, int b) {
		if(a != b) {
			int pa =find(a);
			int pb =find(b);
			if(pa != pb) {
				parents[pb] = pa;
			}
		}
	}
	static int find(int x) {
		if(parents[x]==x) {
			return x;
		}
		return find(parents[x]);
	}
	
}

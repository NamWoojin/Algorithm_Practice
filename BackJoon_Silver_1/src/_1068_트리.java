import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1068_트리 {
	static ArrayList<Integer>[] arr;
	static int deleteNum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		arr  = new ArrayList[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		ArrayList<Integer> roots = new ArrayList<>();
		for(int i = 0; i<N;++i) {
			arr[i] = new ArrayList<>();
		}
		for(int i = 0; i<N;++i) {
			int num = Integer.parseInt(st.nextToken());
			if(num == -1)
				roots.add(i);
			else {
				arr[num].add(i);
			}
		}
		deleteNum = Integer.parseInt(in.readLine());
		int sum = 0;
		for (int i = 0; i < roots.size(); i++) {
			if(roots.get(i)!= deleteNum)
				sum += dfs(roots.get(i));
		}
		System.out.println(sum);
	}
	private static int dfs(int num) {
		if(arr[num].size()==0|| (arr[num].size()==1 && arr[num].get(0)==deleteNum)) {
			return 1;
		}
		int returnNum = 0;
		for(int i =0; i<arr[num].size();++i) {
			if(arr[num].get(i) != deleteNum) {
				returnNum += dfs(arr[num].get(i));
			}
		}
		return returnNum;
	}
}

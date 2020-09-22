import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _2605_줄세우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i =1;i<=N;++i) {
			int num = Integer.parseInt(st.nextToken());
			arr.add(arr.size()-num,i);
		}
		for(int i = 0; i<arr.size();++i) {
			System.out.print(arr.get(i)+" ");
		}
	}
}

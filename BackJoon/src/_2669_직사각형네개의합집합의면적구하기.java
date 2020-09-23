import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] arr = new boolean[101][101];
		StringTokenizer st;
		int count = 0;
		for(int i =0; i<4;++i) {
			st = new StringTokenizer(in.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			for(int j =startX; j<endX;++j) {
				for(int k =startY;k<endY;++k) {
					if(arr[j][k])
						continue;
					arr[j][k] = true;
					++count;
				}
			}
		}
		System.out.println(count);
	}
}

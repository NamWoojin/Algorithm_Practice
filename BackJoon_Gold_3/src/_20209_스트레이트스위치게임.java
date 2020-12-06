import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 큐브 상태로 방문처리 했으면 더 빨랐을 듯?
 * 스트링 + 해시맵으로 방문처리
 */
public class _20209_스트레이트스위치게임 {
	static class Situation {
		int clicked[];
		int cubes[];
		int clickCount;

		Situation(int[] cubes, int clickCount) {
			this.clicked = new int[8];
			this.cubes = cubes;
			this.clickCount = clickCount;
		}
	}

	static int N, K,cubes[],switchCubes[][];
	static boolean did[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		did = new boolean[55555556];
		cubes = new int[N];
		for (int i = 0; i < N; ++i) {
			cubes[i] = Integer.parseInt(st.nextToken());
		}

		switchCubes = new int[K][];
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken());
			switchCubes[i] = new int[num];
			for(int j = 0; j<num;++j) {
				switchCubes[i][j] = Integer.parseInt(st.nextToken())-1;
			}
		}

		Queue<Situation> queue = new LinkedList<>();
		queue.offer(new Situation(cubes,0));
		int can = -1;
		
		while (!queue.isEmpty()) {
			Situation situ = queue.poll();
			if (canEqual(situ.cubes)) {
				can = situ.clickCount;
				break;
			}

			for (int i = 0; i < K; ++i) {
				
				
				int newClicked[] = situ.clicked.clone();
				++newClicked[i];
				
				if(newClicked[i] > 5)
					continue;
				
				int newClickedNum = 0;
				for(int k = 0; k<8;++k) {
					newClickedNum += (newClicked[k]*Math.pow(10, k));
				}
				
				
				if(did[newClickedNum])
					continue;
				
				
				int[] newCubes = situ.cubes.clone();
				for(int j = 0; j< switchCubes[i].length;++j) {
					int num = switchCubes[i][j];
					newCubes[num] = (newCubes[num]+ i+1)%5;
				}
				
				
				
				did[newClickedNum] = true;
				Situation s = new Situation(newCubes,situ.clickCount+1);
				s.clicked = newClicked;
				queue.offer(s);
			}

		}

		System.out.println(can);
	}

	static boolean canEqual(int cubes[]) { // 전부 동일한 숫자인지 확인

		for(int i = 1; i<N;++i) {
			if(cubes[i] != cubes[0])
				return false;
		}

		return true;
	}

}

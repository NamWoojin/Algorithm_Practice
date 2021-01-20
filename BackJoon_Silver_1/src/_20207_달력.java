import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _20207_달력 {
	static class calender implements Comparable<calender>{
		int S;
		int E;
		calender(int S, int E){
			this.S = S;
			this.E = E;
		}
		@Override
		public int compareTo(calender o) {
			// TODO Auto-generated method stub
			if(o.S == this.S) {
				return o.E - this.E;	//시작일이 같다면 끝나는 날이 큰 것부터
			}
			return this.S - o.S;		//시작이 작은 것부터
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<calender> pQueue = new PriorityQueue<>();
		StringTokenizer st;
		int maxColumnNum[] = new int[1001];		//각 행의 최대 열값 저장
		int maxRowNum[] = new int[367];			//각 열의 최대 행값 저장
		for(int i = 0; i<N;++i) {
			st = new StringTokenizer(in.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			pQueue.add(new calender(S,E));
		}
		int maxC = 0;
		while(!pQueue.isEmpty()) {
			calender cal = pQueue.poll();
			maxC = cal.E;
			for(int r = 1; r<=1000;++r) {	//일정을 위에서부터 채우면서
				if(maxColumnNum[r] < cal.S) {	//해당 행에 채워진 일정(최대 열값)보다 해당 일정의 시작 일자가 나중이라면
					for(int i = cal.S;i<=cal.E;++i) {
						maxRowNum[i] = Math.max(maxRowNum[i], r);	//각 열의 최대 행 값 정정
					}
					maxColumnNum[r] = cal.E;	//해당 행의 최대 열값을 추가한 일정의 종료일자로 변경
					break;
				}
			}
		}
		
		int answer = 0;
		for(int c = 1;c<=maxC;++c) {
			if(maxRowNum[c] != 0) {	//0이 아닌 부분(일정이 있는 부분)
				int R = maxRowNum[c];
				int startC = c;	//시작 열값
				while(maxRowNum[c] != 0) {
					R = Math.max(R, maxRowNum[c++]);	//해당 열 범위 안 최대 행 값 구하기
				}
				answer += R *(c - startC);	//사각형 범위 값 더하기
			}
		}
		System.out.println(answer);
		
	}
}

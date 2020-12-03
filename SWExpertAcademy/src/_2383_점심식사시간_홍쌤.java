import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2383_점심식사시간_홍쌤 {
	static class Person implements Comparable<Person>{ // 사람이 각 계단과의 거리정보를 가지고 있음
		int r, c;
		int[] dist;
		int sel;	//배정된 계단의 번호를 저장할 변수

		Person(int r, int c) {
			this.r = r;
			this.c = c;
			dist = new int[2]; // 계단은 항상 2개
		}

		@Override
		public int compareTo(Person o) {
			return this.dist[sel] - o.dist[o.sel];
		}
	}

	static class Stair {
		int r, c, height;

		Stair(int r, int c, int height) {
			this.r = r;
			this.c = c;
			this.height = height;
		}
	}

	static int N,ans;
	static Stair[] stairs;
	static Person[] people;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(in.readLine());
			stairs = new Stair[2];
			people = new Person[10];
			ans = Integer.MAX_VALUE;
			int pCnt = 0; // 지금까지 입력받은 사람의 수
			int sCnt = 0;
			StringTokenizer st;
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; ++j) {
					int n = Integer.parseInt(st.nextToken());
					if (n > 1) {
						stairs[sCnt++] = new Stair(i, j, n);
					} else if (n == 1) {
						people[pCnt++] = new Person(i, j);
					}
				}
			}

			for (int i = 0; i < pCnt; ++i) {	//사람과 계단 사이의 거리구하기
				for (int j = 0; j < sCnt; ++j) {
					//도착해서 기다리는 시간 1분도 더해서 계산하기
					people[i].dist[j] = Math.abs(people[i].r - stairs[j].r) +Math.abs(people[i].c - stairs[j].c)+1;
				}
			}
			
			powerSet(0,pCnt);
			System.out.println("#"+tc+" "+ans);

		}
	}
	
	private static void powerSet(int idx,int pCnt) {	//각 사람마다 계단을 배정
		if(idx == pCnt) {
			solve(pCnt);
			return;
		}
		
		people[idx].sel = 0;
		powerSet(idx+1,pCnt);
		people[idx].sel = 1;
		powerSet(idx+1,pCnt);
	}
	
	private static void solve(int pCnt) {
		int[][] stairTimeTable = new int[2][200];	//N의 최대 크기가 10 => 100크기 이므로 최대 거리가 200을 넘진 않겠지...
		PriorityQueue<Person>[] stairQueue = new PriorityQueue[2];
		stairQueue[0] = new PriorityQueue<>();
		stairQueue[1] = new PriorityQueue<>();
		for(int i = 0; i<pCnt;++i) {
			stairQueue[people[i].sel].add(people[i]);
		}
		
		int max = 0;
		//모든 계단에 대해서
		for(int i = 0;i<stairs.length;++i) {
			int to = 0;
			while(!stairQueue[i].isEmpty()) {
				Person p = stairQueue[i].poll();
				int from = p.dist[p.sel];	//선택된 계단까지 거리부터 계단을 내려가기 시작
				to = from + stairs[p.sel].height;	//도착부터, 내가 선택한 계단의 높이만큼 계단에 머무름
				for(int j = from; j< to;++j) {
					if(stairTimeTable[p.sel][j] == 3) {
						++to;
						continue;
					}
					
					++stairTimeTable[p.sel][j];
				}
			}
			max = Math.max(max, to);
		}
		
		ans = Math.min(max, ans);
	}
}

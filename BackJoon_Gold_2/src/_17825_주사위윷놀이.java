import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17825_주사위윷놀이 {
	static int[] dice = new int[10];
	static int maxScore = 0;
	static int[][] map = new int[42][2];
	static int[][] pos = new int[4][2];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(in.readLine());
		for(int i = 0; i<10;++i) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		for(int i =0; i<42;i += 2) {	//42 == goal
			map[i][0] = i+2;
		}
		map[13][1] = 16;
		map[16][1] = 19;
		map[19][1] = 25;
		map[25][1] = 30;
		map[30][1] = 35;
		map[35][1] = 40;
		map[40][1] = 42;
		map[22][1] = 24;
		map[24][1] = 25;
		map[28][1] = 27;
		map[27][1] = 26;
		map[26][1] = 25;
		Next(0,0);
		System.out.println(maxScore);
	}
	
	static void Next(int index, int sum) {
		if(index == 10) {
			maxScore = Math.max(sum, maxScore);
			return;
		}
		
		
		for(int i = 0; i<4;++i) {
			int diceNum = dice[index];
			if(pos[i][0] > 40) {	//이미 도착한 말이면 생략
				continue;
			}
			int[] tempPos = pos[i].clone();
			if(pos[i][0] == 10 && pos[i][1] == 0){	//파란화살표가 있는 위치에 멈추면
				pos[i][0] = 13;
				pos[i][1] = 1;
				--diceNum;
			}
			else if(pos[i][0] == 20 && pos[i][1] == 0){	//파란화살표가 있는 위치에 멈추면
				pos[i][0] = 22;
				pos[i][1] = 1;
				--diceNum;
			}
			else if(pos[i][0] == 30 && pos[i][1] == 0){	//파란화살표가 있는 위치에 멈추면
				pos[i][0] = 28;
				pos[i][1] = 1;
				--diceNum;
			}
			if(Move(i,diceNum)) {	//이동가능
				if(pos[i][0] > 40) {
					Next(index+1, sum);
				}
				else {
				Next(index+1, sum+pos[i][0]);
				}
			}
			pos[i] = tempPos;	//초기화
		}
		
	}
	
	static boolean Move(int idx, int num) {	//idx번째 말을 num번 움직여라
		if(num == 0) {
			if(pos[idx][0] == 40) {	//40번 칸에 있으면
				pos[idx][1] = 0;
			}
			for(int i = 0; i<4;++i) {
				if(i == idx)
					continue;
				if(pos[i][0] == pos[idx][0] && pos[i][1] == pos[idx][1])	//말이 겹치면
					return false;
			}
			
			return true;
		}
		
		pos[idx][0] = map[pos[idx][0]][pos[idx][1]];
		if(pos[idx][0] > 40) {	// 도착
			return true;
		}
		return Move(idx,num-1);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1824 혁진이의 프로그램 검증 문제보다 제한시간이 줄어든 문제.
 * 근데 1824코드 제출했는데 패스했다.
 */

public class _7258_혁진이의프로그램검증 {
	static class Node{
		int position;
		int dir;
		int memory;
		public Node(int position, int dir, int memory) {
			this.position = position;
			this.dir = dir;
			this.memory = memory;
		}
		
	}
	
	static int R, C;
	static char[][] code;
	static boolean[][][][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			code = new char[R][C];
			visited = new boolean[R][C][16][4];
			for (int i = 0; i < R; ++i) {
				code[i] = in.readLine().toCharArray();
			}
			System.out.println("#" + tc + " " + (loop(0,0,0)? "YES" : "NO"));

		}
	}

	
	
	private static boolean loop(int position, int memory,int dir) {
		if (visited[position / C][position % C][memory][dir]) {
			return false;
		}

		visited[position / C][position % C][memory][dir] = true;

		switch (code[position / C][position % C]) {
		case '<':
			dir = 2;
			break;
		case '>':
			dir = 0;
			break;
		case '^':
			dir = 3;
			break;
		case 'v':
			dir = 1;
			break;
		case '_':
			if(memory == 0) {
				dir = 0;
			}else {
				dir = 2;
			}
			break;
		case '|':
			if(memory == 0) {
				dir = 1;
			}else {
				dir = 3;
			}
			break;
		case '?':
			visited[position / C][position % C][memory][0] = true;
			visited[position / C][position % C][memory][1] = true;
			visited[position / C][position % C][memory][2] = true;
			visited[position / C][position % C][memory][3] = true;
			for(int i = 0; i<4;++i) {
				if(loop(goDir(position,i),memory,i))
					return true;
			}
			return false;
		case '.':
			break;
		case '@':
			return true;
		case '+':
			if (memory == 15)
				memory = -1;
			++memory;
			break;
		case '-':
			if (memory == 0)
				memory = 16;
			--memory;
			break;
		default:
			memory = code[position / C][position % C]-'0';
			break;
		}
		
		return loop(goDir(position,dir),memory,dir);

	}

	private static int goDir(int position, int dir) {
		switch (dir) {
		case 0:
			return goRight(position);
		case 1:
			return goDown(position);
		case 2:
			return goLeft(position);
		case 3:
			return goUp(position);
		}
		return -1;
	}

	private static int goLeft(int position) {
		if (position % C == 0) // 제일 왼쪽에 있는 경우
			position += (C - 1);
		else
			--position;
		return position;
	}

	private static int goRight(int position) {
		if (position % C == C - 1) // 제일 오른쪽에 있는 경우
			position -= (C - 1);
		else
			++position;
		return position;
	}

	private static int goUp(int position) {
		if (position / C == 0) // 제일 위에 있는 경우
			position += (R - 1) * C;
		else
			position -= C;
		return position;
	}

	private static int goDown(int position) {
		if (position / C == R - 1) // 제일 아래에 있는 경우
			position = position % C;
		else
			position += C;
		return position;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1.순서 정하기(1번 타자의 자리는 고정)
 * 2.순서에 따른 점수 계산
 */
public class _17281_야구 {
	static int order[], score[][], maxScore = 0, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		score = new int[N][9];
		order = new int[9];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 9; ++j)
				score[i][j] = Integer.parseInt(st.nextToken());
		}
		makeOrder(0, 1);
		System.out.println(maxScore);
	}

	private static void makeOrder(int part, int choosen) {
		if (part == 9) {
			countScore();
			return;
		}
		if (part == 3) {
			makeOrder(4, choosen);
		} else {
			for (int i = 1; i < 9; ++i) {
				if ((choosen & (1 << i)) == 0) {
					order[part] = i;
					makeOrder(part + 1, choosen | (1 << i));
				}
			}
		}
	}

	private static void countScore() {
		int outCount = 0;
		int orderNum = 0;
		int total = 0;
		int ground = 0;
		next: for (int i = 0; i < N; ++i) {
			while (true) {
				int num = score[i][order[(orderNum++) % 9]];
				if (num == 0) {
					++outCount;
					if (outCount == 3) {
						ground = 0;
						orderNum %= 9;
						outCount = 0;
						continue next;
					}
				} else {
					ground=(ground<<1)+1;
					ground=ground<<(num-1);
					for(int j = 3; ground > 7;++j) {
						if((ground&(1<<j))>0) {
							++total;
							ground = ground^(1<<j);
						}
					}
				}
			}
		}
		maxScore = Math.max(total, maxScore);
	}
}

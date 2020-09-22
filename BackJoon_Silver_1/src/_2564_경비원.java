import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2564_경비원 {
	static class Node {
		int dir, pos;

		Node(int dir, int pos) {
			this.dir = dir;
			this.pos = pos;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(in.readLine());
		Node nodes[] = new Node[N + 1];
		for (int i = 0; i < N + 1; ++i) {
			st = new StringTokenizer(in.readLine());
			nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int sum = 0;
		for (int i = 0; i < N; ++i) {
			if (nodes[i].dir < 3 == nodes[N].dir < 3) { // 동서 or 남북
				if (nodes[i].dir == nodes[N].dir) {
					sum += Math.abs(nodes[i].pos - nodes[N].pos);
				} else {
					int dis = nodes[i].pos + nodes[N].pos;
					if (nodes[i].dir < 3) {
						sum += R;
						sum += Math.min(dis, 2 * C - dis);
					} else {
						sum += C;
						sum += Math.min(dis, 2 * R - dis);
					}
				}

			} else {
				switch (nodes[N].dir) {
				case 1:
					if (nodes[i].dir == 3)
						sum += nodes[N].pos + nodes[i].pos;
					else
						sum += C - nodes[N].pos + nodes[i].pos;
					break;
				case 2:
					if (nodes[i].dir == 3)
						sum += nodes[N].pos + R - nodes[i].pos;
					else
						sum += C - nodes[N].pos + R - nodes[i].pos;
					break;
				case 3:
					if (nodes[i].dir == 1)
						sum += nodes[N].pos + nodes[i].pos;
					else
						sum += R - nodes[N].pos + nodes[i].pos;
					break;
				case 4:
					if (nodes[i].dir == 1)
						sum += nodes[N].pos + C - nodes[i].pos;
					else
						sum += R - nodes[N].pos + C - nodes[i].pos;
					break;
				}
			}
		}
		System.out.println(sum);
	}
}

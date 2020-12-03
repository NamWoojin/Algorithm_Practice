import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2383_점심식사시간 {
	static class Stair {
		int r, c, time;

		Stair(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class person implements Comparable<person> {
		int no;
		int distance;
		int inTime;

		person(int no, int distance) {
			this.no = no;
			this.distance = distance;
		}

		@Override
		public int compareTo(person o) {
			// TODO Auto-generated method stub
			return this.distance - o.distance;
		}
	}

	static int N, map[][], minTime;
	static Stair stairs[];
	static ArrayList<Node> arr;
	static PriorityQueue<person>[] starting;
	static Queue<person>[] waiting;
	static Queue<person>[] running;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			stairs = new Stair[2];
			arr = new ArrayList<>();
			minTime = Integer.MAX_VALUE;
			StringTokenizer st;
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 1) {
						if (stairs[0] == null) {
							stairs[0] = new Stair(i, j, map[i][j]);
						} else {
							if (stairs[0].time > map[i][j]) {
								stairs[1] = stairs[0];
								stairs[0] = new Stair(i, j, map[i][j]);
							} else {
								stairs[1] = new Stair(i, j, map[i][j]);
							}
						}
					} else if (map[i][j] == 1) {
						arr.add(new Node(i, j));
					}
				}
			}
			starting = new PriorityQueue[2];
			separate(0, new PriorityQueue<person>(), new PriorityQueue<person>());
			System.out.println("#" + tc + " " + minTime);

		}
	}

	private static void separate(int idx, PriorityQueue<person> qOne, PriorityQueue<person> qTwo) {
		if (idx == arr.size()) {
			starting[0] = qOne;
			starting[1] = qTwo;
			simulate();
			return;
		}
		
		Node n = arr.get(idx);
		PriorityQueue<person> qTemp = new PriorityQueue<>(qOne);
		qTemp.add(new person(idx, Math.abs(n.r - stairs[0].r) + Math.abs(n.c - stairs[0].c)));
		separate(idx + 1, qTemp, qTwo);
		qTemp = new PriorityQueue<>(qTwo);
		qTemp.add(new person(idx, Math.abs(n.r - stairs[1].r) + Math.abs(n.c - stairs[1].c)));
		separate(idx + 1, qOne, qTemp);
	}

	private static void simulate() {
		int[] position = new int[arr.size()];
		waiting = new LinkedList[2];
		running = new LinkedList[2];
		waiting[0] = new LinkedList<>();
		waiting[1] = new LinkedList<>();
		running[0] = new LinkedList<>();
		running[1] = new LinkedList<>();
		int time = 1;
		while (true) {
			for (int i = 0; i < 2; ++i) {
				while (!starting[i].isEmpty()) {
					if (starting[i].peek().distance <= time) {
						person p = starting[i].poll();
						p.inTime = time;
						waiting[i].offer(p);
						position[p.no] = 1;
					} else {
						break;
					}
				}

				while (!waiting[i].isEmpty()) {
					if (waiting[i].peek().inTime < time && running[i].size() < 3) {
						person p = waiting[i].poll();
						p.inTime = time;
						running[i].offer(p);
						position[p.no] = 2;
					} else {
						break;
					}
				}

				while (!running[i].isEmpty()) {
					if (time - running[i].peek().inTime >= stairs[i].time) {
						person p = running[i].poll();
						position[p.no] = 3;
					} else {
						break;
					}
				}
			}

			boolean out = true;
			for (int i = 0; i < arr.size(); ++i) {
				if (position[i] != 3) {
					out = false;
					break;
				}
			}
			if (out) {
				break;
			} else {
				++time;
			}
		}
		minTime = Math.min(time, minTime);
	}
}

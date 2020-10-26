//import java.util.Scanner;
//
//class Main {
//	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames,
//			int[] numOfMovesPerGame) {
//		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
//		boolean[] noRun = new boolean[numOfAllPlayers];
//		for (int i = 0; i < numOfQuickPlayers; ++i) {
//			noRun[namesOfQuickPlayers[i] - 'A'] = true;
//		}
//		char[] seats = new char[numOfAllPlayers - 1];
//		for (int i = 1; i < numOfAllPlayers; ++i) {
//			seats[i-1] = (char)(65+i);
//		}
//		int[] count = new int[numOfAllPlayers];
//		++count[0];
//		int pos = 0;
//		int run = 0;
//		for (int i = 0; i < numOfGames; ++i) {
//			int num = numOfMovesPerGame[i];
////			System.out.println(pos+" "+num);
//			pos = pos+num >= 0 ? (pos+num)% (numOfAllPlayers-1) : ((pos+num)+((numOfAllPlayers-1)*100))%(numOfAllPlayers-1);
//			if(noRun[seats[pos]-'A']) {	//빨리 달려서 잡히는 애
//				++count[run];
//			}else {
//				++count[seats[pos]-'A'];	//앉아있던 애 +1
//				int temp = seats[pos]-'A';
//				seats[pos] = (char)(65+run);
//				run = temp;
//			}
//		}
//		
//		for(int i =0; i<numOfAllPlayers-1;++i) {
//			System.out.println((seats[i])+" "+count[seats[i]-65]);
//		}
//		System.out.println((char)(run+65)+" "+count[run]);
//	}
//
//	private static class InputData {
//		int numOfAllPlayers;
//		int numOfQuickPlayers;
//		char[] namesOfQuickPlayers;
//		int numOfGames;
//		int[] numOfMovesPerGame;
//	}
//
//	private static InputData processStdin() {
//		InputData inputData = new InputData();
//
//		try (Scanner scanner = new Scanner(System.in)) {
//			inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
//
//			inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
//			inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
//			System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0,
//					inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);
//
//			inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
//			inputData.numOfMovesPerGame = new int[inputData.numOfGames];
//			String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
//			for (int i = 0; i < inputData.numOfGames; i++) {
//				inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
//			}
//		} catch (Exception e) {
//			throw e;
//		}
//
//		return inputData;
//	}
//
//	public static void main(String[] args) throws Exception {
//		InputData inputData = processStdin();
//
//		solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers,
//				inputData.numOfGames, inputData.numOfMovesPerGame);
//	}
//}

//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//class Main {
//	static class Node implements Comparable<Node>{
//		int pos;
//		int height;
//		Node(int pos, int height){
//			this.pos = pos;
//			this.height = height;
//		}
//		@Override
//		public int compareTo(Node o) {
//			return o.height - this.height;
//		}
//	}
//	private static void solution(int day, int width, int[][] blocks) {
//		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
//		int[] arr = new int[width];
//		int total = 0;
//		for(int i =0; i<day;++i) {
//			PriorityQueue<Node> q = new PriorityQueue<>();
//			for(int j = 0; j<width;++j) {
//				arr[j] += blocks[i][j];
//				q.offer(new Node(j,arr[j]));
//			}
//			Node n = q.poll();
//			Node leftMax = n;
//			Node rightMax = n;
//			while(!q.isEmpty()) {
//				Node nn = q.poll();
//				if(nn.pos < leftMax.pos) {
//					for(int p = nn.pos+1; p<leftMax.pos;++p) {
//						total += nn.height-arr[p];
//						arr[p] = nn.height;
//					}
//					leftMax = nn;
//				}else if(nn.pos > rightMax.pos) {
//					for(int p = rightMax.pos+1;p < nn.pos;++p) {
//						total += nn.height - arr[p];
//						arr[p] = nn.height;
//					}
//					rightMax = nn;
//				}
//			}
//		}
//		System.out.println(total);
//	}
//
//	private static class InputData {
//		int day;
//		int width;
//		int[][] blocks;
//	}
//
//	private static InputData processStdin() {
//		InputData inputData = new InputData();
//
//		try (Scanner scanner = new Scanner(System.in)) {
//			inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
//			inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
//
//			inputData.blocks = new int[inputData.day][inputData.width];
//			for (int i = 0; i < inputData.day; i++) {
//				String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
//				for (int j = 0; j < inputData.width; j++) {
//					inputData.blocks[i][j] = Integer.parseInt(buf[j]);
//				}
//			}
//		} catch (Exception e) {
//			throw e;
//		}
//
//		return inputData;
//	}
//
//	public static void main(String[] args) throws Exception {
//		InputData inputData = processStdin();
//
//		solution(inputData.day, inputData.width, inputData.blocks);
//	}
//}

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
class Main {
  private static void solution(int numOfOrder, String[] orderArr) {
    // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
	  for(int i = 0; i<numOfOrder;++i) {
		  char[] arr = orderArr[i].toCharArray();
		  Deque<Character> q = new ArrayDeque<>();
		  for(int j = 0; j<arr.length;++j) {
			  char now = arr[j];
			  if(now == ')') {
				  Deque<Character> s = new ArrayDeque<>();
				  while(true) {
					  char pol = q.pollLast();
					  if(pol == '(') {
						  break;
					  }
					  else if(pol >'0' && pol <='9') {
						  int loop = (pol-'0')-1;
						  char add = s.peekFirst();
						  while(--loop>=0) {
							  s.addFirst(add);
						  }
					  }
					  s.addFirst(pol);
				  }
				  char front = q.pollLast();
				  if(front >'0' && front <='9') {
					  int loop = front-'0';
					  for(int k =0; k<loop;++k) {
						  int size = s.size();
						  while(--size>=0) {
							  char c = s.pollFirst();
							  q.addLast(c);
							  s.addLast(c);
						  }
					  }
				  }else {
					  while(!s.isEmpty()) {
						  q.addLast(front);
						  q.addLast(s.pollFirst());
					  }
				  }
			  }
			  else if(now >'0' && now <='9' && arr[j+1] != '(') {
				  int loop = (now-'0');
				  char add = arr[++j];
				  while(--loop>=0) {
					  q.addLast(add);
				  }
			  }
			  else {
				  q.addLast(now);
			  }
		  }
		  StringBuilder sb = new StringBuilder();
		  while(!q.isEmpty()) {
			  sb.append(q.pollFirst());
		  }
		  System.out.println(sb.toString());
	  }
  }

  private static class InputData {
    int numOfOrder;
    String[] orderArr;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

      inputData.orderArr = new String[inputData.numOfOrder];
      for (int i = 0; i < inputData.numOfOrder; i++) {
        inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.numOfOrder, inputData.orderArr);
  }
}
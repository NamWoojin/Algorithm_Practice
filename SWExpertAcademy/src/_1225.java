import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1;tc<=10;++tc) {
			in.readLine();
			LinkedList<Integer> queue = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			for(int i = 1;i<=8;++i) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			out:while(true) {
				for(int i =1; i<=5;++i) {
					int num = queue.poll()-i;
					if(num <=0)
						break out;
					queue.offer(num);
				}
			}
			
			System.out.print("#");
			System.out.print(tc);
			System.out.print(" ");
			for(int i = 0; i<7;++i) {
				System.out.print(queue.poll());
				System.out.print(" ");
			}
			System.out.println(0);
		}
		
	}

}

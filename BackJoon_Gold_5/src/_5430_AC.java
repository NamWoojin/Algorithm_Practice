import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class _5430_AC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			char[] p = in.readLine().toCharArray();
			int n = Integer.parseInt(in.readLine());
			String str = in.readLine();
			Deque<Integer> deque = new LinkedList<>();
            for (String s : str.substring(1, str.length() - 1).split(","))
                if (!s.equals(""))
                    deque.add(Integer.valueOf(s));
			boolean front = true;
			boolean error = false;
			for (int i = 0; i < p.length; ++i) {
				if(p[i] == 'R') {
					front = !front;
				}else {
					if(deque.isEmpty()) {
						error = true;
						break;
					}
					if(front) {
						deque.removeFirst();
					}else {
						deque.removeLast();
					}
				}
			}
			
			if(error) {
				System.out.println("error");
			}else {
				StringBuilder sb = new StringBuilder("[");
		        while (!deque.isEmpty()) {
		            sb.append(front ? deque.removeFirst() : deque.removeLast());
		            if (deque.size() != 0)
		                sb.append(',');
		        }
		        sb.append(']');
		        System.out.println(sb);
			}
		}
	}
}

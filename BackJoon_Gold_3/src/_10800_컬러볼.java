import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class _10800_컬러볼 {
	static class Ball{
		int color;
		int size;
		Ball(int c,int s){
			this.color = c;
			this.size = s;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Ball[] balls = new Ball[N];
		HashMap<Integer,ArrayList<Integer>> map =new HashMap<>();
		for(int i =0; i<N;++i) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			balls[i] = new Ball(color,size);
			if(map.containsKey(color)) {
				map.get(color).add(size);
			}else {
				ArrayList<Integer> temp  =new ArrayList<>();
				temp.add(size);
				map.put(color, temp);
			}
		}
		
		
		Iterator<Integer> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			ArrayList<Integer> array = map.get(iter.next());
			Integer[] arr =array.toArray(new Integer[array.size()]);
		}
		
		for(int i = 0; i<N;++i) {
			Ball b = balls[i];
			Iterator<Integer> iterator = map.keySet().iterator();
			int sum = 0;
			while(iterator.hasNext()) {
				int color = iterator.next();
				if(b.color == color)
					continue;
				Iterator<Integer> it = map.get(color).iterator();
				while(it.hasNext()) {
					int size = it.next();
					if(size < b.size)
						sum += size;
					else
						break;
				}
			}
			System.out.println(sum);
		}
		
	}
}

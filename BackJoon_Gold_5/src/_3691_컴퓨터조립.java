import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _3691_컴퓨터조립 {
	static class part implements Comparable<part> {
		int price, quality;
		String type;

		part(String type, int price, int quality) {
			this.price = price;
			this.quality = quality;
			this.type = type;
		}

		@Override
		public int compareTo(part o) {
			if (this.quality == o.quality)
				return this.price - o.price;
			return this.quality - o.quality;
		}
	}

	static Map<String, ArrayList<part>> parts;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			PriorityQueue<part> choice = new PriorityQueue<part>();
			parts = new HashMap<>();
			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(in.readLine());
				String type = st.nextToken();
				st.nextToken();
				int price = Integer.parseInt(st.nextToken());
				int quality = Integer.parseInt(st.nextToken());
				if (parts.containsKey(type)) {
					parts.get(type).add(new part(type, price, quality));
				} else {
					ArrayList<part> p = new ArrayList<>();
					p.add(new part(type, price, quality));
					parts.put(type, p);
				}
			}

			Iterator<String> it = parts.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				Iterator<part> iter = parts.get(key).iterator();
				part p = new part("",Integer.MAX_VALUE,Integer.MAX_VALUE);
				while(iter.hasNext()) {
					part pp = iter.next();
					p = p.price<pp.price ? p : pp;
				}
				choice.offer(p);
				b -= p.price;
			}

			int minQuality = 0;
			while (true) {
				part p = choice.poll();
				minQuality = p.quality;
				b += p.price;
				Iterator<part> iter = parts.get(p.type).iterator();
				part next = new part("x",Integer.MAX_VALUE,Integer.MAX_VALUE);
				while (iter.hasNext()) {
					part pp = iter.next();
					if (pp.quality > p.quality && b >= pp.price) {
						next = pp.price < next.price ? pp: next;
					}
				}
				if(next.type.equals("x")) {
					break;
				}else {
					choice.offer(next);
					b -= next.price;
				}
			}

			System.out.println(minQuality);
		}
	
	}
}

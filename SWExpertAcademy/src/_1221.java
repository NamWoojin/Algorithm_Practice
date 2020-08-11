import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class _1221 {
	static Map<String,Integer> array  = new HashMap<String,Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		array.put("ZRO",0);
		array.put("ONE",1);
		array.put("TWO",2);
		array.put("THR",3);
		array.put("FOR",4);
		array.put("FIV",5);
		array.put("SIX",6);
		array.put("SVN",7);
		array.put("EGT",8);
		array.put("NIN",9);
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<= T;++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			st.nextToken();
			Integer.parseInt(st.nextToken());
			ArrayList<Integer> ints = new ArrayList<>();
			st = new StringTokenizer(in.readLine());
			while(st.hasMoreTokens()) {
				ints.add(array.get(st.nextToken()));
			}
			ints.sort(null);
			
			System.out.print("#");
			System.out.println(tc);
			Iterator<Integer> iter = ints.iterator();
			while(iter.hasNext()) {
				sb.append(getKey(iter.next())).append(" ");
			}
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
	public static String getKey(int value) {
		 
        for (String k : array.keySet()) {
            if (value == array.get(k)) {
                return k;
            }
        }
        return null;
    }

}

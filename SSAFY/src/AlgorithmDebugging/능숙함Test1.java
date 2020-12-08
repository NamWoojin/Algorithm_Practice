package AlgorithmDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class 능숙함Test1 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		char[] chars = str.toCharArray();
//		HashMap<Character,Integer> hash = new HashMap<>();
//		for(int i = 0;i<chars.length;++i) {
//			if(hash.containsKey(chars[i])) {
//				hash.put(chars[i],hash.get(chars[i])+1);
//			}else {
//				hash.put(chars[i],1);
//			}
//		}
//		int max = 0;
//		char maxChar = 'a';
//		Iterator<Character> iter = hash.keySet().iterator();
//		while(iter.hasNext()) {
//			char c = iter.next();
//			if(max < hash.get(c)) {
//				maxChar = c;
//				max =hash.get(c);
//			}
//		}
//		
//		System.out.println(max +" "+ maxChar);
		
		
		int[] arr = new int[200];
		int max = 0;
		char maxChar = 'a';
		for (int i = 0; i < chars.length; i++) {
			++arr[chars[i]];
			if(arr[chars[i]]>max) {
				maxChar = chars[i];
				max = arr[chars[i]];
			}
		}
		System.out.println(max + " "+ maxChar);
	}
}

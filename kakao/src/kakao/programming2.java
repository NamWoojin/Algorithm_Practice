package kakao;

import java.util.ArrayList;
import java.util.Arrays;

public class programming2 {
	static boolean[] menus = new boolean[26];
	static int[] bits;
	static int maxNum;
	static ArrayList<Integer> maxArray;
	public static void main(String[] args) {
		String[] orders = new String[3]; 
		int[] course = new int[3];
		
		
		
		String[] answer = {};
		ArrayList<String> answerArray = new ArrayList<>();
		bits = new int[orders.length];
		for(int i = 0; i<orders.length;++i) {
			String str = orders[i];
			for(int j = 0; j<str.length();++j) {
				int num = str.charAt(j)-'A';
				menus[num] = true;
				bits[i] = bits[i] |(1<<num);
			}
		}
		
		for (int i = 0; i < course.length; ++i) {
			maxNum = 0;
			maxArray = new ArrayList<>();
			choice(0,0,course[i],0);
			for(int j = 0; j<maxArray.size();++j) {
				int num = maxArray.get(i);
				String str=  "";
				for(int k = 0; k<26;++k) {
					if((num & (1<<k) )>0) {
						str+= (char)('A'+k);
					}
				}
				answerArray.add(str);
			}
		}
		
		answerArray.sort(null);
		answer = new String[answerArray.size()];
		for(int  i=0; i< answerArray.size();++i) {
			answer[i]= answerArray.get(i);
		}
		System.out.println(Arrays.deepToString(answer));
	}
	
	private static void choice(int idx,int c_idx,int count,int choices) {
		if(c_idx == count) {
			
			//사람 수 세기
			int total = 0;
			for(int i = 0; i<bits.length;++i) {
				int add= bits[i] & choices;
				int num = 0;
				for(int j = 0; j<26;++j) {
					if((add & (1<<j) )>0) {
						++num;
					}
				}
				if(num == count)
					++total;
			}
			
			if(total == maxNum) {
				maxArray.add(choices);
			}else if(total > maxNum) {
				maxArray = new ArrayList<>();
				maxArray.add(choices);
				maxNum = total;
			}
			return;
		}
		if(idx == 26) {
			return;
		}
		
		choice(idx+1,c_idx,count,choices);
		if(menus[idx]) {
			choices=choices|(1<<idx);
			choice(idx+1,c_idx+1,count,choices);
		}
		
	}
}

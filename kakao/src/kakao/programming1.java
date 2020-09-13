package kakao;

import java.util.ArrayList;
import java.util.Scanner;

public class programming1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String new_id = sc.next();
		String answer = "";
		new_id = new_id.toLowerCase();
		ArrayList<Character> array = new ArrayList<>();
		for (int i = 0; i < new_id.length(); ++i)
			array.add(new_id.charAt(i));
		for (int i = 0; i < array.size(); ++i) {
			char cha = array.get(i);
			if(cha >=97 && cha<=122)
				continue;
			if (cha >= 48 && cha <= 57)
				continue;
			if (cha == '.' || cha == '-' || cha == '_')
				continue;

			array.remove(i--);
		}

		for (int i = 0; i < array.size(); ++i) {
			if (array.get(i) == '.') {
				if (i < array.size() - 1 && array.get(i + 1) == '.')
					array.remove(i--);
			}
		}

		if (array.get(0) == '.')
			array.remove(0);
		
		
		if (array.size() > 0 && array.get(array.size() - 1) == '.')
			array.remove(array.size() - 1);

		if (array.size() == 0)
			array.add('a');

		int length = array.size() > 15 ? 15 : array.size();

		ArrayList<Character> arrayTwo = new ArrayList<>(array.subList(0, length));

		if (arrayTwo.size() > 0 && arrayTwo.get(arrayTwo.size() - 1) == '.')
			arrayTwo.remove(arrayTwo.size() - 1);
		
		if(length < 3) {
			char cha = arrayTwo.get(arrayTwo.size() -1);
			while(arrayTwo.size()<3) {
				arrayTwo.add(cha);
			}
		}
		for(int i = 0; i< arrayTwo.size();++i) {
			answer += arrayTwo.get(i);
		}
		System.out.println(answer);
	}
}

class Solution {
	public String solution(String new_id) {
		String answer = "";
		new_id = new_id.toLowerCase();
		ArrayList<Character> array = new ArrayList<>();
		for (int i = 0; i < new_id.length(); ++i)
			array.add(new_id.charAt(i));

		for (int i = 0; i < array.size(); ++i) {
			char cha = array.get(i);
			if (cha >= 48 && cha <= 57)
				continue;
			if (cha == '.' || cha == '-' || cha == '_')
				continue;

			array.remove(i);
		}

		for (int i = 0; i < array.size(); ++i) {
			if (array.get(i) == '.') {
				if (i < array.size() - 1 && array.get(i + 1) == '.')
					array.remove(i + 1);
			}
		}

		if (array.get(0) == '.')
			array.remove(0);
		if (array.get(array.size() - 1) == '.')
			array.remove(array.size() - 1);

		if (array.size() == 0)
			array.add('a');

		int length = array.size() > 15 ? 15 : array.size();

		ArrayList<Character> arrayTwo = new ArrayList<>(array.subList(0, length));

		if (arrayTwo.get(arrayTwo.size() - 1) == '.')
			arrayTwo.remove(arrayTwo.size() - 1);
		
		if(length < 3) {
			char cha = arrayTwo.get(arrayTwo.size() -1);
			while(arrayTwo.size()<3) {
				arrayTwo.add(cha);
			}
		}
		
		for(int i = 0; i< arrayTwo.size();++i) {
			answer += arrayTwo.get(i);
		}
		return answer;
	}
}
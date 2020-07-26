package com.ssafy.java;

public class Lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		int ranNum = 0;
		boolean reDo= false;
		for(int i =0;i<lotto.length;i++) {
			do {
				reDo= false;
				ranNum = (int)(Math.random()*45)+1;
				for(int j = 0;j<lotto.length;j++) {	//비교
					if(ranNum == lotto[j]) {
						reDo = true;
						break;
					}
				}
				
			}while(reDo);
			lotto[i] = ranNum;
		}
		
		for(int i = 0;i<lotto.length;i++) {		//결과 출력
			System.out.print(lotto[i]+ " ");
		}
	}
}

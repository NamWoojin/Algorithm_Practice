package com.ssafy.java;

public class AlpaTest2 {
	public static void main(String[] args) {
		char alphabet = 'A';
		
		for(int i = 0;i<5;i++) {
			for(int k = 0;k<4-i;k++) {	//5로 했을 때 띄어쓰기가 하나 더 나오므로 4로 설정.
				System.out.print("  ");
			}
			for(int  j = 0; j<=i;j++) {
				System.out.print(alphabet+" ");
				alphabet++;
			}
			System.out.println("");
		}
	}
}

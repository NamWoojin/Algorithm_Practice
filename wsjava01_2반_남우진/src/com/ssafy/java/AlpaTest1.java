package com.ssafy.java;

public class AlpaTest1 {
	public static void main(String[] args) {
		char alphabet = 'A';
		
		for(int i = 0;i<5;i++) {
			for(int  j = 0; j<=i;j++) {
				System.out.print(alphabet+" ");
				alphabet++;
			}
			System.out.println("");
		}
	}
}

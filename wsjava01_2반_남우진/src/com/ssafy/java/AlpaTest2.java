package com.ssafy.java;

public class AlpaTest2 {
	public static void main(String[] args) {
		char alphabet = 'A';
		
		for(int i = 0;i<5;i++) {
			for(int k = 0;k<4-i;k++) {	//5�� ���� �� ���Ⱑ �ϳ� �� �����Ƿ� 4�� ����.
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

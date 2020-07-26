package com.ssafy.java;

import java.util.Scanner;

public class Robot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int[] answer = new int[testCase];
		for (int k = 0; k < testCase; k++) {
			
			int arraySize = sc.nextInt();
			int[][] array = new int[arraySize][arraySize];
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					array[i][j] = sc.next().charAt(0);
				}
			}
			
			int sum = 0;
			for(int i = 0; i<array.length;i++) {
				for(int j = 0;j<array[i].length;j++) {
					switch(array[i][j]) {
						case 'A':
							//A�϶�
							break;
						case 'B':
							//B�϶�
							break;
						case 'C':
							//C�϶�
							break;
					}
				}
			}
			answer[k] = sum;
		}
		
		for(int i = 0;i<answer.length;i++)
			System.out.println("#"+i+" "+answer[i]);
		sc.close();
	}

}




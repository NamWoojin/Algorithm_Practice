package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] numArray = new int[10];
		while (T != 0) {
			numArray[T / 10] += 1;
			T = sc.nextInt();
		}

		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] > 0) {
				System.out.print(i);
				System.out.print(" : ");
				System.out.print(numArray[i]);
				System.out.println("°³");
			}
		}
		sc.close();
	}

}

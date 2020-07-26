package com.ssafy.java;

import java.util.Scanner;

public class 자릿수더하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = 0,sum = 0;
		
		while(N>=1) {
			num = N%10;
			sum +=num;
			N /= 10;
		}
		System.out.println(sum);
		sc.close();
	}

}

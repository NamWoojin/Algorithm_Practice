package com.ssafy.java;

import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum =0;
		int minPosition = 0;
		int min = 0;
		int[] score = new int[num];
		
		for(int i = 0; i< num ;i++) {
			score[i] = sc.nextInt();
			
		}
		min = score[0];
		for(int i = 0;i<score.length;i++) {
			System.out.println(score[i]);
			
			sum += score[i];
			if(min > score[i]) {
				min = score[i];
				minPosition= i;
			}
		}
		
		System.out.println("배열의 합 : "+sum);
		System.out.println("배열의 평균 : "+sum/score.length);
		System.out.println("배열의 최소값 : "+min);
		System.out.println("배열의 최소값의 위치 : "+minPosition);
		sc.close();
	}
}

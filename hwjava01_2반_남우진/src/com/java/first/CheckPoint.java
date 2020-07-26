package com.java.first;

import java.util.Scanner;

public class CheckPoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int weight = sc.nextInt();
		int fatNum  = Fat(weight,height);
		System.out.println("비만수치는 "+fatNum+"입니다.");
		if(fatNum>0)
			System.out.println("당신은 비만이군요.");
		sc.close();
	}

	static int Fat(int weight, int height) {
		return weight + 100 - height;
	}
}

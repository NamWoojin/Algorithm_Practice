package com.java.first;

import java.util.Scanner;

public class CheckPoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int weight = sc.nextInt();
		int fatNum  = Fat(weight,height);
		System.out.println("�񸸼�ġ�� "+fatNum+"�Դϴ�.");
		if(fatNum>0)
			System.out.println("����� ���̱���.");
		sc.close();
	}

	static int Fat(int weight, int height) {
		return weight + 100 - height;
	}
}

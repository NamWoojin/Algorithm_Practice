package com.ssafy.java;

import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {
		String user = "";
		int comWinNum = 0;
		int userWinNum = 0;
		int comnum = 0;
		int loopNum = 0, winNum = 0;
		System.out.println(">>���������� ������ �����մϴ�. �Ʒ� ���� �� �ϳ��� ������.");
		System.out.println("1. 5�� 3��\n2. 3�� 2��\n3. 1�� 1��");
		System.out.print("��ȣ�� �Է��ϼ���.");

		Scanner sc = new Scanner(System.in);
		loopNum = sc.nextInt();
		switch (loopNum) {
		case 1:
			loopNum = 5;
			winNum = 3;
			break;
		case 2:
			loopNum = 3;
			winNum = 2;
			break;
		case 3:
			loopNum = 1;
			winNum = 1;
			break;
		}

		for (int i = 0; i < loopNum; i++) {
			System.out.print("���������� �� �ϳ� �Է�: ");
			user = sc.next();
			comnum = (int) (Math.random() * 3) + 1;
			switch (comnum) {
			case 1:
				if (user.equals("����")) {
					System.out.println("�����ϴ�!");
				} else if (user.equals("����")) {
					System.out.println("�̰���ϴ�!");
					++userWinNum;
				} else if (user.equals("��")) {
					System.out.println("�����ϴ�!");
					++comWinNum;
				} else {
					System.out.println("�ٽ� �Է����ּ���.");
					--i;
				}
				break;
			case 2:
				if (user.equals("����")) {
					System.out.println("�����ϴ�!");
					++comWinNum;
				} else if (user.equals("����")) {
					System.out.println("�����ϴ�!");
				} else if (user.equals("��")) {
					System.out.println("�̰���ϴ�!");
					++userWinNum;
				} else {
					System.out.println("�ٽ� �Է����ּ���.");
					--i;
				}
				break;
			case 3:
				if (user.equals("����")) {
					System.out.println("�̰���ϴ�!");
					++userWinNum;
				} else if (user.equals("����")) {
					System.out.println("�����ϴ�!");
					++comWinNum;
				} else if (user.equals("��")) {
					System.out.println("�����ϴ�!");
				} else {
					System.out.println("�ٽ� �Է����ּ���.");
					--i;
				}
				break;
			}

			if (userWinNum >= winNum || comWinNum >= winNum)
				break;
		}

		if (userWinNum > comWinNum) {
			System.out.println("###����� ��!");
		} else if (comWinNum > winNum) {
			System.out.println("###��ǻ�� ��!");
		} else {
			System.out.println("###�����!");
		}

		sc.close();
	}
}

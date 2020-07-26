package com.ssafy.java;

import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {
		String user = "";
		int comWinNum = 0;
		int userWinNum = 0;
		int comnum = 0;
		int loopNum = 0, winNum = 0;
		System.out.println(">>가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승\n2. 3판 2승\n3. 1판 1승");
		System.out.print("번호를 입력하세요.");

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
			System.out.print("가위바위보 중 하나 입력: ");
			user = sc.next();
			comnum = (int) (Math.random() * 3) + 1;
			switch (comnum) {
			case 1:
				if (user.equals("가위")) {
					System.out.println("비겼습니다!");
				} else if (user.equals("바위")) {
					System.out.println("이겼습니다!");
					++userWinNum;
				} else if (user.equals("보")) {
					System.out.println("졌습니다!");
					++comWinNum;
				} else {
					System.out.println("다시 입력해주세요.");
					--i;
				}
				break;
			case 2:
				if (user.equals("가위")) {
					System.out.println("졌습니다!");
					++comWinNum;
				} else if (user.equals("바위")) {
					System.out.println("비겼습니다!");
				} else if (user.equals("보")) {
					System.out.println("이겼습니다!");
					++userWinNum;
				} else {
					System.out.println("다시 입력해주세요.");
					--i;
				}
				break;
			case 3:
				if (user.equals("가위")) {
					System.out.println("이겼습니다!");
					++userWinNum;
				} else if (user.equals("바위")) {
					System.out.println("졌습니다!");
					++comWinNum;
				} else if (user.equals("보")) {
					System.out.println("비겼습니다!");
				} else {
					System.out.println("다시 입력해주세요.");
					--i;
				}
				break;
			}

			if (userWinNum >= winNum || comWinNum >= winNum)
				break;
		}

		if (userWinNum > comWinNum) {
			System.out.println("###사용자 승!");
		} else if (comWinNum > winNum) {
			System.out.println("###컴퓨터 승!");
		} else {
			System.out.println("###비겼어요!");
		}

		sc.close();
	}
}

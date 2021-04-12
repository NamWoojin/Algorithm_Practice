import java.util.Scanner;

public class _3813_그래도수명이절반이되어서는 {
	
	// 드라이브를 1~N자리에 받아서 선택한 덩어리의 최댓값 중 최솟값 찾기
	// 이분탐색의 시간복잡도 : logN
	// Parametric Search : 이분탐색의 응용한 버전
	
	//K개의 덩어리를 잘 선택하여 Wear Level의 최댓값을 최소화하여라
	//==> Wear Level의 최댓값이 어떤 정수 c가 되도록 K개의 덩어리를 선택할 수 있는가??
	//==> 정수 c이하의 숫자를 골랐을 때 그 숫자들 중 해당 덩어리 패턴(2,1,3)을 만들 수 있는가?
	//==> 정수 c이하의 숫자 => l, 정수 c이상의 숫자 => h로 표기.
	//    l의 묶음이 덩어리 패턴이 될 수 있는지 확인(for문 한번만 돌면 가능하다!)
	//    개수를 세는 것을 배열 자체에 표시. 1번째 l = 1, 2번째 l = 2
	
	//이분탐색 : 오름차순으로 정렬된 배열에서 원하는 답을 찾는 것
	
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; ++tc) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int minNum = Integer.MAX_VALUE;
			int maxNum = 0;
			int[] drives = new int[N];
			for(int i = 0; i<N;++i) {
				drives[i] = sc.nextInt();
				minNum = drives[i] < minNum ? drives[i] : minNum;
				maxNum = drives[i] > maxNum ? drives[i] : maxNum;
			}
			
			int[] lumps = new int[K];
			for(int i = 0; i<K;++i) {
				lumps[i] = sc.nextInt();
			}
			
			int num = 0;
			while(true) {
				num = (minNum + maxNum) / 2;
				if(ParametricSearch(num, drives, lumps)) {
					maxNum = num;
				}else {
					minNum = num + 1;
				}
				if(minNum == maxNum) {
					break;
				}
			}
			System.out.println("#"+tc+" "+minNum);
		}
	}
	
	private static boolean ParametricSearch(int num, int[] arr, int[] lumps) {
		int lumpsIdx = 0;
		int count = 0;
		for(int i = 0; i<arr.length;++i) {
			if(arr[i] <= num) {
				++count;
			}else {
				count = 0;
			}
			if(count == lumps[lumpsIdx]) {
				++lumpsIdx;
				count = 0;
			}
			if(lumpsIdx == lumps.length) {
				return true;
			}
		}
		return false;
	}
}

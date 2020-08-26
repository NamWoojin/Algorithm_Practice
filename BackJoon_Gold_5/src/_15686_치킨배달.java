import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15686_치킨배달 {
	static int N;
	
	static class Node {
		int r;
		int c;
		int[] chickenLoad;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public int findMin(int[] arr) {
			int min = Integer.MAX_VALUE;
			for(int i = 0; i< arr.length;++i) {
				if(chickenLoad[arr[i]] < min)
					min = chickenLoad[arr[i]];
			}
			return min;
		}
	}

	static int chickenListSize = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Node> houseList = new ArrayList<>();
		ArrayList<Node> chickenList = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; ++j) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1)
					houseList.add(new Node(i, j));
				else if (n == 2)
					chickenList.add(new Node(i, j));
			}
		}
		chickenListSize = chickenList.size();
		int[] p = new int[chickenListSize];

		for (int i = 0; i < houseList.size(); ++i) {
			houseList.get(i).chickenLoad = new int[chickenList.size()];
			for (int j = 0; j < chickenList.size(); ++j) {
				houseList.get(i).chickenLoad[j] = Math.abs(houseList.get(i).r - chickenList.get(j).r)
						+ Math.abs(houseList.get(i).c - chickenList.get(j).c);
			}
		}

		int cnt = 0;
		while (++cnt <= M) { // 전처리(R개 만큼 1로 채우기)
			p[M - cnt] = 1;
		}
		Arrays.sort(p);
		int minimum = Integer.MAX_VALUE;
		
		do {
			int[] arr = new int[M];
			int num = 0;
			for (int i = 0; i < chickenListSize; ++i) {
				if (p[i] == 1) {
					arr[num++] = i;
				}
			}
			int sum = 0;
			for(int i =0; i<houseList.size();++i) {
				sum+= houseList.get(i).findMin(arr);
			}
			if(minimum> sum)
				minimum = sum;

		} while (nextPermutation(p));
		
		System.out.println(minimum);
	}

	private static boolean nextPermutation(int[] numbers) {
		// step1. 꼭대기 찾기
		int i = chickenListSize - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;
		if (i == 0)
			return false; // 마지막 순열 상태이면 다음 순열 없음
		// i = 꼭대기

		// step2. i-1위치와 교환할 다음 단계 큰 수 뒷쪽에서 찾기
		int j = chickenListSize - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;

		// step3. 자리 바꾸기
		swap(numbers, i - 1, j);

		// step4. i위치부터 맨 뒤까지 오름차순 정렬
		int k = chickenListSize - 1;
		while (i < k) {
			swap(numbers, i++, k--);
		}
		return true;
	}

	public static void swap(int[] numbers, int i, int j) {
		numbers[i] ^= numbers[j];
		numbers[j] ^= numbers[i];
		numbers[i] ^= numbers[j];
	}
}

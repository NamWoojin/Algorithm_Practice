import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2116_주사위쌓기 {
	static int N,max,arr[][],dir[]= {5,3,4,1,2,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		arr = new int [N][6];
		for(int i =0; i<N;++i) {
			st = new StringTokenizer(in.readLine());
			for(int j =0;j<6;++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =1; i<7;++i) {
			find(0,i,0);
		}
		System.out.println(max);
	}
	
	private static void find(int num,int number,int sum) {
		if(num == N) {
			max = Math.max(sum, max);
			return;
		}
//		System.out.println(num+" "+idx+" "+sum);
		int num1 = 0;
		int num2 = 0;
		for(int i =0; i<6;++i) {
			if(arr[num][i] == number) {
				num1 = i;
				num2 = dir[i];
				break;
			}
		}
		int maxNum = 0;
		for(int i =0; i<6;++i) {
			if(i == num1 || i == num2)
				continue;
			if(arr[num][i]>maxNum) {
				maxNum = arr[num][i];
			}
		}
		find(num+1,arr[num][num2],sum+maxNum);
	}
}

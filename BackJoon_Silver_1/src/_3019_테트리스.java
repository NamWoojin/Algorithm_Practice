import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3019_테트리스 {
	static int arr[];
	static int blocks[][][] = {
			{{0,0,0,0},{0}},	//1번 블록
			{{0,0}},			//2
			{{0,0,1},{1,0}},	//3
			{{1,0,0},{0,1}},	//4
			{{0,0,0},{1,0},{1,0,1},{0,1}},	//5
			{{0,0,0},{0,0},{0,1,1},{2,0}},	//6
			{{0,0,0},{0,0},{1,1,0},{0,2}}	//7
			};
	static int C,P,count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		C = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken())-1;
		arr = new int[C];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<C;++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<blocks[P].length;++i) {
			solve(0,i);
		}
		
		System.out.println(count);
	}
	
	static void solve(int idx,int num) {
		if(idx + blocks[P][num].length > C) {	//블록이 놓일 수 있는 범위 밖이면
			return;
		}
		
		solve(idx+1,num);
		int height = arr[idx] - blocks[P][num][0];
		for(int i = 1; i<blocks[P][num].length;++i) {
			if(height != arr[idx+i]- blocks[P][num][i]) {
				return;
			}
		}
		++count;
		
	}
}

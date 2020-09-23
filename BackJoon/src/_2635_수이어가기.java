import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _2635_수이어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int maxCount = 0;
		ArrayList<Integer> array = new ArrayList<>();
		for(int  i = 1; i<=N;++i) {
			ArrayList<Integer> tempArray = new ArrayList<>();
			tempArray.add(N);
			tempArray.add(i);
			
			while(true) {
				int size = tempArray.size();
				int num = tempArray.get(size-2) - tempArray.get(size-1);
				if(num<0) {
					break;
				}else {
					tempArray.add(num);
				}
			}
			if(maxCount < tempArray.size()) {
				array = tempArray;
				maxCount = tempArray.size();
			}
		}
		System.out.println(array.size());
		for(int i =0; i<array.size();++i) {
			System.out.print(array.get(i)+" ");
		}
	}
}

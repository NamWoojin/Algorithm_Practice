import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1230 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		for(int tc = 1;tc<=10;++tc) {
			ArrayList<String> array = new ArrayList<>();
			int N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			for(int i =0; i<N;++i) {
				array.add(st.nextToken());
			}
			int Number= Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j< Number;++j) {
				String command = st.nextToken();
				
				switch(command) {
				case "I":
					int idx = Integer.parseInt(st.nextToken());
					int count = Integer.parseInt(st.nextToken());
					for(int i = idx;i<idx+count;++i) {
						array.add(i,st.nextToken());
					}
					break;
				case "D":
					int index = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					for(int i = 0; i<num;++i) {
						if(index < array.size())
							array.remove(index);
						else
							break;
					}
					break;
				case "A":
					int number = Integer.parseInt(st.nextToken());
					for(int i = 0; i<number;++i)
						array.add(st.nextToken());
					break;
				}
				
			}
			
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i< 10;++i) {
				sb.append(array.get(i)).append(" ");
			}
			out.write(sb.toString());
			out.newLine();
			out.flush();
			sb.setLength(0);
		}
	}
}

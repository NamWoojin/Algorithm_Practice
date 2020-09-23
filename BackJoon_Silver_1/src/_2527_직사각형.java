import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2527_직사각형 {
	static class Node{
		int r,c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in  =new BufferedReader(new InputStreamReader(System.in));
		for(int i  =0; i<4;++i) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			Node start1 = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			Node end1 = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			Node start2 = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			Node end2 = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			
		}
	}
}

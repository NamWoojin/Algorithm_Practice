import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1927_최소힙 {
	static int heap[], size = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		heap = new int[N];
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(in.readLine());
			if(num == 0) {
				System.out.println(pop());
			}else {
				push(num);
			}
		}
	}
	
	static void push(int num) {
		int idx = ++size;
		while((idx != 1) && (num<heap[idx/2])) {
			heap[idx/2] ^= heap[idx];
			heap[idx] ^= heap[idx/2];
			heap[idx/2] ^= heap[idx];
			idx /= 2;
		}
		heap[idx] = num;
	}
	
	static int pop() {
		if(size == 0) {
			return 0;
		}
		int result = heap[1];
		heap[1] = heap[size--];
		int parent = 1;
		int child;
		while(true) {
			child = parent*2;
			if(child+1 <= size && heap[child] > heap[child+1]) {
				child++;
			}
			if(child>size || heap[child] > heap[parent]) {
				break;
			}
			heap[child] ^= heap[parent];
			heap[parent] ^= heap[child];
			heap[child] ^= heap[parent];
			parent = child;
			
		}
		return result;
	}
}

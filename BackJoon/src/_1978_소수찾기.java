import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1978_소수찾기 {
	public static int LAST_NUM;
	public static char sieve[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		LAST_NUM = Integer.parseInt(in.readLine());
		sieve = new char[(LAST_NUM+7)/8+1];
		int count = 0;
		StringTokenizer st = new StringTokenizer(in.readLine());

	}
	
	private static boolean isPrime(int k) {
		return (sieve[k>>>3] & (1<<(k&7))) == 0? false : true;
	}
	
	public static void eratosthenes() {
		Arrays.fill(sieve, (char)255);
	}
	
}

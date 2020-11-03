import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11654_아스키코드 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char character = in.readLine().charAt(0);
		System.out.println((int)character);
	}
}

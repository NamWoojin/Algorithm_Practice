import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9655_돌게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		System.out.println(N%2 == 0 ? "CY" : "SK");
	}
}

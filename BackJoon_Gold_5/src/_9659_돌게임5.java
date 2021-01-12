import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9659_돌게임5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Long.parseLong(in.readLine())%2 == 0 ? "CY" : "SK");
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9012_괄호 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(in.readLine());
      StringBuilder sb = new StringBuilder();
      for (int tc = 1; tc <= T; ++tc) {
         char[] arr = in.readLine().toCharArray();
         int openNum = 0;
         boolean vps = true;
         for (int i = 0; i < arr.length; ++i) {
            if(arr[i] == '(') {
               ++openNum;
            }else {
               --openNum;
            }
            if(openNum < 0) {
               vps = false;
               break;
            }
         }
         if(openNum != 0) {
            vps = false;
         }
         
         sb.append(vps ? "YES" : "NO").append("\n");
      }
      System.out.println(sb);
   }
}
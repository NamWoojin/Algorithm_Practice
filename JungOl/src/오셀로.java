
import java.util.Scanner;

public class 오셀로 {
   
   static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
   static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int testcase = sc.nextInt();   // �׽�Ʈ���̽� �Է�
      
      for(int t=1; t<=testcase; t++) {
         int N = sc.nextInt();   // �迭 ũ�� �Է�
         int M = sc.nextInt();   // �÷��̾ ���� ���� Ƚ��
         int board[][] = new int[N][N];
         
         int black = 0;
         int white = 0;
         // �⺻������ ��ġ�Ǵ� �浹(1), �鵹(2)
         board[N/2-1][N/2-1] = board[N/2][N/2] = 2;
         board[N/2][N/2-1] = board[N/2-1][N/2] = 1;
         
         for(int i=0; i<M; i++) {
            int R = sc.nextInt() -1;   //����� �Է��� (1,1) ���� �����̹Ƿ� 
            int C = sc.nextInt() -1;   //�޾ƿ� �� ���� -1���� ������ �ֱ�
            int color = sc.nextInt();
            
            board[R][C] = color;
            
            
            for(int n=0; n<8; n++) {   //���� ���� ���� �ִ��� 8������ �˻�
               
               int findr = R + dr[n];
               int findc = C + dc[n];
               
               boolean flag = true;
               
               // (R,C)�� board�ȿ� �ְ�, 0�� �ƴҶ�
               while(R>=0||C>=0||R<N||C<N||board[R][C]!=0) {
                  findr += dr[n];   //���� ���� �ƴϸ� �� ĭ�� �� �̵��ϴٰ�
                  findc += dc[n];

                  if(board[findr][findc] == color) {
                     flag = false;   // 8�� �����̸� ���� ���� ã����
                     break;         // �ݺ��� ����
                  }
               }
               
               while(flag) {
                  board[findr][findc] = color;   //���� �� ������ �ٸ��� ���� ���� �����Ű��
                  findr -= dr[n];   // ��ĭ�� �ڷ� ���� �̵��ϴٰ�
                  findc -= dr[n];
                  if(findr == R || findc == C) {   // �̵��ߴ� ��,���� ó�� ���� ���� ��,���� ��ġ�ϸ�
                     break;   // break
                  }
               }               
            }         
         }
         // �浹 �� �鵹 ���� ī����         
         for(int k=0; k<N; k++) {
            for(int j=0; j<N; j++) {
               if(board[k][j] == 1) {
                  black++;
               } else if (board[k][j] == 2) {
                  white++;
               }                     
            }
         }

         System.out.println("#" + t + " " + black + " " + white);
      }
   }
}

/*
1
4 12
1 2 1
1 1 2
4 3 1
4 4 2
2 1 1
4 2 2
3 4 1
1 3 2
2 4 1
1 4 2
4 1 2
3 1 2
*/
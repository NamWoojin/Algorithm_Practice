
import java.util.Scanner;

public class 오셀로 {
   
   static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
   static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int testcase = sc.nextInt();   // 테스트케이스 입력
      
      for(int t=1; t<=testcase; t++) {
         int N = sc.nextInt();   // 배열 크기 입력
         int M = sc.nextInt();   // 플레이어가 돌을 놓을 횟수
         int board[][] = new int[N][N];
         
         int black = 0;
         int white = 0;
         // 기본적으로 배치되는 흑돌(1), 백돌(2)
         board[N/2-1][N/2-1] = board[N/2][N/2] = 2;
         board[N/2][N/2-1] = board[N/2-1][N/2] = 1;
         
         for(int i=0; i<M; i++) {
            int R = sc.nextInt() -1;   //사용자 입력은 (1,1) 부터 시작이므로 
            int C = sc.nextInt() -1;   //받아올 때 부터 -1빼준 값으로 넣기
            int color = sc.nextInt();
            
            board[R][C] = color;
            
            
            for(int n=0; n<8; n++) {   //같은 색의 돌이 있는지 8방으로 검사
               
               int findr = R + dr[n];
               int findc = C + dc[n];
               
               boolean flag = true;
               
               // (R,C)가 board안에 있고, 0이 아닐때
               while(R>=0||C>=0||R<N||C<N||board[R][C]!=0) {
                  findr += dr[n];   //같은 색이 아니면 한 칸씩 더 이동하다가
                  findc += dc[n];

                  if(board[findr][findc] == color) {
                     flag = false;   // 8방 움직이며 같은 색을 찾으면
                     break;         // 반복문 종료
                  }
               }
               
               while(flag) {
                  board[findr][findc] = color;   //같은 색 사이의 다른색 돌의 색을 변경시키고
                  findr -= dr[n];   // 한칸씩 뒤로 오며 이동하다가
                  findc -= dr[n];
                  if(findr == R || findc == C) {   // 이동했던 행,열과 처음 돌을 놨던 행,열이 일치하면
                     break;   // break
                  }
               }               
            }         
         }
         // 흑돌 및 백돌 갯수 카운팅         
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
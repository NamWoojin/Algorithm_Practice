import java.util.Scanner;

public class Omok {
   
   static int pan[][] = new int[19][19];
   static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
   static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
   public static void main(String[] args) {
      // TODO Auto-generated method stub\
      Scanner sc = new Scanner(System.in);
      for(int i=0;i<19;i++) {
         for(int j=0;j<19;j++) {
            pan[i][j]=sc.nextInt();
         }
      }
      
      int xx=0, yy=0;
      boolean flag = true;
      int remem=0, resultr=0, resultc=0;
      
      
      for(int i=0;i<pan.length;i++) {
         for(int j=0; j<pan.length;j++) {
            if(flag&&pan[i][j]!=0) {
               
               remem = pan[i][j];
               resultr = i;
               resultc = j;
               
               int count = 1;
               
               for(int a=0;a<dr.length;a++) {
                  xx=i;
                  yy=j;
                  
                  for(int k=0;k<6;k++) {
                     xx+=dr[a];
                     yy+=dc[a];
                     if(xx<0||yy<0||xx>=19||yy>=19)
                        break;
                     
                     if(pan[xx][yy]==remem) 
                        count++;
                     else
                        break;
                  }
                  
                  if(count==5) {
                     flag = false;
                     break;
                  }
               }
            }
         }
      }
      System.out.println(remem);
      System.out.println((resultr+1)+" "+(resultc+1));
   }

}


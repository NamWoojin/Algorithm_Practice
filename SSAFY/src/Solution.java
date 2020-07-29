import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
         
        int num = sc.nextInt(); 
        for(int a=1;a<=num;a++) {
            String line = sc.next();
            char razer[] = line.toCharArray();
             
            int total =0;
            int cut =0;
            int left=0;
            int right=0;
            for(int i=0;i<razer.length;i++) {
            	
                cut =0;
                left=0;
                right=0;
                
                if(razer[i]=='('&&razer[i+1]==')') {
                    if(left!=0)
                    	cut++;
                    i++; //컷팅인 부분 넘어가게
                    continue;
                }
                if(razer[i]=='(') {
                    left++;
                    for(int j=i+1;j<razer.length;j++) {
                        if(razer[j]=='('&&razer[j+1]==')') {
                            if(left!=0)
                            	cut++;
                            j++;
                        }else if(razer[j]=='(') {
                            left++;
                        }else right++;
                        if(left==right) 
                            break;
                    }total += cut+1;
                }
            }               
            System.out.println("#"+a+" "+total);
        }
    }
}
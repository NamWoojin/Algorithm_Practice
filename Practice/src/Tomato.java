import java.util.Scanner;

public class Tomato {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int days = 1;	
		boolean endFlag =false;
		int[][] box = new int[N][M];
		for(int i = 0; i<N;++i) {	//입력
			for(int j = 0; j<M;++j) {
				box[i][j] = sc.nextInt();
			}
		}
		
		//모두 익지 못하는 상황 확인(익지 않은 토마토의 사방에 토마토가 들어있지 않은 경우)
		// + 모두 익은 상황 확인(0이 하나라도 있으면 해당되지 않음)
		boolean allRipe = true;
		for(int i = 0; i<N;++i) {	
			for(int j = 0; j<M;++j) {
				if(box[i][j] == 0) {
					allRipe = false;	//모두 익지 않은 것을 확인
					int cant =0;
					
					for(int k = 0; k< 4; ++k) {
						int r = i +dr[k];
						int c = j +dc[k];
						
						if(r<0|| c< 0|| r>=N|| c>= M) {
							++cant;
							continue;
						}
						if(box[r][c] == -1)	
							++cant;
					}
					if(cant == 4) {
						days = -1;
						endFlag = true;
						break;
					}
				}
			}
			if(endFlag)
				break;
		}
		
		if(allRipe) {	//모든 토마토가 익었을 때
			days = 0;
			endFlag = true;
		}
	
		//전체 상자를 한칸씩 확인하면서 익은(1) 토마토가 있다면 주변의 익지 않은(0) 토마토를 1로 전환
		//box[][]에 직접 전환을 시킬경우 새로 전환된 토마토가 다음 차례에 영향을 줌
		//따라서 temp에 복사한 후 모든 전환 과정을 수행한 후에 다시 box에 대입
		while(!endFlag) {
			int[][] temp = new int[N][M];
			for(int i = 0; i<N;++i) {	//복사
				for(int j = 0; j<M;++j) {
					temp[i][j] = box[i][j];
				}
			}
			for(int i = 0; i<N;++i) {	//토마토 익히기
				for(int j = 0; j<M;++j) {
					if(box[i][j] == 1) {
						for(int k = 0; k< 4; ++k) {
							int r = i +dr[k];
							int c = j +dc[k];
							
							if(r<0|| c< 0|| r>=N|| c>= M) 
								continue;
							if(box[r][c] == 0)	//복사한 배열(temp)에 대입
								temp[r][c] = 1;
						}
					}
				}
			}
			
			for(int i = 0; i<N;++i) {	//붙여넣기
				for(int j = 0; j<M;++j) {
					 box[i][j]= temp[i][j];
				}
			}
			
			
			boolean end = true;	//전부 익었는지 확인
			for(int i = 0; i<N;++i) {
				for(int j = 0; j<M;++j) {
					 if(box[i][j] == 0) {
						 end = false;
						 break;
					 }
				}
				if(!end) {
					break;
				}
			}
			
			if(end) 
				endFlag = true;
			else
				++days;
		}
		
		System.out.println(days);
		
		sc.close();
	}

}

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
		for(int i = 0; i<N;++i) {	//�Է�
			for(int j = 0; j<M;++j) {
				box[i][j] = sc.nextInt();
			}
		}
		
		//��� ���� ���ϴ� ��Ȳ Ȯ��(���� ���� �丶���� ��濡 �丶�䰡 ������� ���� ���)
		// + ��� ���� ��Ȳ Ȯ��(0�� �ϳ��� ������ �ش���� ����)
		boolean allRipe = true;
		for(int i = 0; i<N;++i) {	
			for(int j = 0; j<M;++j) {
				if(box[i][j] == 0) {
					allRipe = false;	//��� ���� ���� ���� Ȯ��
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
		
		if(allRipe) {	//��� �丶�䰡 �;��� ��
			days = 0;
			endFlag = true;
		}
	
		//��ü ���ڸ� ��ĭ�� Ȯ���ϸ鼭 ����(1) �丶�䰡 �ִٸ� �ֺ��� ���� ����(0) �丶�並 1�� ��ȯ
		//box[][]�� ���� ��ȯ�� ��ų��� ���� ��ȯ�� �丶�䰡 ���� ���ʿ� ������ ��
		//���� temp�� ������ �� ��� ��ȯ ������ ������ �Ŀ� �ٽ� box�� ����
		while(!endFlag) {
			int[][] temp = new int[N][M];
			for(int i = 0; i<N;++i) {	//����
				for(int j = 0; j<M;++j) {
					temp[i][j] = box[i][j];
				}
			}
			for(int i = 0; i<N;++i) {	//�丶�� ������
				for(int j = 0; j<M;++j) {
					if(box[i][j] == 1) {
						for(int k = 0; k< 4; ++k) {
							int r = i +dr[k];
							int c = j +dc[k];
							
							if(r<0|| c< 0|| r>=N|| c>= M) 
								continue;
							if(box[r][c] == 0)	//������ �迭(temp)�� ����
								temp[r][c] = 1;
						}
					}
				}
			}
			
			for(int i = 0; i<N;++i) {	//�ٿ��ֱ�
				for(int j = 0; j<M;++j) {
					 box[i][j]= temp[i][j];
				}
			}
			
			
			boolean end = true;	//���� �;����� Ȯ��
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

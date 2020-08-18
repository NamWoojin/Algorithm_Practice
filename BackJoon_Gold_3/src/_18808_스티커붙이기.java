import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18808_스티커붙이기 {
	static int[][] note;
	static sticker[] stickers;
	static int N,M,K;
	
	static class sticker{
		int R; int C;
		int[][] shape;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		//--------------------입력받기-----------------------------
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		note= new int[N][M];
		stickers = new sticker[K];
		for(int i =0;i<K;++i) {		//스티커 입력받기			
			st = new StringTokenizer(in.readLine());
			sticker stc = new sticker();
			stc.R = Integer.parseInt(st.nextToken());
			stc.C = Integer.parseInt(st.nextToken());
			stc.shape = new int[stc.R][stc.C];
			for(int j = 0; j<stc.R;++j) {
				st = new StringTokenizer(in.readLine()); 
				for(int k = 0; k<stc.C;++k) {
					stc.shape[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			stickers[i] = stc;
			
			//스티커 붙이기
			for(int j = 0; j<4;++j) {
				if(!stick(i)) {
					rotate(i);
					continue;
				}
				else 
					break;
				
				
			}
		}
		
		//결과 출력
		
		int count = 0;
		for(int i = 0; i<N;++i) {
			for(int j = 0; j<M;++j) {
				if(note[i][j] == 1)
					++count;
			}
		}
		System.out.println(count);
		
	}
	
	//--------------------스티커 붙이기-----------------------------
	private static boolean stick(int stickerNum) {
		if(N < stickers[stickerNum].R || M< stickers[stickerNum].C)	//스티커의 가로 또는 세로가 노트북보다 길면
			return false;
		
		for(int i = 0; i<N-stickers[stickerNum].R+1;++i) {
			for(int j = 0; j<M-stickers[stickerNum].C+1;++j) {
				if(stickOK(stickerNum,i,j))
					return true;
			}
		}
		return false;
	}
	
	private static boolean stickOK(int stickerNum,int r, int c) {
		for(int i  = 0; i<stickers[stickerNum].R;++i) {
			for(int j = 0;j<stickers[stickerNum].C;++j) {
				if(note[r+i][c+j]== 1 && stickers[stickerNum].shape[i][j]==1)
					return false;
					
			}
		}
		
		for(int i=r; i<stickers[stickerNum].R+r; ++i){
			for(int j = c; j<stickers[stickerNum].C+c;++j) {
				if(stickers[stickerNum].shape[i-r][j-c] == 1)
					note[i][j] = stickers[stickerNum].shape[i-r][j-c];
			}
            
        }
		return true;
	}
	
	//--------------------스티커 회전-----------------------------
	private static void rotate(int stickerNum) {
		int CC = stickers[stickerNum].C;
		int RR = stickers[stickerNum].R;
		int[][] shape = stickers[stickerNum].shape;
		int[][] tempShape = new int[CC][RR];
		
		for(int i = 0; i<RR;++i) {
			for(int j = 0; j<CC;++j) {
				tempShape[j][RR-1-i] = shape[i][j];
			}
		}
		stickers[stickerNum].R = CC;
		stickers[stickerNum].C = RR;
		stickers[stickerNum].shape = tempShape;
	}
}

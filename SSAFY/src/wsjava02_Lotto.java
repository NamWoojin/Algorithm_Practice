
public class wsjava02_Lotto {

	public static void main(String[] args) {
		int lottos[]= new int[6];
		for(int i =0;i<lottos.length;++i) {
			lottos[i] = (int)(Math.random()*45)+1;
			for(int j = 0; j<i;++j) {
				if(lottos[i] == lottos[j]) {
					//--i;
					break;
				}
			}
			
		}
		
		for(int i= 0;i<lottos.length;++i)
			System.out.print(lottos[i]+" ");
	}

}

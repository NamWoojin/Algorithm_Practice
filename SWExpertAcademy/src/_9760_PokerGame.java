import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _9760_PokerGame {
	//s, d, h, c
	//a23456789tjqk
	static class card implements Comparable<card>{
		int suit,rank;

		@Override
		public int compareTo(card o) {
			// TODO Auto-generated method stub
			return this.rank - o.rank;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc =1;tc<=T;++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			card[] cards = new card[5];
			int[] ranks = new int[14];
			for(int i = 0; i<5;++i) {
				String str = st.nextToken();
				cards[i] = new card();
				switch(str.charAt(0)) {
				case 'S':
					cards[i].suit = 0;
					break;
				case 'D':
					cards[i].suit = 1;
					break;
				case 'H':
					cards[i].suit = 2;
					break;
				case 'C':
					cards[i].suit = 3;
					break;
				}
				
				switch(str.charAt(1)) {
				case 'A':
					cards[i].rank = 1;
					break;
				case 'T':
					cards[i].rank = 10;
					break;
				case 'J':
					cards[i].rank = 11;
					break;
				case 'Q':
					cards[i].rank = 12;
					break;
				case 'K':
					cards[i].rank = 13;
					break;
				default:
					cards[i].rank = str.charAt(1)-'0';
					break;
				}
				++ranks[cards[i].rank];
			}
			Arrays.sort(cards);
			
			int kind = 9;
			
			boolean flush = true;
			boolean straight = true;
			for(int i =0; i<4;++i) {
				if(flush && cards[i].suit != cards[i+1].suit) {
					flush = false;
				}
				if(straight && cards[i].rank +1 != cards[i+1].rank) {
					straight = false;
				}
			}
			if(flush && kind > 4)
				kind =4;
			if(flush && straight)
				kind = 1;
			
			for(int i = 1;i<14;++i) {
				switch(ranks[i]) {
				case 2:
					if(kind == 9)
						kind = 8;
					else if(kind == 6)
						kind = 3;
					else if(kind == 8)
						kind = 7;
					break;
				case 3:
					if(kind == 8)
						kind = 3;
					else if(kind == 9)
						kind = 6;
					break;
				case 4:
					kind = 2;
					break;
				}
			}
			
			System.out.print("#"+tc+" ");
			switch(kind) {
			case 1:
				System.out.println("Straight Flush");
				break;
			case 2:
				System.out.println("Four of a Kind");
				break;
			case 3:
				System.out.println("Full House");
				break;
			case 4:
				System.out.println("Flush");
				break;
			case 5:
				System.out.println("Straight");
				break;
			case 6:
				System.out.println("Three of a kind");
				break;
			case 7:
				System.out.println("Two pair");
				break;
			case 8:
				System.out.println("One pair");
				break;
			case 9:
				System.out.println("High card");
				break;
				
			}
		}
	}
}

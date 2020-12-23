package AlgorithmDebugging;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class BlockChain {
	static class Block { // 블록에 대한 구조체 구현
		String previous;
		String data;
		int nonce = 0;
		Block(String previous, String data) {
			this.previous = previous;
			this.data = data;
		}
	}

	static Block[] blocks;
	static int blockNum = 2;
	static int nonce = 0;
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		blocks = new Block[num+1];
		if (num >= 2) {
			blocks[0] = new Block("", "Genesis Block"); // Genesis 블록 생성
			System.out.println("nonce : "+ nonce);
			System.out.println("data : "+ blocks[0].data);
			System.out.println("prevhash: "+ blocks[0].previous);
			String hash = sha256("a"+nonce);
			System.out.println("hash : "+hash);
			blocks[1] = new Block(hash, Integer.toString(blockNum++));
			
			for(int i = 1;i<num;++i) {
				while(true) {
					String s = sha256(blocks[i].previous+nonce++);
					String result = s.substring(0,5);
					System.out.println(nonce);
					if(result.equals("00000")) {
						
						System.out.println("nonce : "+nonce);
						System.out.println("data : "+ blocks[i].data);
						System.out.println("prevhash: "+ blocks[i].previous);
						System.out.println("hash : "+result);
						blocks[i+1] = new Block(result,Integer.toString(blockNum++));
						break;
					}
						
				}
			}
			
		}
	}

	public static String sha256(String msg) throws NoSuchAlgorithmException { // sha256 사용
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());
		StringBuilder builder = new StringBuilder();
		byte[] bytes = md.digest();
		for (byte b : bytes) {
			builder.append(String.format("%2x", b));
		}
		return builder.toString();
	}

}

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BlockChain_은수 {
	public static class Block {
		private String hash;
		private String previousHash;

		private String data;
		private long timeStamp;

		private int nonce;

		public Block(String data, String previousHash) {
			this.data = data;
			this.previousHash = previousHash;

			this.timeStamp = new Date().getTime();
			this.hash = calculateHash();
		}

		public String calculateHash() {
			return generateHash(previousHash, Long.toString(timeStamp), Integer.toString(nonce), data);
		}

		public void mineBlock() {
			char[] targetChar = new char[DIFFICULTY];
			Arrays.fill(targetChar, '0');
			String target = String.valueOf(targetChar);

			while (hash.substring(0, DIFFICULTY).equals(target) == false) {
				nonce++;
				hash = calculateHash();
			}

		}

		public String getPreviousHash() {
			return previousHash;
		}

		public String getHash() {
			return hash;
		}

		public long getTimeStamp() {
			return timeStamp;
		}

		public String getData() {
			return data;
		}

		public int getNonce() {
			return nonce;
		}

	}

	public static List<Block> BLOCK_CHAIN = new LinkedList<>();

	public static int DIFFICULTY = 5;

	public static void main(String[] args) {

		BLOCK_CHAIN.add(new Block("Genesis Block", ""));
		BLOCK_CHAIN.get(0).mineBlock();

		BLOCK_CHAIN.add(new Block("2nd", BLOCK_CHAIN.get(BLOCK_CHAIN.size() - 1).getHash()));
		BLOCK_CHAIN.get(1).mineBlock();

		BLOCK_CHAIN.add(new Block("3rd", BLOCK_CHAIN.get(BLOCK_CHAIN.size() - 1).getHash()));
		BLOCK_CHAIN.get(2).mineBlock();

		BLOCK_CHAIN.add(new Block("4th", BLOCK_CHAIN.get(BLOCK_CHAIN.size() - 1).getHash()));
		BLOCK_CHAIN.get(3).mineBlock();

		for (Block block : BLOCK_CHAIN) {
			System.out.println("nonce : " + block.getNonce());
			System.out.println("data : " + block.getData());
			System.out.println("prevhash : " + block.getPreviousHash());
			System.out.println("hash : " + block.getHash());
			System.out.println();
		}

		System.out.println();

		System.out.println("This Blockchain is Valid : " + isValidBlockChain());
	}

	private static boolean isValidBlockChain() {
		Block currentBlock;
		Block previousBlock;

		char[] target = new char[DIFFICULTY];
		Arrays.fill(target, '0');

		String hashTarget = String.valueOf(target);

		for (int i = 1; i < BLOCK_CHAIN.size(); i++) { // GenesisBlock 은 제외한다.
			currentBlock = BLOCK_CHAIN.get(i);
			previousBlock = BLOCK_CHAIN.get(i - 1);

			if (currentBlock.getHash().equals(currentBlock.calculateHash()) == false) { // 만들어 놓은 Hash값과 계산한 Hash값이 같은지
																						// 검증!
				System.out.println("Not Equals Current Block Hash!!");
				return false;
			}

			if (currentBlock.getPreviousHash().equals(previousBlock.getHash()) == false) {
				System.out.println("Not Equals Previous Block Hash!!");
				return false;
			}

			if (currentBlock.getHash().substring(0, DIFFICULTY).equals(hashTarget) == false) {
				System.out.println("This block hasn't been mined");
				return false;
			}

		}

		return true;
	}

	public static String generateHash(String... inputValues) {
		try {
			StringBuffer sb = new StringBuffer();
			for (String inputValue : inputValues) {
				sb.append(inputValue);
			}

			String input = sb.toString();

			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}

				hexString.append(hex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

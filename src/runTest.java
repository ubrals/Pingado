import java.math.BigInteger;

import fundamental.Block;

public class runTest {

	public static void main(String[] args) {
		Block block = new Block(4, "1aef899acd834", "278ef9340cfd7b", java.time.Instant.now().getEpochSecond(), 938938l, 0l, "1000aaabb", new Block());
		
		//System.out.println(String.format("%x", new BigInteger(1, block.getHash().getHash().getBytes())));
		System.out.println(String.format("%x", new BigInteger(1, block.getHash().getHash().getBytes())));
	}

}

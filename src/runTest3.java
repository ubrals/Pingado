import fundamental.Block;

public class runTest3 {

	public static void main(String[] args) {
		Block block = new Block(4, "1aef899acd834", "278ef9340cfd7b", java.time.Instant.now().getEpochSecond(), 938938l, 0l, "1000aaabb", new Block());
		System.out.println(block.getPreviousBlockHash().getHash());
		System.out.println(engine.Sha.getSha256(block.getPreviousBlockHash().getHash(), 160));
	}
}

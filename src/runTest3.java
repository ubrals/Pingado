import deprecated.Block_old;

public class runTest3 {

	public static void main(String[] args) {
		Block_old block = new Block_old(4, "1aef899acd834", "278ef9340cfd7b", java.time.Instant.now().getEpochSecond(), 938938l, 0l, "1000aaabb", new Block_old());
		System.out.println(block.getPreviousBlockHash().getHash());
		System.out.println(utils.Sha.getSha256(block.getPreviousBlockHash().getHash(), 160));
	}
}

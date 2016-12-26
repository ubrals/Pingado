package fundamental;

public class Block2 {
	final class Header{
		private int version; // 4 bytes
		private String previousBlockHash; // 32 bytes
		private Merkle root; // 32 bytes
		private long timestamp; // 4 bytes // java.time.Instant.now().getEpochSecond();
		private long nBits; // 4 bytes
		private long nonce; // 4 bytes
		
		Header(int version, String previousBlockHash, Merkle root, long timestamp, long nBits, long nonce) {
			this.version = version;
			this.previousBlockHash = previousBlockHash;
			this.root = root;
			this.timestamp = timestamp;
			this.nBits = nBits;
			this.nonce = nonce;
		}
		
	}
}

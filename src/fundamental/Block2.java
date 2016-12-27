package fundamental;

public class Block2 {
	final class Header{
		private int version; // 4 bytes
		private String previousBlockHash; // 32 bytes
		private String root; // 32 bytes
		private long timestamp; // 4 bytes // java.time.Instant.now().getEpochSecond();
		private long nBits; // 4 bytes
		private long nonce; // 4 bytes
		
		Header(int version, String previousBlockHash, String root, long timestamp, long nBits, long nonce) {
			this.setVersion(version);
			this.setPreviousBlockHash(previousBlockHash);
			this.setRoot(root);
			this.setTimestamp(timestamp);
			this.setnBits(nBits);
			this.setNonce(nonce);
		}

		public int getVersion() {
			return version;
		}

		public void setVersion(int version) {
			this.version = version;
		}

		public String getPreviousBlockHash() {
			return previousBlockHash;
		}

		public void setPreviousBlockHash(String previousBlockHash) {
			this.previousBlockHash = previousBlockHash;
		}

		public String getRoot() {
			return root;
		}

		public void setRoot(String root) {
			this.root = root;
		}

		public long getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}

		public long getnBits() {
			return nBits;
		}

		public void setnBits(long nBits) {
			this.nBits = nBits;
		}

		public long getNonce() {
			return nonce;
		}

		public void setNonce(long nonce) {
			this.nonce = nonce;
		}
		
	}
	
	////////
	// Block
	private Header header;
	private String hash;
	private Block previousBlock;
	
	public Block2(){
		//makeBlock(header, hash);
	}

}

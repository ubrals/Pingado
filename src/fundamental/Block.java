package fundamental;

import static engine.Sha.getSha256;

public class Block {
	private final class Header{
		private int version = 4; // 4 bytes
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

		private int getVersion() {
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
	
	public Block(){
	}
	
	public Block(int version, String previousBlockHash, String merkleRootHash, long timestamp, long nBits, long nonce, Block previousBlock) {
		String prevhash = previousBlockHash;
		String merkle = merkleRootHash;
		Header header = new Header(version, previousBlockHash, merkle, timestamp, nBits, nonce);
		this.header = header;
		this.hash = makeHash();
		this.previousBlock = previousBlock;
	}
	private String makeHash(){
		String concatHeader = header.version + header.previousBlockHash + header.root + header.timestamp + header.nBits + header.nonce;
		String hashed = getSha256(getSha256(concatHeader, 64), 64);
		return hashed;
	}
	
	public int getVersion(){
		return header.getVersion();
	}
	public String getPreviousBlockHash(){
		return header.getPreviousBlockHash();
	}
	public String getRoot(){
		return header.getRoot();
	}
	public long getTimestamp(){
		return header.getTimestamp();
	}
	public long getNbits(){
		return header.getnBits();
	}
	public long getNonce(){
		return header.getNonce();
	}
	public String getHash(){
		return this.hash;
	}
	@Override
	public String toString(){
		return "Block {" + "\n"
			 + "  version : " + this.getVersion() + "\n"
		     + "  this block hash   : " + this.getHash() + "\n"
		     + "  prev block hash   : " + this.getPreviousBlockHash() + "\n"
		     + "  merkle root hash  : " + this.getRoot() + "\n"
		     + "  timestamp : " + this.getTimestamp() + "\n"
		     + "  nBits : " + this.getNbits() + "\n"
		     + "  nonce : " + this.getNonce() + "\n"
		     + "}";
	}

}

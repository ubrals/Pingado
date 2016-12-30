package core;

import static utils.Sha.getSha256;

public class Block {
	/*****
	 * 
	 * @author ubrals
	 * {@link} https://bitcoin.org/en/developer-reference#block-headers
	 * Block's header was set to be a nested and private class, in order to (como é que chama aquela porra de APD3 mesmo?!??!)
	 * and encapsulation.
	 * 
	 */
	private final class Header{
		private int version = 4; // 4 bytes
		private String previousBlockHash; // 32 bytes
		private String root; // 32 bytes
//		private Merkle merkleRoot; // TODO: Refactor to make root a Merkle class
		private long timestamp; // 4 bytes // java.time.Instant.now().getEpochSecond();
		private long nBits; // 4 bytes
		private long nonce; // 4 bytes
		
		/******
		 * 
		 * @param version // class' default is 4
		 * @param previousBlockHash
		 * @param root
		 * @param timestamp
		 * @param nBits
		 * @param nonce
		 */
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
	
	/*****
	 * 
	 * @param header
	 * @param hash
	 * @param previousBlock // a priori it is not necessary.
	 *                      // TODO: Refactor and remove
	 */
	private Header header;
	private String hash;
	private Block previousBlock;
	
	/*****
	 * Default constructor
	 */
	public Block(){
	}
	
	/*****
	 * 
	 * @param version
	 * @param previousBlockHash
	 * @param merkleRootHash
	 * @param timestamp
	 * @param nBits
	 * @param nonce
	 * @param previousBlock
	 * 
	 */
	public Block(int version, String previousBlockHash, String merkleRootHash, long timestamp, long nBits, long nonce, Block previousBlock) {
		Header header = new Header(version, previousBlockHash, merkleRootHash, timestamp, nBits, nonce);
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

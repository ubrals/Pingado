package fundamental;

final class Header{
	private int version; // 4 bytes
	private Hash previousBlockHash; // 32 bytes
	private Merkle root; // 32 bytes
	private long timestamp; // 4 bytes // java.time.Instant.now().getEpochSecond();
	private long target; // 4 bytes
	private long nonce; // 4 bytes
	
	Header(int version, Hash previousBlockHash, Merkle root, long timestamp, long target, long nonce) {
		this.version = version;
		this.previousBlockHash = previousBlockHash;
		this.root = root;
		this.timestamp = timestamp;
		this.target = target;
		this.nonce = nonce;
	}
	int getVersion(){ return version; };
	Hash getPreviousBlockHash(){ return previousBlockHash; };
	Merkle getRoot(){ return root; };
	long getTimestamp(){ return timestamp; };
	long getTarget(){ return target; };
	long getNonce(){ return nonce; };

	void setVersion(int version){ this.version = version; };
	void setPreviousBlockHash(Hash previousBlockHash){ this.previousBlockHash = previousBlockHash; };
	void setRoot(Merkle root){ this.root = root; };
	void setTimestamp(long timestamp){ this.timestamp = timestamp; };
	void setTarget(long target){ this.target = target; };
	void setNonce(long nonce){ this.nonce = nonce; };
}

public class Block {
	private Header header;
	private Hash hash;
	private Block previousBlock;
	
	public Block(){
		//makeBlock(header, hash);
	}
	
	public Block(int version, String previousBlockHash, String merkleRootHash, long timestamp, long target, long nonce, String thisHashHash, Block previousBlock) {
		Hash hash = new Hash();        hash.setHash(previousBlockHash);
		Merkle merkle = new Merkle();  hash.setHash(merkleRootHash); merkle.setHash(hash);
		Header header = new Header(version, hash, merkle, timestamp, target, nonce);
		Hash thisHash = new Hash(); thisHash.setHash(thisHashHash);
		this.header = header;
		this.hash = thisHash;
		this.previousBlock = previousBlock;
	}
	
	private void makeBlock(Header header, Hash hash) {
		this.header = new Header(4, previousBlock.getHash(), new Merkle(), java.time.Instant.now().getEpochSecond(), 99L, 0L);
		this.hash = hash;
	}

	public Hash getHash() {
		return hash;
	}

	public void setHash(Hash hash) {
		this.hash = hash;
	}
	
	public int getVersion(){ return header.getVersion(); };
	public Hash getPreviousBlockHash(){ return header.getPreviousBlockHash(); };
	public Merkle getRoot(){ return header.getRoot(); };
	public long getTimestamp(){ return header.getTimestamp(); };
	public long getTarget(){ return header.getTarget(); };
	public long getNonce(){ return header.getNonce(); };

}

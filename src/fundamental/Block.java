package fundamental;

class Header{
	int version; // 4 bytes
	Hash previousBlockHash; // 32 bytes
	Merkle root; // 32 bytes
	long timestamp; // 4 bytes // java.time.Instant.now().getEpochSecond();
	long target; // 4 bytes
	long nonce; // 4 bytes
	
	public Header(int version, Hash previousBlockHash, Merkle root, long timestamp, long target, long nonce) {
		super();
		this.version = version;
		this.previousBlockHash = previousBlockHash;
		this.root = root;
		this.timestamp = timestamp;
		this.target = target;
		this.nonce = nonce;
	}
	
	
}

public class Block {
	private Header header;
	private Hash hash;
	private Block previousBlock;
	
	public Block(){
		makeBlock(header, hash);
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
	
}

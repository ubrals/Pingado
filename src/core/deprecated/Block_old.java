package core.deprecated;

import core.Hash;

final class Header{
	private int version; // 4 bytes
	private Hash previousBlockHash; // 32 bytes
	private Merkle_subclasses_Header_etc root; // 32 bytes
	private long timestamp; // 4 bytes // java.time.Instant.now().getEpochSecond();
	private long nBits; // 4 bytes
	private long nonce; // 4 bytes
	
	Header(int version, Hash previousBlockHash, Merkle_subclasses_Header_etc root, long timestamp, long nBits, long nonce) {
		this.version = version;
		this.previousBlockHash = previousBlockHash;
		this.root = root;
		this.timestamp = timestamp;
		this.nBits = nBits;
		this.nonce = nonce;
	}
	int getVersion(){ return version; };
	Hash getPreviousBlockHash(){ return previousBlockHash; };
	Merkle_subclasses_Header_etc getRoot(){ return root; };
	long getTimestamp(){ return timestamp; };
	long getNbits(){ return nBits; };
	long getNonce(){ return nonce; };

	void setVersion(int version){ this.version = version; };
	void setPreviousBlockHash(Hash previousBlockHash){ this.previousBlockHash = previousBlockHash; };
	void setRoot(Merkle_subclasses_Header_etc root){ this.root = root; };
	void setTimestamp(long timestamp){ this.timestamp = timestamp; };
	void setNbits(long nBits){ this.nBits = nBits; };
	void setNonce(long nonce){ this.nonce = nonce; };
}

public class Block_old {
	private Header header;
	private Hash hash;
	private Block_old previousBlock;
	
	public Block_old(){
		//makeBlock(header, hash);
	}
	
	public Block_old(int version, String previousBlockHash, String merkleRootHash, long timestamp, long nBits, long nonce, String thisHashHash, Block_old previousBlock) {
		Hash hash = new Hash();        hash.setHash(previousBlockHash);
		Merkle_subclasses_Header_etc merkle = new Merkle_subclasses_Header_etc();  hash.setHash(merkleRootHash); //merkle.setHash(hash);
		Header header = new Header(version, hash, merkle, timestamp, nBits, nonce);
		Hash thisHash = new Hash(); thisHash.setHash(thisHashHash);
		this.header = header;
		this.hash = thisHash;
		this.previousBlock = previousBlock;
	}
	
//	private void makeBlock(Header header, Hash hash) {
//		this.header = new Header(4, previousBlock.getHash(), new Merkle(), java.time.Instant.now().getEpochSecond(), 99L, 0L);
//		this.hash = hash;
//	}

	public Hash getHash() {
		return hash;
	}

	public void setHash(Hash hash) {
		this.hash = hash;
	}
	
	public int    getVersion(){ return header.getVersion(); };
	public Hash   getPreviousBlockHash(){ return header.getPreviousBlockHash(); };
	public Merkle_subclasses_Header_etc getRoot(){ return header.getRoot(); };
	public long   getTimestamp(){ return header.getTimestamp(); };
	public long   getNbits(){ return header.getNbits(); };
	public long   getNonce(){ return header.getNonce(); };
	
	@Override
	public String toString(){
		return "Block_old {"
			 + "  version : " + this.getVersion() + "\n"
		     + "  this block hash : " + this.getHash().getHash() + "\n"
		     + "  prev block hash : " + this.getPreviousBlockHash().getHash() + "\n"
		     + "  merkle root hash : " + this.getRoot().getHash() + "\n"
		     + "  timestamp : " + this.getTimestamp() + "\n"
		     + "  nBits : " + this.getNbits() + "\n"
		     + "  nonce : " + this.getNonce() + "\n"
		     + "}";
	}
}

package core;

import static utils.Sha.getSha256;

import java.util.ArrayList;
import java.util.List;

import static utils.Conversions.*;

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
		private byte[] version = {50,(Byte) null,(Byte) null,(Byte) null}; // 4 bytes
		private byte[] previousBlockHash = new byte[32]; // 32 bytes
		private byte[] merkleRootHash = new byte[32];
		private byte[] timestamp = new byte[4]; // 4 bytes // java.time.Instant.now().getEpochSecond();
		private byte[] nBits = new byte[4]; // 4 bytes
		private byte[] nonce = new byte[4]; // 4 bytes
		
		/******
		 * 
		 * @param version // class' default is 4
		 * @param previousBlockHash
		 * @param merkleRootHash
		 * @param timestamp
		 * @param nBits
		 * @param nonce
		 */
		Header(byte[] previousBlockHash, byte[] merkleRootHash, byte[] timestamp, byte[] nBits, byte[] nonce) {
			this.setVersion(version);
			this.setPreviousBlockHash(previousBlockHash);
			this.setMerkleRootHash(merkleRootHash);
			this.setTimestamp(timestamp);
			this.setnBits(nBits);
			this.setNonce(nonce);
		}

		private byte[] getVersion() {
			return version;
		}

		public void setVersion(byte[] version) {
			this.version = version;
		}

		public byte[] getPreviousBlockHash() {
			return previousBlockHash;
		}

		public void setPreviousBlockHash(byte[] previousBlockHash) {
			this.previousBlockHash = previousBlockHash;
		}

		public byte[] getMerkleRootHash() {
			return merkleRootHash;
		}

		public void setMerkleRootHash(byte[] merkleRootHash) {
			this.merkleRootHash = merkleRootHash;
		}

		public byte[] getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(byte[] timestamp) {
			this.timestamp = timestamp;
		}

		public byte[] getnBits() {
			return nBits;
		}

		public void setnBits(byte[] nBits) {
			this.nBits = nBits;
		}

		public byte[] getNonce() {
			return nonce;
		}

		public void setNonce(byte[] nonce) {
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
	private byte[] hash = new byte[32];
	private Block previousBlock;
    private List<Transaction> transactions = new ArrayList<Transaction>();

	
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
	public Block(byte[] previousBlockHash, byte[] merkleRootHash, byte[] timestamp, byte[] nBits, byte[] nonce, Block previousBlock) {
		Header header = new Header(previousBlockHash, merkleRootHash, timestamp, nBits, nonce);
		this.header = header;
		this.hash = makeHash();
		this.previousBlock = previousBlock;
	}
	
	public void addTransaction(Transaction transaction){
	    transactions.add(transaction);
	}
	
    private byte[] makeHash(){
        String concatHeader = byteToString(header.getVersion())
                            + byteToString(header.getPreviousBlockHash())
                            + byteToString(header.getMerkleRootHash())
                            + byteToString(header.getTimestamp())
                            + byteToString(header.getnBits())
                            + byteToString(header.getNonce());
		String hashed = getSha256(getSha256(concatHeader, 64), 64);
		return stringToByte(hashed);
	}
	
	public byte[] getVersion(){
		return header.getVersion();
	}
	
	public byte[] getPreviousBlockHash(){
		return header.getPreviousBlockHash();
	}
	
	public byte[] getRoot(){
		return header.getMerkleRootHash();
	}
	
	public byte[] getTimestamp(){
		return header.getTimestamp();
	}
	
	public byte[] getNbits(){
		return header.getnBits();
	}
	
	public byte[] getNonce(){
		return header.getNonce();
	}
	
	public byte[] getHash(){
		return this.hash;
	}
	
	@Override
	public String toString(){
		return "Block {" + "\n"
			 + "  version : " + byteToString(this.getVersion()) + "\n"
		     + "  this block hash   : " + byteToString(this.getHash()) + "\n"
		     + "  prev block hash   : " + byteToString(this.getPreviousBlockHash()) + "\n"
		     + "  merkle root hash  : " + byteToString(this.getRoot()) + "\n"
		     + "  timestamp : " + byteToString(this.getTimestamp()) + "\n"
		     + "  nBits : " + byteToString(this.getNbits()) + "\n"
		     + "  nonce : " + byteToString(this.getNonce()) + "\n"
		     + "}";
	}
}

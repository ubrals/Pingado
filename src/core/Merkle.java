package core;

import static utils.Sha.getSha256;

import java.util.ArrayList;
import java.util.List;

public class Merkle {
	/*****
	 * 
	 * @author ubrals
	 * {@link} https://bitcoin.org/en/developer-reference#merkle-trees
	 * Merkle tree that holds the transactions in the block
	 *
	 */
//////////////
// Header
	private class Header{
		/*****
		 * 
		 * @author ubrals
		 * Block's header was set to be a nested and private class, in order to (como é que chama aquela porra de APD3 mesmo?!??!)
		 * and encapsulation.
		 * 
		 * Input and Output were set as nested classes in order to(como é que chama aquela porra de APD3 mesmo?!??!)
		 * and encapsulation.
		 */
	////////////
	// Input
		private class Input {
			private String previousOutput[] = new String[2];
			private String outpoint[] = new String[2]; // [1]: 32 bytes TXID; [2]: 4 bytes output index (vout)
			private String scriptSig;
			private int sequenceNumber;
			
			private Input(){
			}
			
			private Input(String previousOutput[], String outpoint[], String scriptSig, int sequenceNumber){
				this.setPreviousOutput(previousOutput);
				this.setOutpoint(outpoint);
				this.setScriptSig(scriptSig);
				this.setSequenceNumber(sequenceNumber);
			}
			
			private String[] getPreviousOutput() {
				return previousOutput;
			}

			private void setPreviousOutput(String previousOutput[]) {
				this.previousOutput = previousOutput;
			}

			private String[] getOutpoint() {
				return outpoint;
			}

			private void setOutpoint(String outpoint[]) {
				this.outpoint = outpoint;
			}

			private String getScriptSig() {
				return scriptSig;
			}

			private void setScriptSig(String scriptSig) {
				this.scriptSig = scriptSig;
			}

			private int getSequenceNumber() {
				return sequenceNumber;
			}

			private void setSequenceNumber(int sequenceNumber) {
				this.sequenceNumber = sequenceNumber;
			}
			
			private String toMakeHash(){
				return this.getPreviousOutput()[0] + this.getPreviousOutput()[1]
					 + this.getScriptSig() + this.getSequenceNumber();
			}
		}
	// Input end
	////////////
		
	////////////
	// Output
		private class Output{
			private double satoshis;
			private String scriptPubKey;
			
			public Output(){
			}
			
			public Output(double satoshis, String scriptPubKey){
				this.setSatoshis(satoshis);
				this.setScriptPubKey(scriptPubKey);
			}
			
			public double getSatoshis() {
				return satoshis;
			}

			public void setSatoshis(double satoshis) {
				this.satoshis = satoshis;
			}

			public String getScriptPubKey() {
				return scriptPubKey;
			}

			public void setScriptPubKey(String scriptPubKey) {
				this.scriptPubKey = scriptPubKey;
			}
			
			public String toMakeHash(){
				return this.getSatoshis() + this.getScriptPubKey();
			}
		}
	// Output end
	////////////
		
		/*****
		 * Header parms
		 * 
		 * @param version // class' default is 1
		 * @param tx_in_count // count of input transactions
		 * @param tx_in // every input transaction within the block
		 * @param tx_out_count // count of output transactions
		 * @param tx_out // every output transaction within the block
		 * @param lock_time // timestamp
		 */
		private int version = 1; // 4 bytes
		private int tx_in_count;
		private List<Input> tx_in = new ArrayList<Input>();
		private int tx_out_count;
		private List<Output> tx_out = new ArrayList<Output>();
		private long lock_time;
		
		public Header(){
		}
		
		public Header(int version, int tx_in_count){
			Input input = new Input(new String[] {"a", "b"}, new String[] {"c", "d"}, "pubkey", 0);
			Output output = new Output()
		}

		private int getVersion() {
			return version;
		}

		private void setVersion(int version) {
			this.version = version;
		}

		private int getTx_in_count() {
			return tx_in_count;
		}

		private void setTx_in_count(int tx_in_count) {
			this.tx_in_count = tx_in_count;
		}

		private List<Input> getTx_in() {
			return tx_in;
		}

		private void setTx_in(List<Input> tx_in) {
			this.tx_in = tx_in;
		}

		private int getTx_out_count() {
			return tx_out_count;
		}

		private void setTx_out_count(int tx_out_count) {
			this.tx_out_count = tx_out_count;
		}

		private List<Output> getTx_out() {
			return tx_out;
		}

		private void setTx_out(List<Output> tx_out) {
			this.tx_out = tx_out;
		}

		private long getLock_time() {
			return lock_time;
		}

		private void setLock_time(long lock_time) {
			this.lock_time = lock_time;
		}
		
		private String toMakeHash(){
			String ret;
			ret =  String.valueOf(this.getVersion());
			ret += String.valueOf(this.getTx_in_count());
			for(int i=0; i<tx_in.size(); i++)
				ret += tx_in.get(i).toMakeHash();
			ret += String.valueOf(this.getTx_out_count());
			for(int i=0; i<tx_out.size(); i++)
				ret += tx_out.get(i).toMakeHash();
			ret += this.getLock_time();
			
			return ret;
		}
	}
// Header end
//////////////
	
	/*****
	 * Merkle parms
	 * 
	 * @param hash
	 * @param transactions
	 * 
	 */
	private Header header;
	private String hash;
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	public Merkle(){
	}
	
	public Merkle(){
		Header header = new Header()
		
	}
	
	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = makeHash();
	}
	
	private String toMakeHash(){
		String ret = null;
		for(int i=0; i<transactions.size(); i++){
			ret += transactions.get(i).toMakeHash();
		}
		return ret;
	}
	private String makeHash(){
		String concatHeader = null;//= header.version + header.previousBlockHash + header.root + header.timestamp + header.nBits + header.nonce;
		concatHeader = header.toMakeHash() + this.toMakeHash();
		String hashed = getSha256(getSha256(concatHeader, 64), 64);
		return hashed;
	}
	
}

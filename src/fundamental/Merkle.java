package fundamental;

import static engine.Sha.getSha256;

import java.util.ArrayList;
import java.util.List;

public class Merkle {
	private class Header{
		private class Input {
			private String previousOutput[] = new String[2];
			private String outpoint[] = new String[2]; // [1]: 32 bytes TXID; [2]: 4 bytes output index (vout)
			private String scriptSig;
			private int sequenceNumber;
			
			public Input(){
			}

			public String[] getPreviousOutput() {
				return previousOutput;
			}

			public void setPreviousOutput(String previousOutput[]) {
				this.previousOutput = previousOutput;
			}

			public String[] getOutpoint() {
				return outpoint;
			}

			public void setOutpoint(String outpoint[]) {
				this.outpoint = outpoint;
			}

			public String getScriptSig() {
				return scriptSig;
			}

			public void setScriptSig(String scriptSig) {
				this.scriptSig = scriptSig;
			}

			public int getSequenceNumber() {
				return sequenceNumber;
			}

			public void setSequenceNumber(int sequenceNumber) {
				this.sequenceNumber = sequenceNumber;
			}
			
		}
		private class Output{
			private double satoshis;
			private String scriptPubKey;
			
			public Output(){
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
			
			
		}
		
		private int version = 1; // 4 bytes
		private int tx_in_count;
		private List<Input> tx_in = new ArrayList<Input>();
		private int tx_out_count;
		private List<Output> tx_out = new ArrayList<Output>();
		private long lock_time;
	}
	
	private String hash;
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
	
	private String makeHash(){
		String concatHeader = null;//= header.version + header.previousBlockHash + header.root + header.timestamp + header.nBits + header.nonce;
		String hashed = getSha256(getSha256(concatHeader, 64), 64);
		return hashed;
	}
	
}

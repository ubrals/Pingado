package core;

public class Transaction {
	String txid;
	double satoshis;
	
	public Transaction() {
		super();
	}

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public double getSatoshis() {
		return satoshis;
	}

	public void setSatoshis(double satoshis) {
		this.satoshis = satoshis;
	}
	
	public String toMakeHash(){
		return this.getTxid() + this.getSatoshis();
	}
}

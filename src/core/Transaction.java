package core;

public class Transaction {
	String txid;
	double satoshis;
	byte coinbase[] = new byte[100];
	
	public Transaction() {
	}
	
	public Transaction(String txid, double satoshis){
		this.setTxid(txid);
		this.setSatoshis(satoshis);
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
	
	public byte[] getCoinbase() {
		return coinbase;
	}
	
	public void setCoinbase(byte[] coinbase) {
		this.coinbase = coinbase;
	}
	public String toMakeHash(){
		return this.getTxid() + this.getSatoshis();
	}
}

package core;

import java.util.ArrayList;
import java.util.List;

import utils.Conversions;
import static utils.Conversions.*;

//import core.Merkle.Header.Input;
//import core.Merkle.Header.Output;

public class Transaction {
    //////////////
    //Header
    private class Header{
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
        private byte[] version = new byte[]{49, 48, 48, 48}; // 4 bytes
        private int tx_in_count;
        private int tx_out_count;
        private byte[] lock_time = new byte[4];
        
        private Header(){
            tx_in_count = 0;
            tx_out_count = 0;
        }
        
        private Header(byte[] version){
            this.setVersion(version);
            tx_in_count = 0;
            tx_out_count = 0;
        }
        
        private byte[] getVersion() {
            return version;
        }
        
        private void setVersion(byte[] version) {
            this.version = version;
        }
        
        private int getTx_in_count() {
            return tx_in_count;
        }
        
        private void incrementTx_in_count() {
            this.tx_in_count++;
        }
        
        private int getTx_out_count() {
            return tx_out_count;
        }
        
        private void incrementTx_out_count() {
            this.tx_out_count++;
        }
        
        private byte[] getLock_time() {
            return lock_time;
        }
        
        private void setLock_time(byte[] lock_time) {
            this.lock_time = lock_time;
        }
        
        private String toMakeHash(){
            String ret;
            ret =  String.valueOf(this.getVersion());
            ret += String.valueOf(this.getTx_in_count());
            for(int i=0; i<tx_in.size(); i++)
                ret += tx_in.get(i).toMakeHash();
            ret += String.valueOf(this.getTx_out_count());
            for(int o=0; o<tx_out.size(); o++)
                ret += tx_out.get(o).toMakeHash();
            ret += this.getLock_time();
            
            return ret;
        }
    }
    //Header end
    //////////////
    
    /*****
     * 
     * @author ubrals
     * Transaction's header was set to be a nested and private class, in order to (como é que chama aquela porra de APD3 mesmo?!??!)
     * and encapsulation.
     * 
     * Input and Output were set as nested classes in order to(como é que chama aquela porra de APD3 mesmo?!??!)
     * and encapsulation.
     */
    ////////////
    // Input
    private class Input {
        /*****
         * 
         * @param previousOutpointHash // Composition of previousOutput
         * @param previousOutpointIndex // Composition of previousOutput
         * 
         * 
         */
        private byte[] previousOutpointHash = new byte[32];
        private byte[] previousOutpointIndex = new byte[4];
        private byte[] previousOutput = new byte[36];
        private byte[] scriptBytes = new byte[2]; // Arbitrarily defined as 2 bytes
        private byte[] scriptSig = new byte[10000];
        private int sequenceNumber;
        
        private Input(){
        }
        
        private Input(byte[] previousOutpointHash, byte[] previousOutpointIndex, byte[] scriptBytes, byte[] scriptSig){
            this.setPreviousOutpointHash(previousOutpointHash);
            this.setPreviousOutpointIndex(previousOutpointIndex);
            this.setScriptBytes(scriptBytes);
            this.setScriptSig(scriptSig);
            this.setSequenceNumber(0);
        }
        
        private byte[] getPreviousOutpointHash() {
            return previousOutpointHash;
        }
    
        private void setPreviousOutpointHash(byte[] previousOutpointHash) {
            this.previousOutpointHash = previousOutpointHash;
        }
    
        private byte[] getPreviousOutpointIndex() {
            return previousOutpointIndex;
        }
    
        private void setPreviousOutpointIndex(byte[] previousOutpointIndex) {
            this.previousOutpointIndex = previousOutpointIndex;
        }
    
        public byte[] getScriptBytes() {
            return scriptBytes;
        }
    
        public void setScriptBytes(byte[] scriptBytes) {
            this.scriptBytes = scriptBytes;
        }
        
        private byte[] getScriptSig() {
            return scriptSig;
        }
        
        private void setScriptSig(byte[] scriptSig) {
            this.scriptSig = scriptSig;
        }
    
        private int getSequenceNumber() {
            return sequenceNumber;
        }
    
        private void setSequenceNumber(int sequenceNumber) {
            this.sequenceNumber = sequenceNumber;
        }
        
        private String toMakeHash(){
            return Conversions.byteToString(this.getPreviousOutpointHash())
                 + Conversions.byteToString(this.getPreviousOutpointIndex())
                 + Conversions.byteToString(this.getScriptSig())
                 + this.getSequenceNumber();
        }
    }

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

    private Header header;
    private String txid;
    private double satoshis;
    private byte coinbase[] = new byte[100];
    private List<Input> tx_in = new ArrayList<Input>();
    private List<Output> tx_out = new ArrayList<Output>();
    
    public Transaction() {
        header = new Header();
        txid = null;
        satoshis = 0.0;
    }
    
    public Transaction(String txid, double satoshis){
        this.setTxid(txid);
        this.setSatoshis(satoshis);
    }
    
    private Header getHeader(){
        return header;
    }
    
    public byte[] getVersion(){
        return this.getHeader().getVersion();
    }
    
    public int getTx_in_count(){
        return this.getHeader().getTx_in_count();
    }
    
    public List<Byte> getTx_in() {
        List tx_in = new ArrayList<Byte>();
        for(Input in : this.tx_in){
            // TODO: refazer
            tx_in.add(in.getPreviousOutpointHash());
        }
        return tx_in;
    }
    
    public void addTx_in(String s_satoshis, String pubkeyScriptSig, String txid, String scriptSig){
        Input tx_in = new Input(Conversions.stringToByte(s_satoshis)
                              , Conversions.stringToByte(pubkeyScriptSig)
                              , Conversions.stringToByte(txid)
                              , Conversions.stringToByte(scriptSig));
        this.tx_in.add(tx_in);
        this.getHeader().incrementTx_in_count();
    }
    
    public int getTx_out_count(){
        return this.getHeader().getTx_out_count();
    }
    
    public List<Byte> getTx_out() {
        List tx_out = new ArrayList<Byte>();
        for(Output out : this.tx_out){
            // TODO: refazer
            tx_out.add(out.getPreviousOutpointHash());
        }
        return tx_in;
    }
    
    public void addTx_in(String s_satoshis, String pubkeyScriptSig, String txid, String scriptSig){
        Output tx_out = new Output();
        Conversions.stringToByte(s_satoshis)
                              , Conversions.stringToByte(pubkeyScriptSig)
                              , Conversions.stringToByte(txid)
                              , Conversions.stringToByte(scriptSig));
        this.tx_out.add(tx_out);
        this.getHeader().incrementTx_out_count();
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
        String ret = this.getTxid() + this.getSatoshis() + byteToString(this.getCoinbase())
                   + this.getHeader().toMakeHash();
                
        return ret;
	}
}

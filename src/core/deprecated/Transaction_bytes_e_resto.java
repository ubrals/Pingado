package core.deprecated;

import java.util.ArrayList;
import java.util.List;

import static utils.ConversionsNew.*;

//import utils.Conversions;
//import static utils.Conversions.*;

//import core.Merkle.Header.Input;
//import core.Merkle.Header.Output;

public class Transaction_bytes_e_resto {
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
         * 
         */
        private byte[] version = new byte[]{49, 48, 48, 48}; // 4 bytes
        private byte[] tx_in_count  = new byte[4];
        private byte[] tx_out_count = new byte[4];
        private byte[] lock_time = new byte[4];
        
        private Header(){
            tx_in_count = new byte[]{48, 48, 48, 48};
            tx_out_count = new byte[]{48, 48, 48, 48}; 
        }
        
        private Header(byte[] version){
            this.setVersion(version);
            tx_in_count = new byte[]{48, 48, 48, 48};
            tx_out_count = new byte[]{48, 48, 48, 48}; 
        }
        
        private byte[] getVersion() {
            return version;
        }
        
        private void setVersion(byte[] version) {
            this.version = version;
        }
        
        private byte[] getTx_in_count() {
            return tx_in_count;
        }
        
        private void incrementTx_in_count() {
//            System.out.println("***>incrementTx_in_count:tx_in_count:="+ConversionsNew.hexToDecInternalByteOrder(byteToString(tx_in_count)));
            long counter = byteArrayEvenToDecInternalByteOrder(tx_in_count);
            counter++;
//            System.out.println("incrementTx_in_count:counter:="+counter);
//            if(counter%10 == counter) // TODO: completar bytes nulos
//                counter=10+counter;
            
            tx_in_count = decToByteArrayEvenInternalByteOrder(counter);
//            System.out.println("<<**incrementTx_in_count:tx_in_count:="+byteToString(tx_in_count));
//            System.out.println(hexToDecInternalByteOrder(byteToString(tx_in_count)));
        }
        
        private byte[] getTx_out_count() {
            return tx_out_count;
        }
        
        private void incrementTx_out_count() {
            long counter = byteArrayEvenToDecInternalByteOrder(tx_out_count);
            counter++;
            tx_out_count = decToByteArrayEvenInternalByteOrder(counter);
        }
        
        private byte[] getLock_time() {
            return lock_time;
        }
        
        private void setLock_time(byte[] lock_time) {
            this.lock_time = lock_time;
        }
        
        private String toMakeHash(){
            String ret;
            ret =  toStringByteArray(this.getVersion(), 'c', "");
            ret += toStringByteArray(this.getTx_in_count(), 'c', "");
            ret += toStringByteArray(this.getTx_out_count(), 'c', "");
            ret += toStringByteArray(this.getLock_time(), 'c', "");
            
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
         * @param previousOutput // TODO: provavekmente desnecessario. consultar Doc
         * @param scriptBytes // Number of bytes at scriptSig (probably) TODO: Verify if it's true
         * @param scriptSig // Script that allows spending satoshis
         * @param sequenceNumber // Sequence number of the transacition
         * 
         */
        private byte[] previousOutpointHash = new byte[32];
        private byte[] previousOutpointIndex = new byte[4];
        private byte[] previousOutput = new byte[36];
        private byte[] scriptBytes = new byte[2]; // Arbitrarily defined as 2 bytes
        private byte[] scriptSig = new byte[10000];
        private byte[] sequenceNumber = new byte[2]; // Arbitrarily defined as 2 bytes
        
        private Input(){
        }
        
        /*****
         * 
         * @param previousOutpointHash
         * @param previousOutpointIndex
         * @param scriptBytes
         * @param scriptSig
         * 
         */
        private Input(byte[] previousOutpointHash, byte[] previousOutpointIndex, byte[] scriptBytes, byte[] scriptSig){
            this.setPreviousOutpointHash(previousOutpointHash);
            this.setPreviousOutpointIndex(previousOutpointIndex);
            this.setScriptBytes(scriptBytes);
            this.setScriptSig(scriptSig);
            this.setSequenceNumber(new byte[]{48, 48, 48, 48});
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
    
        private byte[] getPreviousOutput() {
            return previousOutput;
        }

        private void setPreviousOutput(byte[] previousOutput) {
            this.previousOutput = previousOutput;
        }

        private byte[] getScriptBytes() {
            return scriptBytes;
        }
    
        private void setScriptBytes(byte[] scriptBytes) {
            this.scriptBytes = scriptBytes;
        }
        
        private byte[] getScriptSig() {
            return scriptSig;
        }
        
        private void setScriptSig(byte[] scriptSig) {
            this.scriptSig = scriptSig;
        }
    
        private byte[] getSequenceNumber() {
            return sequenceNumber;
        }
    
        private void setSequenceNumber(byte[] sequenceNumber) {
            this.sequenceNumber = sequenceNumber;
        }
        
        private String toMakeHash(){
            return toStringByteArray(this.getPreviousOutpointHash(), 'c', "")
                 + toStringByteArray(this.getPreviousOutpointIndex(), 'c', "")
                 + toStringByteArray(this.getScriptSig(), 'c', "")
                 + toStringByteArray(this.getSequenceNumber(), 'c', "");
        }
    }

    ////////////
    // Output
    private class Output{
        private byte[] satoshis = new byte[16];
        private byte[] scriptPubKey = new byte[10000];
        
        private Output(){
        }
        
        private Output(byte satoshis[], byte[] scriptPubKey){
            this.setSatoshis(satoshis);
            this.setScriptPubKey(scriptPubKey);
        }
        
        private byte[] getSatoshis() {
            return satoshis;
        }
    
        private void setSatoshis(byte satoshis[]) {
            this.satoshis = satoshis;
        }
    
        private byte[] getScriptPubKey() {
            return scriptPubKey;
        }
    
        private void setScriptPubKey(byte[] scriptPubKey) {
            this.scriptPubKey = scriptPubKey;
        }
        
        private String toMakeHash(){
            return toStringByteArray(this.getSatoshis(), 'c', "")
                 + toStringByteArray(this.getScriptPubKey(), 'c', "");
        }
    }

    private Header header;
    private byte[] txid;
    private byte[] satoshis = new byte[16];
    private byte[] coinbase = new byte[100];
    private List<Input> tx_in = new ArrayList<Input>();
    private List<Output> tx_out = new ArrayList<Output>();
    
    public Transaction_bytes_e_resto() {
        header = new Header();
        txid = null;
        satoshis = new byte[]{48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48};
    }
    
    public Transaction_bytes_e_resto(byte[] txid, byte[] satoshis){
        this.setTxid(txid);
        this.setSatoshis(satoshis);
    }
    
    private Header getHeader(){
        return header;
    }
    
    public byte[] getVersion(){
        return this.getHeader().getVersion();
    }
    
    public byte[] getTx_in_count(){
        return this.getHeader().getTx_in_count();
    }
    
    public List<Byte> getTx_in() {
        List txscontents = new ArrayList<Byte[]>();
        for(Input in : this.tx_in){
            // TODO: refazer
            txscontents.add(in.getPreviousOutpointHash());
            txscontents.add(in.getPreviousOutpointIndex());
            txscontents.add(in.getPreviousOutput());
            txscontents.add(in.getScriptBytes());
            txscontents.add(in.getScriptSig());
            txscontents.add(in.getSequenceNumber());
        }
        return txscontents;
    }
    
    public void addTx_in2(byte[] s_satoshis, byte[] pubkeyScriptSig, byte[] txid, byte[] scriptSig){
        Input tx_in = new Input(s_satoshis
                              , pubkeyScriptSig
                              , txid
                              , scriptSig);
        this.tx_in.add(tx_in);
        this.getHeader().incrementTx_in_count();
    }
    
    public void addTx_in(String s_satoshis, String pubkeyScriptSig, String txid, String scriptSig){
        Input tx_in = new Input(stringToByteArray(s_satoshis)
                              , stringToByteArray(pubkeyScriptSig)
                              , stringToByteArray(txid)
                              , stringToByteArray(scriptSig));
        this.tx_in.add(tx_in);
        this.getHeader().incrementTx_in_count();
    }
    
    public byte[] getTx_out_count(){
        return this.getHeader().getTx_out_count();
    }
    
    public List<Byte[]> getTx_out() {
        List txscontents = new ArrayList<Byte[]>();
        for(Output out : this.tx_out){
            // TODO: refazer
            txscontents.add(out.getSatoshis());
            txscontents.add(out.getScriptPubKey());
        }
        return txscontents;
    }
    
    public void addTx_out(byte[] satoshis, byte[] scriptPubKey){
        Output tx_out = new Output();
        tx_out = new Output(satoshis
                          , scriptPubKey);
        
        this.tx_out.add(tx_out);
        this.getHeader().incrementTx_out_count();
    }
    
    public byte[] getTxid() {
        return txid;
    }
    
    public void setTxid(byte[] txid) {
        this.txid = txid;
    }
    
    public byte[] getSatoshis() {
        return satoshis;
    }
    
    public void setSatoshis(byte satoshis[]) {
        this.satoshis = satoshis;
    }
    
    public byte[] getCoinbase() {
        return coinbase;
    }
    
    public void setCoinbase(byte[] coinbase) {
        this.coinbase = coinbase;
    }
    
    public String toMakeHash(){
        String ret = this.getTxid() + toStringByteArray(this.getSatoshis(), 'c', "")
                   + toStringByteArray(this.getCoinbase(), 'i', "") + "  ___ + ____ "
                   + this.getHeader().toMakeHash();
        //for(int i=0; i<tx_in.size(); i++)
        String smax = toStringByteArray(this.getHeader().getTx_in_count(), 'c', "");
        System.out.println(":" + toStringByteArray(this.getHeader().getTx_in_count(), 'c', "") + ":" + smax.length());
        long lmax = Long.valueOf(right(smax, smax.length()-1));
        int imax = (int)(lmax);
        System.out.println(":" + imax + ":");
//                counter++;
//                tx_in_count = decToHexInternalByteOrderArray(counter);
        for(int i=0; i<imax; i++)
            ret += tx_in.get(i).toMakeHash();
        //for(int o=0; o<tx_out.size(); o++)
        for(int o=0; o<Integer.valueOf(toStringByteArray(this.getHeader().getTx_in_count(), 'i', "")); o++)
            ret += tx_out.get(o).toMakeHash();

        return ret;
	}
}

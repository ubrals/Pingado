package core;

import java.util.ArrayList;
import java.util.List;

public class Merkle {
    /*****
     * 
     * @author ubrals
     * {@link} https://bitcoin.org/en/developer-reference#merkle-trees
     * Merkle tree that holds the transactions in the block
     *
     * @param hash
     * @param transactions
     */
    private byte[] hash = new byte[32];
    private List<Transaction> transactions = new ArrayList<Transaction>();
    
    ////////////
    // Methods
    public Merkle(){
    }
    
    public byte[] getHash() {
        return hash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }
    
    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }


}

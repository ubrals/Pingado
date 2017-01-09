import core.Transaction;
import static utils.Coinbase.generateCoinbase;
import static utils.Sha.getSha256InternalByteOrder;

public class runTestA {

    public static void main(String[] args) {
        Transaction tx0;
        tx0 = new Transaction();
        
        tx0.setCoinbase(generateCoinbase());
        tx0.setSatoshis(new byte[]{49});
        tx0.setTxid(getSha256InternalByteOrder("tx0_id", 32));
        
        tx0.addTx_in("100000000", getSha256InternalByteOrder("tx0_scriptSig", 32), tx0.getTxid(), getSha256InternalByteOrder("tx0_in", 16));
        
        System.out.println(tx0.toMakeHash());
    }

}

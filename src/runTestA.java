import core.Transaction;

import static utils.Coinbase.generateCoinbase;
import static utils.Sha.getSha256InternalByteOrder;
import static utils.ConversionsNew.*;

public class runTestA {

    public static void main(String[] args) {
        Transaction tx0;
        tx0 = new Transaction();
        
        tx0.setCoinbase(generateCoinbase());
        tx0.setSatoshis(zeroFillByteArray(new byte[]{49}, 8, 'r'));
        tx0.setTxid(getSha256InternalByteOrder("tx0_id", 32));
        
        tx0.addTx_in("100000000"
                    , getSha256InternalByteOrder("tx0_scriptSig", 32)
                    , tx0.getTxid()
                    , getSha256InternalByteOrder("tx0_in", 16));
        System.out.println("tx0.toMakeHash:"+tx0.toMakeHash());
        
        
        Transaction tx1;
        tx1 = new Transaction();
        
        tx1.setCoinbase(null);
        
    }
}

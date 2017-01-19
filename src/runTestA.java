import core.Transaction;
import utils.Sha;

import static utils.Coinbase.generateCoinbase;
import static utils.Sha.getSha256InternalByteOrder;
import static utils.ConversionsNew.*;

public class runTestA {

    public static void main(String[] args) {
        Transaction tx0;
        tx0 = new Transaction();
        
        tx0.setCoinbase(generateCoinbase());
        tx0.setSatoshis(zeroFillByteArray(new byte[]{49}, 8, 'r'));
        tx0.setTxid(stringToByteArray(getSha256InternalByteOrder("tx0_id", 32)));
        
        tx0.addTx_in("100000000"
                    , getSha256InternalByteOrder("tx0_scriptSig", 32)
                    , toStringByteArray(tx0.getTxid(), 'c', "")
                    , getSha256InternalByteOrder("tx0_in", 16));
        //System.out.println("tx0.toMakeHash:"+tx0.toMakeHash());
        tx0.addTx_in2(zeroFillByteArray(new byte[]{49}, 8, 'r')
                    , stringToByteArray(getSha256InternalByteOrder("tx0_scriptSig", 32))
                    , tx0.getTxid()
                    , stringToByteArray(getSha256InternalByteOrder("tx0_in", 16)));
        
        
        Transaction tx1;
        tx1 = new Transaction();
        tx1.setCoinbase(null);
        tx1.setSatoshis(new byte[]{48, 48, 48, 49, 53, 52, 48, 48, 48});
        tx1.setTxid(stringToByteArray(Sha.getSha256InternalByteOrder(toStringByteArray(tx0.getTxid(),'c', ""), 32)));
        
        tx1.setCoinbase(null);
        
    }
}

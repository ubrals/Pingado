import utils.Sha;

import static utils.Coinbase.generateCoinbase;
import static utils.Sha.getSha256InternalByteOrder;

import core.deprecated.Transaction_bytes_e_resto;

import static utils.ConversionsNew.*;

public class runTestA {

    public static void main(String[] args) {
        Transaction_bytes_e_resto tx0;
        tx0 = new Transaction_bytes_e_resto();
        
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
        
        
        Transaction_bytes_e_resto tx1;
        tx1 = new Transaction_bytes_e_resto();
        tx1.setCoinbase(null);
        tx1.setSatoshis(new byte[]{48, 48, 48, 49, 53, 52, 48, 48, 48});
        tx1.setTxid(stringToByteArray(Sha.getSha256InternalByteOrder(toStringByteArray(tx0.getTxid(),'c', ""), 32)));
        
        tx1.setCoinbase(null);
        
    }
}

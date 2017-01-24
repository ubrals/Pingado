import core.Block;
import core.Transaction;
import utils.Coinbase;
import utils.ConversionsNew;
import utils.Sha;

import static utils.ConversionsNew.*;


public class runTestC {
    
    public static void main(String[] args) {
        Transaction tx0 = coinbaseTransaction();
        Transaction tx1;
        String s_txid1 = "transaction id 1";
        long l_satoshis = 1275309003l;
        String pubKey;
        
        String sha_txid1 = Sha.getSha256InternalByteOrder(s_txid1, 32);
        byte[] bc_txid1 = stringToByteArray(sha_txid1);
        
        byte[] b_satoshis = decToByteArrayEvenInternalByteOrder(l_satoshis);
        
        tx1 = new Transaction();
        tx1.setCoinbase(null);
        tx1.setTxid(bc_txid1);
//        tx1.setSatoshis(b_satoshis);
        tx1.setSatoshis(tx0.getSatoshis());
//        tx1.addTx_in(b_satoshis, pubkeyScriptSig, txid, scriptSig);
        
        
        Block bl0;
        bl0 = new Block();
        bl0.addTransaction(tx0);
        bl0.addTransaction(tx1);
        
    }
    
    static Transaction coinbaseTransaction(){
        Transaction txcb;
        txcb = new Transaction();
        txcb.setCoinbase(Coinbase.generateCoinbase());
        txcb.setSatoshis(decToByteArrayEvenInternalByteOrder(100000000l));
//        txcb.setSatoshis(zeroFillByteArray(new byte[]{49}, 8, 'r'));
        txcb.setTxid(stringToByteArray(
                        Sha.getSha256InternalByteOrder("transaction id coinbase", 32)
                      )
                    );
        return txcb;
    }

}

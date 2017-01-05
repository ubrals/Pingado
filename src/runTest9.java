import core.Transaction;
import utils.Conversions;

import static utils.Coinbase.generateCoinbase;
import static utils.Conversions.*;
public class runTest9 {

    public static void main(String[] args) {
        Transaction transaction0;
        transaction0 = new Transaction();
        
        transaction0.setCoinbase(generateCoinbase());
        transaction0.setSatoshis(1);
        transaction0.setTxid("transaction0_id");
        transaction0.addTx_in("1.0", "transaction0_pubkeyScriptSig", "txid", "scriptSig");

        System.out.print  ("Satoshis: " + Conversions.left(String.valueOf(Conversions.hexToDecInternalByteOrder("f0ca052a01000000")), 2) + ".");
        System.out.println(Conversions.right(String.valueOf(Conversions.hexToDecInternalByteOrder("f0ca052a01000000")), 8) + " BTC");
        System.out.println();
        String s_satoshis = Conversions.decToHexInternalByteOrder(1415239972l);
        System.out.println("$" + s_satoshis.length() + "BTC");
        byte array[] = utils.Conversions.stringToByte(utils.Conversions.decToHexInternalByteOrder(1415239972l));
        for(byte b1 : array)
            System.out.print((char)b1 + " ");
        System.out.println("BTC");
        
        System.out.println("Satoshis: " + Conversions.hexToDecInternalByteOrder("24d95a54") + " BTC");
        System.out.println("Satoshis: " + String.valueOf(Conversions.hexToDecInternalByteOrder("24d95a54")) + " BTC");
        System.out.print  ("Satoshis: " + Conversions.left(String.valueOf(Conversions.hexToDecInternalByteOrder("24d95a54")), 2) + ".");
        System.out.println(Conversions.right(String.valueOf(Conversions.hexToDecInternalByteOrder("24d95a54")), 8) + " BTC");
        
        System.out.println("Satoshis: " + Conversions.decToHexInternalByteOrder(1415239972l) + " BTC");
        System.out.println("Satoshis: " + String.valueOf(Conversions.decToHexInternalByteOrder(1415239972l)) + " BTC");
        System.out.print  ("Satoshis: " + Conversions.left(String.valueOf(Conversions.decToHexInternalByteOrder(1415239972l)), 2) + ".");
        System.out.println(Conversions.right(String.valueOf(Conversions.decToHexInternalByteOrder(1415239972l)), 8) + " BTC");
        
        System.out.println("Satoshis: " + Conversions.decToHex(123456700l) + " BTC");
        System.out.println("Satoshis: " + Conversions.decToHexInternalByteOrder(123456700l) + " BTC");
//        System.out.println("Satoshis: " + String.valueOf(Conversions.decToHexInternalByteOrder(100000000l)) + " BTC");
//        System.out.print  ("Satoshis: " + Conversions.left(String.valueOf(Conversions.decToHexInternalByteOrder(100000000l)), 2) + ".");
//        System.out.println(Conversions.right(String.valueOf(Conversions.decToHexInternalByteOrder(100000000l)), 8) + " BTC");

        
        for(byte b : transaction0.getCoinbase())
            System.out.print((b & 0xff) + " ");
        System.out.println();
        
        for(byte b : transaction0.getCoinbase())
            System.out.print((char)Math.abs(b));
        System.out.println();
        System.out.println(transaction0.toMakeHash());
        
//        for (int i=0x2500;i<=0x257F;i++)
//        {
//            System.out.printf("%d=0x%x : %c\n",i, i,(char)i);
//        }
//        for (int i=0x0000;i<=0x1111;i++)
//        {
//            System.out.printf("%d=0x%x : %c\n",i, i,(char)i);
//        }
        
    }

}

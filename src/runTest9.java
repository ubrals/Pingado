import static utils.Coinbase.generateCoinbase;
import static utils.Conversions.*;

import core.deprecated.Transaction_bytes_e_resto;
public class runTest9 {

    public static void main(String[] args) {
        Transaction_bytes_e_resto transaction0;
        transaction0 = new Transaction_bytes_e_resto();
        
        transaction0.setCoinbase(generateCoinbase());
        transaction0.setSatoshis(new byte[]{(byte)49});
//        transaction0.setTxid("transaction0_id");
        transaction0.addTx_in("1.0", "transaction0_pubkeyScriptSig", "txid", "scriptSig");

        System.out.print  ("Satoshis: " + left(String.valueOf(hexToDecInternalByteOrder("f0ca052a01000000")), 2) + ".");
        System.out.println(right(String.valueOf(hexToDecInternalByteOrder("f0ca052a01000000")), 8) + " BTC");
        System.out.println();
//        String s_satoshis = Conversions.decToHexInternalByteOrder(100000000l);
//        System.out.println("$" + s_satoshis + " BTC");
//        byte array[] = utils.Conversions.stringToByte(utils.Conversions.decToHexInternalByteOrder(100000000l));
//        for(byte b1 : array)
//            System.out.print((char)b1);
//        System.out.println(" BTC");
        
        
        System.out.println("Satoshis: " + String.valueOf(decToHexInternalByteOrder(100000000l)) + " BTC");
        System.out.print  ("Satoshis: " + left(String.valueOf(decToHexInternalByteOrder(100000000l)), 2) + ".");
        System.out.println(right(String.valueOf(decToHexInternalByteOrder(100000000l)), 8) + " BTC");
        
        System.out.println("Satoshis: " + String.valueOf(hexToDecInternalByteOrder("00e1f505")) + " BTC");
        System.out.print  ("Satoshis: " + left(String.valueOf(hexToDecInternalByteOrder("00e1f505")), 1) + ".");
        System.out.println(right(String.valueOf(hexToDecInternalByteOrder("00e1f505")), 8) + " BTC");
        
        int n=0x10;
        n=010;
        
        System.out.printf("%d", n-1);
        
//        for(byte b : transaction0.getCoinbase())
//            System.out.print((b & 0xff) + " ");
//        System.out.println();
//        
//        for(byte b : transaction0.getCoinbase())
//            System.out.print((char)Math.abs(b));
//        System.out.println();
//        System.out.println(transaction0.toMakeHash());
        
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

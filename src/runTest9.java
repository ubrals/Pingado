import core.Transaction;
import static utils.Coinbase.generateCoinbase;
import static utils.Conversions.*;
public class runTest9 {

    public static void main(String[] args) {
        Transaction transaction0;
        transaction0 = new Transaction();
        transaction0.setCoinbase(generateCoinbase());
        
        
        for(byte b : transaction0.getCoinbase())
            System.out.print((b & 0xff) + " ");
        System.out.println();
        
        for(byte b : transaction0.getCoinbase())
            System.out.print((char)Math.abs(b));
        System.out.println();
        System.out.println(transaction0.toMakeHash());
    }

}

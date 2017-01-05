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
        
        for (int i=0x2500;i<=0x257F;i++)
        {
            System.out.printf("%d=0x%x : %c\n",i, i,(char)i);
        }
        for (int i=0x0000;i<=0x1111;i++)
        {
            System.out.printf("%d=0x%x : %c\n",i, i,(char)i);
        }

    }

}

import static utils.Coinbase.generateCoinbase;
import static utils.Conversions.byteToString;

import java.time.Instant;

import utils.Conversions;

public class runTest8 {

	public static void main(String[] args) {
		byte key[] = generateCoinbase();
		long secs_year = 60*60*24*365;
		long ys970_140 = 2140-1970;
		long secs_2140 = secs_year*ys970_140 +secs_year +((42*(60*60*24))-1);
		
		System.out.println(java.time.Instant.now().getEpochSecond() );
		System.out.println(java.time.Instant.EPOCH + " " + Instant.ofEpochSecond(secs_year*ys970_140+secs_year));
		System.out.println(secs_2140 + ": " + Instant.ofEpochSecond(secs_2140));
		
		byte max = Byte.MAX_VALUE;
		byte min = Byte.MIN_VALUE;
		System.out.println(max + " " + min + " " + Byte.SIZE + " " + (byte)128);
		
		byte b = (byte)(0xff);
		System.out.println(b);
		int i = (int)b;
		System.out.println(i);
		
//		 b = (byte)(0xff);
		 b = (byte)(0x01);
		 i = (b & 0xff); // mask of rightmost 8 bits
		System.out.println(i + " " + java.time.Instant.now().getEpochSecond());
		System.out.println(utils.Conversions.decToHex(1415239972l));
		System.out.println(utils.Conversions.decToHexInternalByteOrder(1415239972l));
		byte array[] = utils.Conversions.stringToByte(utils.Conversions.decToHexInternalByteOrder(1415239972l));
		for(byte b1 : array)
			System.out.print((char)b1 + " ");
		System.out.println();
		System.out.println(Conversions.hexToDecInternalByteOrder(Conversions.byteToString(array)));
		System.out.println(utils.Conversions.hexToDec("24d95a54"));
		System.out.println();
        for(byte bk : key){
            System.out.print(bk + " ");
        }
        System.out.println();
        for(byte bk : key){
            System.out.print((int)(bk & 0xff) + " ");
        }
        System.out.println();
        for(byte bk : key){
            System.out.print((char)(bk & 0xff) + " ");
        }
        System.out.println();
        System.out.println(Integer.MIN_VALUE);
        System.out.println();
        System.out.println("Satoshis: " + Conversions.hexToDecInternalByteOrder("f0ca052a01000000") + " BTC");
        System.out.println("Satoshis: " + String.valueOf(Conversions.hexToDecInternalByteOrder("f0ca052a01000000")) + " BTC");
        System.out.print  ("Satoshis: " + Conversions.left(String.valueOf(Conversions.hexToDecInternalByteOrder("f0ca052a01000000")), 2) + ".");
        System.out.println(Conversions.right(String.valueOf(Conversions.hexToDecInternalByteOrder("f0ca052a01000000")), 8) + " BTC");
	}
}

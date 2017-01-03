import java.math.BigInteger;

import deprecated.Block_old;

public class runTest2 extends runTest {

	public static void main(String[] args) {
		Block_old block = new Block_old(4, "1aef899acd834", "278ef9340cfd7b", java.time.Instant.now().getEpochSecond(), 938938l, 0l, "1000aaabb", new Block_old());
		
//		System.out.println("Format");
//		System.out.println(block.getTimestamp());
//		System.out.println(String.format("d:%d", new BigInteger(1, String.valueOf(block.getTimestamp()).getBytes())));
//		System.out.println(String.format("h:%h", new BigInteger(1, String.valueOf(block.getTimestamp()).getBytes())));
//		System.out.println(String.format("x:%x", new BigInteger(1, String.valueOf(block.getTimestamp()).getBytes())));
//		System.out.println(2834l);
//		System.out.println(String.format("d:%d", new BigInteger(1, String.valueOf(tools.Conversions.decToHex(2834l)).getBytes())));
//		System.out.println(String.format("h:%h", new BigInteger(1, String.valueOf(tools.Conversions.decToHex(2834l)).getBytes())));
//		System.out.println(String.format("x:%x", new BigInteger(1, String.valueOf(tools.Conversions.decToHex(2834l)).getBytes())));
//		
//		System.out.println("");
		System.out.println("Conversao de base");
		System.out.println(block.getTimestamp());
		long timestamp = block.getTimestamp();
		System.out.println(":" + utils.Conversions.decToHex(block.getTimestamp()));
		String s_timestamp = utils.Conversions.decToHex(block.getTimestamp());
		System.out.println(2834l);
		System.out.println(":" + utils.Conversions.decToHex(2834l));
		System.out.println("convertido");
		
		System.out.println("");
		System.out.println("b12");
		System.out.println(utils.Conversions.hexToDec("b12"));
		System.out.println(s_timestamp);
		System.out.println(utils.Conversions.hexToDec(s_timestamp));
		
		System.out.println("");
		System.out.println("24d95a54");
		System.out.println(utils.Conversions.hexToDec("24d95a54"));
		System.out.println(1415239972l);
		System.out.println(utils.Conversions.decToHex(1415239972l));
		
		System.out.println("");
		System.out.println(block.getPreviousBlockHash().getHash());
		System.out.println(utils.Sha.getSha256(block.getPreviousBlockHash().getHash(), 64));
		System.out.println("1415239972");
		System.out.println(utils.Sha.getSha256("1415239972", 64));
		
		int hexa = 0xb12;
		System.out.printf("%d\n", hexa);
		String s_hexa = String.format("%x", hexa);
		System.out.println(s_hexa);
		System.out.printf("%x\n",hexa<<1);
		System.out.println(hexa & 0x00f);
		System.out.println(hexa & 0x111);
		System.out.println(hexa | 0xfff);
	}
}

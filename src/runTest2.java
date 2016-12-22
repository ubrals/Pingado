import java.math.BigInteger;

import fundamental.Block;

public class runTest2 extends runTest {

	public static void main(String[] args) {
		Block block = new Block(4, "1aef899acd834", "278ef9340cfd7b", java.time.Instant.now().getEpochSecond(), 938938l, 0l, "1000aaabb", new Block());
		
		System.out.println("Format");
		System.out.println(block.getTimestamp());
		System.out.println(String.format("d:%d", new BigInteger(1, String.valueOf(block.getTimestamp()).getBytes())));
		System.out.println(String.format("h:%h", new BigInteger(1, String.valueOf(block.getTimestamp()).getBytes())));
		System.out.println(String.format("x:%x", new BigInteger(1, String.valueOf(block.getTimestamp()).getBytes())));
		System.out.println(2834l);
		System.out.println(String.format("d:%d", new BigInteger(1, String.valueOf(tools.Conversions.decToHex(2834l)).getBytes())));
		System.out.println(String.format("h:%h", new BigInteger(1, String.valueOf(tools.Conversions.decToHex(2834l)).getBytes())));
		System.out.println(String.format("x:%x", new BigInteger(1, String.valueOf(tools.Conversions.decToHex(2834l)).getBytes())));
		
		System.out.println("");
		System.out.println("Conversao de base");
		System.out.println(block.getTimestamp());
		System.out.println(":" + tools.Conversions.decToHex(block.getTimestamp()));
		System.out.println(2834l);
		System.out.println(":" + tools.Conversions.decToHex(2834l));
		System.out.println("convertido");
	}
}

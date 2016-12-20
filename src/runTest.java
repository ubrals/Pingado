import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import fundamental.Block;

public class runTest {

	public static void main(String[] args) throws Exception {
		Block block = new Block(4, "1aef899acd834", "278ef9340cfd7b", java.time.Instant.now().getEpochSecond(), 938938l, 0l, "1000aaabb", new Block());
		
		System.out.println(String.format("%h", new BigInteger(1, block.getHash().getHash().getBytes())));
		System.out.println(String.format("%h", new BigInteger(1, String.valueOf(block.getTimestamp()).getBytes())));
		System.out.println(String.format("%x", new BigInteger(1, "a".getBytes())));//, String.valueOf(1415239972l).getBytes()));
		System.out.println(String.format("%h:%h", new BigInteger(1, "1".getBytes()), String.valueOf(1415239972l)));
		System.out.println("");
//		System.out.println(toHex(String.valueOf(1415239972l)));
//		System.out.println(hexadecimal(String.valueOf(1415239972l), "UTF-8"));
//		System.out.println(toHexString(String.valueOf(1415239972l).getBytes()));
		System.out.println("Conversao de base");
		System.out.println(":" + tools.Conversions.decToHex(block.getTimestamp()));
		System.out.println(":" + tools.Conversions.decToHex(2834l));
		System.out.println("convertido");
	}
	//
	// http://stackoverflow.com/questions/923863/converting-a-string-to-hexadecimal-in-java
	//
	public static String toHex(String arg) {
	    return String.format("%040x", new BigInteger(1, arg.getBytes(/*YOUR_CHARSET?*/)));
	}
	/////
	public static String hexadecimal(String input, String charsetName) throws UnsupportedEncodingException {
	    if (input == null) throw new NullPointerException();
	    return asHex(input.getBytes(charsetName));
	}
	private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
	public static String asHex(byte[] buf)
	{
	    char[] chars = new char[2 * buf.length];
	    for (int i = 0; i < buf.length; ++i)
	    {
	        chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
	        chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
	    }
	    return new String(chars);
	}
	/////
	public static String toHexString(byte[] ba) {
	    StringBuilder str = new StringBuilder();
	    for(int i = 0; i < ba.length; i++)
	        str.append(String.format("%x", ba[i]));
	    return str.toString();
	}
	public static String fromHexString(String hex) {
	    StringBuilder str = new StringBuilder();
	    for (int i = 0; i < hex.length(); i+=2) {
	        str.append((char) Integer.parseInt(hex.substring(i, i + 2), 16));
	    }
	    return str.toString();
	}
}

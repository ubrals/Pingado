package engine;

//http://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java

import java.security.MessageDigest;


public class Sha {
	public static String getSha256(String value) {
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(value.getBytes());
			return bytesToHex(md.digest());
			}
		 catch(Exception ex){
			 throw new RuntimeException(ex);
			 }
	}
	private static String bytesToHex(byte[] bytes) {
		StringBuffer result = new StringBuffer();
		for (byte byt : bytes)
			result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
		return result.toString();
	}
}

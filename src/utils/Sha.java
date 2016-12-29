package utils;

//http://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java

import java.security.MessageDigest;


public class Sha {
	public static String getSha256(String value, int len) {
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(value.getBytes());
			return bytesToHex(md.digest(), len);
			}
		 catch(Exception ex){
			 throw new RuntimeException(ex);
			 }
	}
	private static String bytesToHex(byte[] bytes, int len) {
		StringBuffer result = new StringBuffer();
		for (byte byt : bytes){
//			System.out.println("bth.byt:" + byt);
//			result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1)); // original
			switch(len){
			  case 32:
				result.append(Integer.toString((byt & 0xff) + 0x2, 16).substring(1));
				break;
			  case 64:
				result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1)); // original
				break;
			  case 96:
				result.append(Integer.toString((byt & 0xff) + 0xfff, 16).substring(1));
				break;
			  case 128:
				  result.append(Integer.toString((byt & 0xff) + 0xffff, 16).substring(1));
    			  break;
			  case 160:
				  result.append(Integer.toString((byt & 0xff) + 0xfffff, 16).substring(1));
    			  break;
    		  default:
  				result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1)); // original
  				break;
			}
		}
		return result.toString();
	}
}

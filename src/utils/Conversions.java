package utils;

public class Conversions {
	private static String decodeHex(int num){
		if(num > 9)
			switch(num){
				case 10: return "a";
				case 11: return "b";
				case 12: return "c";
				case 13: return "d";
				case 14: return "e";
				case 15: return "f";
			}
		return String.valueOf(num);
	}
	public static String decToHex(long num){
		long dividendo = num,
			 divisor = 16l,
			 produto = 0l,
			 resto = num;
		String retArray = "";
		
		//produto = dividendo / divisor;
		while(dividendo % divisor > 0l){
			produto = dividendo / divisor;
			resto = dividendo % divisor;
			dividendo = produto;
//			System.out.println("prod:" + produto + " " + "resto:" + resto);
			retArray = String.valueOf(decodeHex((int)resto)) + retArray;
		}
		
		return retArray;
	}
	public static String decToHexInternalByteOrder(long num){
		long dividendo = num,
			 divisor = 16l,
			 produto = 0l,
			 resto = num;
		String retArray = "";
		int db=0;
		String dch = "";
		
		//produto = dividendo / divisor;
		while(dividendo % divisor > 0l){
			produto = dividendo / divisor;
			resto = dividendo % divisor;
			dividendo = produto;
//			System.out.println("prod:" + produto + " " + "resto:" + resto);
			dch = String.valueOf(decodeHex((int)resto)) + dch;
			db++;
//			retArray = retArray + String.valueOf(decodeHex((int)resto));
			if(db == 2){
				retArray = retArray + dch;
				db = 0;
				dch = "";
			}
		}
		
		return retArray;
	}
	
	private static long decodeHex(char num){
		switch(num){
		case 'a':
		case 'A': return 10l;
		case 'b':
		case 'B': return 11l;
		case 'c':
		case 'C': return 12l;
		case 'd':
		case 'D': return 13l;
		case 'e':
		case 'E': return 14l;
		case 'f':
		case 'F': return 15l;
		}
		return Long.parseLong(String.valueOf(num));
	}
	public static long hexToDec(String num){
		int len = num.length()-1;
		long ret = 0l;
		
		for(int i = 0; i <= len; i++){
			char dig = num.charAt(i);
			ret += decodeHex(dig)*Math.pow(16, len-i);
		}
		return ret;
	}
	public static long hexToDecInternalByteOrder(String num){
		int len = num.length()-1;
		long ret = 0l;
		int ub = 0;
		String rev = "";
		
		for(int r=len; r>0; r-=2){
			rev += String.valueOf((char)num.charAt(r-1)) + String.valueOf((char)num.charAt(r));
		}
		System.out.println(rev + " " + num);
		for(int i = 0; i <= len; i++){
			char dig = rev.charAt(i);
			ret += decodeHex(dig)*Math.pow(16, len-i);
		}
		return ret;
	}
	
	public static String byteToString(byte[] bytes){
		String str = "";
		for(byte b : bytes)
			str += (char)(b & 0xff);
		return str;
	}
	
	public static int[] byteToArrayInt(byte[] bytes){
//		String str = "";
		int array[] = new int[bytes.length];
		int i = 0;
		for(byte b : bytes){
//			str += (char)b;
			array[i++] = (b & 0xff);
		}
		return array;
	}
	
	public static byte[] stringToByte(String str){
		byte bytes[] = new byte[str.length()];
		
		for(int i=0; i<str.length(); i++){
			bytes[i] = (byte) str.charAt(i);
		}
		return bytes;
	}
}

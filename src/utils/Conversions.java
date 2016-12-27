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
}

package tools;

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
}

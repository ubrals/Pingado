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
	public static String decToHexInternalByteOrder_old_1(long num){
		long dividendo = num,
			 divisor = 16l,
			 produto = 0l,
			 resto = num;
		String retArray = "";
		int db=0;
		String dch = "";
		
//      System.out.println("prod:" + produto + " " + "resto:" + resto);
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
    public static String decToHexInternalByteOrder_old_2(long num){
        String retArray = "";
        int db=0;
        String dch = "";
        String swap = decToHex(num);;
        
        if(swap.length()%2 != 0){
            swap = "0" + swap;
        }
        
        for(int i=0; i<swap.length()-1; i=i+2){
            retArray = String.valueOf(swap.charAt(i)) + String.valueOf(swap.charAt(i+1)) + retArray;
        }
        
        return retArray;
    }
    public static String decToHexInternalByteOrder(long num){
        String retArray = "";
        int db=0;
        String dch = "";
        String swap = String.format("%x", num);
        
        if(swap.length()%2 != 0){
            swap = "0" + swap;
        }
        
        for(int i=0; i<swap.length()-1; i=i+2){
            retArray = String.valueOf(swap.charAt(i)) + String.valueOf(swap.charAt(i+1)) + retArray;
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
	public static long hexToDecInternalByteOrder_old_1(String num){
		int len = num.length()-1;
		long ret = 0l;
		int ub = 0;
		String rev = "";
		
		for(int r=len; r>0; r-=2){
			rev += String.valueOf((char)num.charAt(r-1)) + String.valueOf((char)num.charAt(r));
		}
//		System.out.println(rev + " " + num);
		for(int i = 0; i <= len; i++){
			char dig = rev.charAt(i);
			ret += decodeHex(dig)*Math.pow(16, len-i);
		}
		return ret;
	}
    public static long hexToDecInternalByteOrder(String num){
        int len = num.length()-1;
        long ret = 0l;
        int ub = 0;
        String rev = "";
        
        System.out.println("num:" + num);
        for(int r=0; r<len; r+=2){
            rev = String.valueOf((char)num.charAt(r)) + String.valueOf((char)num.charAt(r+1)) + rev;
        }
        System.out.println("rev:" + rev);
//      System.out.println(rev + " " + num);
//        System.out.println("valueof:" + Long.valueOf(rev));
        if(rev.charAt(0) == '0')
            rev = rev.substring(1, rev.length());
        else
            rev = rev;
        System.out.println("rev:" + rev);
        
        for(int i = 0; i < rev.length(); i++){
            char dig = rev.charAt(i);
            ret += decodeHex(dig)*Math.pow(16, len-1);
        }
        System.out.println("ret:" + ret);
        
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
	
	public static String right(String word, int count){
	    String ret = "";
	    int len = word.length();
	    for(int i=0; i<count; i++){
	        ret = String.valueOf(word.charAt(len-1-i)) + ret;
	    }
	    
	    return ret;
	}
	
    public static String left(String word, int count){
        String ret = "";
        int len = word.length();
        for(int i=0; i<count; i++){
            ret = ret + String.valueOf(word.charAt(i));
        }
        
        return ret;
    }
}

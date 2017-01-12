package utils;

public class ConversionsNew {
    public static String decToHex(long num){
        String swap = Long.toHexString(num);
        
        if(swap.length()%2 != 0){
            swap = "0" + swap;
        }
        
        return swap;
    }
    public static long hexToDec(String num){
        long ret;
        if(num.charAt(0) == '0')
            ret = Long.valueOf(num.substring(1, num.length()));
        else
            ret = Long.parseUnsignedLong("0x"+ num, 16);
        
        return ret;
    }

    
    public static String decToHexInternalByteOrder(long num){
        String swap = decToHex(num);
        String retArray = "";
        
        for(int i=0; i<swap.length()-1; i=i+2){
            retArray = String.valueOf(swap.charAt(i)) + String.valueOf(swap.charAt(i+1)) + retArray;
        }
        
        return retArray;
    }
    
    public static String decToString(long num){
        String swap = Long.toString(num);
        
        return swap;
    }
    
    public static String decToStringEven(long num){
        String swap = decToString(num);
        if(swap.length()%2 != 0){
            swap = "0" + swap;
        }
        
        return swap;
    }
    
    public static byte[] decToByteArrayEven(long num){
        String swap = decToStringEven(num);
        byte[] retArray = new byte[swap.length()];
        
//        System.out.println("num:"+ num + " swp:"+swap);
        for(int i=0; i<swap.length(); i++){
//            System.out.println("swp:chr:"+i+ ":"+swap.charAt(i) +" ");
            retArray[i] = (byte) swap.charAt(i);
        }
//        System.out.println();
        
        return retArray;
    }
    
    public static byte[] decToByteArrayEvenInternalByteOrder(long num){
        int db=0;
        String dch = "";
        byte[] swap = decToByteArrayEven(num);
        byte[] retArray = new byte[swap.length];

        for(int i=0; i<swap.length-1; i=i+2){
//        for(int i=0; i<swap.length-1; i=i+2){
            retArray[swap.length-i-2] = swap[i+1];
            retArray[swap.length-i-1] = swap[i];
//            + retArray;
        }
        
        return retArray;
    }
    
//    public static byte[] swapInternalByteOrder(byte[] bytes){
//        
//    }
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
        for(int i=0; i<count; i++){
            ret = ret + String.valueOf(word.charAt(i));
        }
        
        return ret;
    }
    


}

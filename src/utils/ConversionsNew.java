package utils;

public class ConversionsNew {
    public static String decToHex(long num){
        String swap = Long.toHexString(num);
        
        if(swap.length()%2 != 0){
            swap = "0" + swap;
        }
        
        return swap;
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
        
        for(int i=0; i<swap.length()-1; i++){
            retArray[i] = (byte) swap.charAt(i);
        }
        
        return retArray;
    }
    
    public static byte[] decToByteArrayEvenInternalByteORder(long num){
        byte[] retArray;
        int db=0;
        String dch = "";
        byte[] swap = decToByteArrayEven(num);
        
        for(int i=0; i<swap.length()-1; i=i+2){
            retArray = String.valueOf(swap.charAt(i)) + String.valueOf(swap.charAt(i+1)) + retArray;
        }
        
        return retArray;
    }
    
    public static byte[] swapInternalByteOrder(byte[] bytes){
        
    }

}

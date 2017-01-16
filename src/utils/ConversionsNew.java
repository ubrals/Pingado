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
            ret = Long.parseUnsignedLong(num, 16);
        else
            ret = Long.parseUnsignedLong(num, 16);
        
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
    
    public static long hexToDecInternalByteOrder(String num){
        int len = num.length();
        long ret = 0l;
        String rev = "";
        
        for(int r=0; r<len-1; r+=2){
            rev = String.valueOf((char)num.charAt(r)) + String.valueOf((char)num.charAt(r+1)) + rev;
        }
        while(rev.charAt(0) == '0' && rev.length() != 1){
            rev = rev.substring(1, rev.length());
        }
        
        ret = Long.parseUnsignedLong(rev, 16);
        return ret;
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
        
        for(int i=0; i<swap.length(); i++){
            retArray[swap.length()-i-1] = (byte) swap.charAt(i);
        }
        
        return retArray;
    }
    
    public static byte[] decToByteArrayEvenInternalByteOrder(long num){
        int db=0;
        String dch = "";
        byte[] swap = decToByteArrayEven(num);
        byte[] retArray = new byte[swap.length];

        for(int i=0; i<swap.length-1; i=i+2){
            retArray[swap.length-i-2] = swap[i+1];
            retArray[swap.length-i-1] = swap[i];
        }
        
        return retArray;
    }
    
    public static long byteArrayEvenToDec(byte[] bytes){
        String swap = "";
        byte[] retArray = new byte[bytes.length];
        
//        for(int i=0; i<swap.length-1; i=i+2){
//            retArray[swap.length-i-2] = swap[i+1];
//            retArray[swap.length-i-1] = swap[i];
//        }
        for(int i=0; i<bytes.length; i++)
            swap = "" + (char)bytes[i] + swap;
        
        return Long.parseLong(swap);
    }
    
    public static long byteArrayEvenToDecInternalByteOrder(byte[] bytes){
        String swap = "";
        String swap2 = "";
        byte[] retArray = new byte[bytes.length];
        
//        for(int i=0; i<swap.length-1; i=i+2){
//            retArray[swap.length-i-2] = swap[i+1];
//            retArray[swap.length-i-1] = swap[i];
//        }
        for(int i=0; i<bytes.length; i++)
            swap = "" + (char)bytes[i] + swap;
        
        for(int i=0; i<swap.length()-1; i=i+2){
            swap2 = String.valueOf(swap.charAt(i+1)) + String.valueOf(swap.charAt(i)) + swap2;
        }
        
        return Long.parseLong(swap2);
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
        for(int i=0; i<count; i++){
            ret = ret + String.valueOf(word.charAt(i));
        }
        
        return ret;
    }
    
    public static String toStringByteArray(byte[] bytes, char showAs, String separator){
        StringBuffer ret = new StringBuffer();
        
        switch(showAs){
        case 'i':
        case 'I':
            for(byte byt : bytes)
//                ret.append(Integer.toString((byt & 0xff) + 0x100, 10).substring(1) + "."); // original
                ret.append(((int)(byt & 0xff)) +  separator); // original
        break;
        case 'b':
        case 'B':
            for(byte byt : bytes)
//                ret.append(Integer.toString((byt & 0xff) + 0x100, 10).substring(1) + "."); // original
                ret.append(((byte)(byt & 0xff)) + separator); // original
        break;
        case 'c':
        case 'C':
            for(byte byt : bytes)
//                ret.append(Integer.toString((byt & 0xff) + 0x100, 10).substring(1) + "."); // original
                ret.append(((char)(byt & 0xff)) + separator); // original
        break;
        }
        
        return ret.toString().substring(0, ret.length()-1);
    }
    
    /*****
     * 
     * @param bytes
     * @param qty
     * @param pos
     * @return byte[] / 
     */
    public static byte[] zeroFillByteArray(byte[] bytes, int qty, char pos){
        byte[] formatted = new byte[bytes.length+qty];
        int len = bytes.length;
        
        switch(pos){
        case 'e':
        case 'E':
        case 'l':
        case 'L':
            for(int i=0; i<qty; i++)
                formatted[i] = 48;
            for(int i=qty, l=0; i<formatted.length; i++, l++)
                formatted[i] = bytes[l];
            break;
        case 'd':
        case 'D':
        case 'r':
        case 'R':
            for(int i=0, l=0; i<len; i++, l++)
                formatted[i] = bytes[i];
            for(int i=len; i<qty; i++)
                formatted[i] = 48;
            break;
        }
        
        return formatted;
    }
}

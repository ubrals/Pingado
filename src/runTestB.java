import static utils.ConversionsNew.*;

public class runTestB {

    public static void main(String[] args) {
        byte[] reverse;
        reverse = decToByteArrayEven(1483939849l);
        //49525651575157565257
        reverse = decToByteArrayEvenInternalByteOrder(1483939849l);
        //57525657515751565249
        
        reverse = decToByteArrayEven(148393984l);
        //48495256515751575652
        reverse = decToByteArrayEvenInternalByteOrder(148393984l);
        //52565751575156524948
        
        System.out.println("decToHex(89999l) \t\t\t" + decToHex(89999l));
        System.out.println("decToHexInternalByteOrder(89999l) \t" + decToHexInternalByteOrder(89999l));
        
        for(int i=0; i<reverse.length; i++)
            System.out.print(reverse[i]);
        
        System.out.println();
        System.out.println("hexToDec(015f8f) \t\t=" + hexToDec("015f8f"));
        System.out.println("hexToDec(8f5f01) \t\t=" + hexToDec("8f5f01"));
        
        System.out.println();
        System.out.println("hexToDecInternalByteOrder(015f8f)= \t\t" + hexToDecInternalByteOrder("015f8f"));
        System.out.println("hexToDecInternalByteOrder(8f5f01)= \t\t" + hexToDecInternalByteOrder("8f5f01"));
        
        byte[] num = decToByteArrayEven(1483939849l);
        System.out.println(byteArrayEvenToDec(num));
        System.out.println(toStringByteArray(num, 'I', ":"));
        
        System.out.println();
        num = decToByteArrayEvenInternalByteOrder(1483939849l);
        System.out.println(byteArrayEvenToDecInternalByteOrder(num));
        
        System.out.println(toStringByteArray(num, 'I', ""));
        System.out.println(toStringByteArray(num, 'B', ":"));
        System.out.println(toStringByteArray(num, 'C', "."));
        
        System.out.println();
        byte[] fill = new byte[]{62};
        byte[] refill = zeroFillByteArray(fill, 5, 'e');
        System.out.println(toStringByteArray(refill, 'b', ","));
        System.out.println(toStringByteArray(refill, 'c', ","));
        refill = zeroFillByteArray(fill, 5, 'd');
        refill[1]++;
        System.out.println(toStringByteArray(refill, 'b', ","));
        System.out.println(toStringByteArray(refill, 'c', ","));
        
        
    }

}

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
        
        System.out.println(decToHex(89999l));
        System.out.println(decToHexInternalByteOrder(89999l));
        
        for(int i=0; i<reverse.length; i++)
            System.out.print(reverse[i]);
        
        System.out.println(hexToDec("015f8f"));
        System.out.println(hexToDec("8f5f01"));
    }

}

import static utils.ConversionsNew.*;

public class runTestB {

    public static void main(String[] args) {
        System.out.println(decToHex(89999l));
        System.out.println(decToHexInternalByteOrder(89999l));
    }

}

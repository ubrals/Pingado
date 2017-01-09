import static utils.deprecated.Conversions.*;

public class runTest6 {

	public static void main(String[] args) {
		byte inteiro[] =  {'a', 'b', 'c', 'd'};
		System.out.println(inteiro[1] + " " + Character.valueOf((char) inteiro[0]));
		
		String s_inteiro = "";
		for(byte b : inteiro)
			s_inteiro += (char)b;
		System.out.println(s_inteiro);
		
		System.out.println(byteToString(new byte[] {'1', '2', '3', '4', '5', '6', '7'}) + "??");
		System.out.println(byteToArrayInt(new byte[] {'1', '2', '3', '4', '5', '6', '7'}) );
		
		String hash = "f76eec6c13b11b4a843e562d8ecb20511a623094f6b027ec7df4331247ead7ec" + "z";
		byte b_hash[] = new byte[80];
		for(int i=0; i<hash.length(); i++){
			b_hash[i] = (byte) hash.charAt(i);
		}
		System.out.println(hash);
		for(byte b : b_hash)
			System.out.print(b + " ");
		System.out.println("");
		
		System.out.println(byteToString(b_hash));
	}
}

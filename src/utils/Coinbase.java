package utils;

public class Coinbase {
	public static byte[] generateCoinbase(){
		byte key[] = new byte[100];
		
		
		for(int i=0; i<100; i++){
			double rnd = Math.random();
			key[i] = (byte)(int)(rnd*128);
		}
		
		return key;
	}
}

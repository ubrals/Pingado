import static utils.Coinbase.generateCoinbase;
import static utils.Conversions.byteToString;

import java.time.Instant;

public class runTest8 {

	public static void main(String[] args) {
		byte key[] = generateCoinbase();
		long secs_year = 60*60*24*365;
		long ys970_140 = 2140-1970;
		long secs_2140 = secs_year*ys970_140 +secs_year +((42*(60*60*24))-1);
		
		System.out.println(java.time.Instant.now().getEpochSecond() );
		System.out.println(java.time.Instant.EPOCH + " " + Instant.ofEpochSecond(secs_year*ys970_140+secs_year));
		System.out.println(secs_2140 + ": " + Instant.ofEpochSecond(secs_2140));
	}
}

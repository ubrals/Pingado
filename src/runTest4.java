import static utils.Sha.getSha256;

import deprecated.Block_old;

public class runTest4 {

	public static void main(String[] args) {
		String hash_merkle = getSha256(getSha256("merkle_root", 64), 64);
		String hash_bloco0 = getSha256(getSha256("bloco0", 64), 64);
		String hash_bloco1 = getSha256(getSha256("bloco1", 64), 64);
		String hash_bloco2 = getSha256(getSha256("bloco2", 64), 64);
		long ts_bloco1 = java.time.Instant.now().getEpochSecond();
		Thread d = new Thread();
		try {
			d.sleep(1000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long ts_bloco2 = java.time.Instant.now().getEpochSecond();
		long nBits_bloco0 = 5361120000l;
		long nBits_bloco1 = 5361110000l;
		long nonce_bloco1 = 5361109999l;
		long nBits_bloco2 = 5361109000l;
		long nonce_bloco2 = 5361108999l;
		Block_old block1 = new Block_old(4, hash_bloco0, hash_merkle, ts_bloco1, nBits_bloco1, nonce_bloco1, hash_bloco1, null);
		Block_old block2 = new Block_old(4, hash_bloco1, hash_merkle, ts_bloco2, nBits_bloco2, nonce_bloco2, hash_bloco2, block1);
		
		System.out.println("block1" + block1.toString());
	}

}

import static utils.Sha.getSha256;

import core.Block;
import core.Merkle;

public class runTest7 {

	public static void main(String[] args) {
		Block block0
			, block1
			, block2;
		Merkle merkle_root;
		
		merkle_root = new Merkle();
		
		String hash_merkle = getSha256(getSha256("merkle_root_a", 64), 64);
		String hash_bloco0 = getSha256(getSha256("bloco0", 64), 64);
		long nBits_bloco1 = 5361110000l;
		long nBits_bloco2 = 5361109000l;
		long nonce_bloco1 = 5361109999l;
		long nonce_bloco2 = 5361108999l;
		
		block0 = new Block();
		block1 = new Block(4, hash_bloco0, hash_merkle, java.time.Instant.now().getEpochSecond(), nBits_bloco1, nonce_bloco1, block0);
	}

}

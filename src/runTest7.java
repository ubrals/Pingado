import static utils.Sha.getSha256;

import core.Block_String;
import core.Merkle;
import core.Transaction;
import static utils.Coinbase.generateCoinbase;

public class runTest7 {

	public static void main(String[] args) {
		Block_String block0;
		Merkle merkle_root;
		Transaction transaction1;
		
		// Merkle root
		merkle_root = new Merkle();
		
		// Transaction 1
		double satoshis_trx1 = 1.0;
		byte coinbase[] = new byte[100];
		coinbase = generateCoinbase();
		String hash_trx1 = getSha256(getSha256("transaction1", 64), 64);
		transaction1 = new Transaction(hash_trx1, satoshis_trx1);
		transaction1.setCoinbase(coinbase);
		
		String hash_merkle = getSha256(getSha256("merkle_root_a", 64), 64);
		merkle_root.addTransaction(transaction1);
		merkle_root.addInput(String.valueOf(satoshis_trx1), "signature1", "txid_input", "1", "signature2");
		String hash_bloco0 = getSha256(getSha256("bloco0", 64), 64);
		
		long nBits_bloco0 = 5396284799l;
		long nBits_bloco1 = 5361110000l;
		long nBits_bloco2 = 5361109000l;
		long nonce_bloco1 = 5361109999l;
		long nonce_bloco2 = 5361108999l;
		
		block0 = new Block_String();
	}

}

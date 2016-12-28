package engine;

import fundamental.Hash;
import fundamental.Block_old;

public class Controller {
	private Block_old newBlock;
	private Block_old previousBlock;
		
	public Block_old getNewBlock() {
		return newBlock;
	}

	private void signBlock(){
		Hash previousHash = previousBlock.getHash();
		
	}
	
	private void setNewBlock() {
		this.newBlock = new Block_old();
		
		signBlock();
		
	}
	
	public void startBlock(){
		setNewBlock();
	}
}

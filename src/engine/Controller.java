package engine;

import fundamental.Hash;
import fundamental.Block;

public class Controller {
	private Block newBlock;
	private Block previousBlock;
		
	public Block getNewBlock() {
		return newBlock;
	}

	private void signBlock(){
		Hash previousHash = previousBlock.getHash();
		
	}
	
	private void setNewBlock() {
		this.newBlock = new Block();
		
		signBlock();
		
	}
	
	public void startBlock(){
		setNewBlock();
	}
}

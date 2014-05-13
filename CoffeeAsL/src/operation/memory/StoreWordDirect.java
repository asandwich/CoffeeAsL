package operation.memory;

import operation.Operation;
import memory.MemoryInterface;
import memory.Word;

public class StoreWordDirect extends Operation{

	public StoreWordDirect(Word addr, Word value) {
		this.left = addr;
		this.right = value;
	}

	@Override
	public void run(MemoryInterface memory) {
		memory.store(left.getData(), right.getData());
	}
	@Override
	public Integer getOpCode() {
		return opCode;
	}	
}

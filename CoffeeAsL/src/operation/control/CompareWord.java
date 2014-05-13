package operation.control;

import operation.Operation;
import memory.MemoryInterface;
import memory.Word;

public class CompareWord extends Operation{

	public CompareWord(Word addrL, Word addrR) {
		this.left = addrL;
		this.right = addrR;
	}

	@Override
	public void run(MemoryInterface memory) {
		Integer l = memory.read(this.left.getData());
		Integer r = memory.read(this.right.getData());
		Integer result = l == r ? 0x00000001 : 0x00000000;
		memory.storeOperationResult(result);
	}

	@Override
	public Integer getOpCode() {
		return opCode;
	}
	
}

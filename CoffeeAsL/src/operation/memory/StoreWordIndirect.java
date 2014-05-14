package operation.memory;

import memory.MemoryInterface;
import memory.Word;
import operation.Operation;

public class StoreWordIndirect extends Operation {

	public StoreWordIndirect(Word addrL, Word addrR)
	{
		this.left = addrL;
		this.right = addrR;
	}
	
	@Override
	public void run(MemoryInterface memory) {
		Word value = memory.read(right);
		memory.store(left, value);
	}
	@Override
	public Integer getOpCode() {
		return opCode;
	}
}

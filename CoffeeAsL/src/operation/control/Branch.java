package operation.control;

import operation.Operation;
import memory.MemoryInterface;
import memory.Word;

public class Branch extends Operation{
	public Branch(Word addr, Word compareValue)
	{
		opCode = 1;
		this.left = addr;
		this.right = compareValue;
	}
	
	
	@Override
	public void run(MemoryInterface memory) {
		if(this.right.equals(memory.getOperationResult()))
			memory.setProgramCounter(this.left);
	}


	@Override
	public Integer getOpCode() {
		return opCode;
	}
}

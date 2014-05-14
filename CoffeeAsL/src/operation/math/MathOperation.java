package operation.math;

import memory.MemoryInterface;
import memory.Word;
import operation.Operation;

public abstract class MathOperation extends Operation {
	protected Word addrL;
	protected Word addrR;
	
	public abstract Word getResult();

	public MathOperation(Word addrL, Word addrR)
	{
		this.addrL = addrL;
		this.addrR = addrR;
	}
	@Override
	public void run(MemoryInterface memory) {
		memory.storeOperationResult(this.getResult());
	}

}

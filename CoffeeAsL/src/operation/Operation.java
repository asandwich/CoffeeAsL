package operation;

import memory.MemoryInterface;
import memory.Word;

public class Operation {
	protected static Integer opCode;
	protected Word left;
	protected Word right;
	public void run(MemoryInterface memory) {}
	public Integer getOpCode()
	{
		return opCode;
	}
}

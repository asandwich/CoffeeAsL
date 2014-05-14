package operation.io;

import operation.Operation;
import memory.MemoryInterface;
import memory.Word;

public class Print extends Operation{
	public Print(Word addr, Word mask)
	{
		this.left = addr;
		this.right = mask;
	}
	
	@Override
	public void run(MemoryInterface memory) {
		Word value = memory.read(left);
		
		for(int i = 24; i >= 0; i-=8)
		{
			char c = (char) ((value.getData() >> i) & 0xFF);
			char m = (char) ((this.right.getData() >> 8)  & 0xFF);
			//TODO this is where we can get fancy with the printing mask.
			//i.e. different ways of printing, 
			// EXAMPLES
			// with address, without address
			// as char, as int, as byte, as boolean
			
			if(m == 0xFF)
				System.out.print(c + "");
		}
		
		
		
	}

	@Override
	public Integer getOpCode() {
		return opCode;
	}
}

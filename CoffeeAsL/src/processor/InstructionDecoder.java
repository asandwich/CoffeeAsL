package processor;


import memory.Word;
import operation.NoOp;
import operation.Operation;
import operation.control.Branch;
import operation.control.CompareWord;
import operation.io.Print;
import operation.math.Add;
import operation.math.Divide;
import operation.math.Multiply;
import operation.math.Subtract;
import operation.memory.StoreWordDirect;
import operation.memory.StoreWordIndirect;

public class InstructionDecoder {
	public InstructionDecoder()
	{
		
	}
	
	public Operation decode(Word instruction, Word left, Word right)
	{
		Operation o = new NoOp();
		if(instruction.getData() == 1)
			o = new Branch(left, right);
		else if(instruction.getData() == 2)
			o = new CompareWord(left, right);
		else if(instruction.getData() == 3)
			o = new Print(left, right);
		else if(instruction.getData() == 4)
			o = new Add(left, right);
		else if(instruction.getData() == 5)
			o = new Subtract(left, right);
		else if(instruction.getData() == 6)
			o = new Multiply(left, right);
		else if(instruction.getData() == 7)
			o = new Divide(left, right);
		else if(instruction.getData() == 8)
			o = new StoreWordDirect(left, right);
		else if(instruction.getData() == 9)
			o = new StoreWordIndirect(left, right);
		return o;
	}
}

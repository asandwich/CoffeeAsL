package operation.math;

import memory.Word;

public class Add extends MathOperation {
	
	public Add(Word addrL, Word addrR) {
		super(addrL, addrR);
	}

	@Override
	public Word getResult() {
		return new Word(this.addrL.getData() + this.addrR.getData());
	}

	@Override
	public Integer getOpCode() {
		return opCode;
	}


}

package operation.math;

import memory.Word;

public class Subtract extends MathOperation {


	public Subtract(Word addrL, Word addrR) {
		super(addrL, addrR);
	}

	@Override
	public Word getResult() {
		return new Word(this.addrL.getData() - this.addrR.getData());
	}
	@Override
	public Integer getOpCode() {
		return opCode;
	}
}

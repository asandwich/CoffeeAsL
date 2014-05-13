package operation.math;

import memory.Word;

public class Multiply extends MathOperation {

	public Multiply(Word addrL, Word addrR) {
		super(addrL, addrR);
	}
	

	@Override
	public Word getResult() {
		return new Word(this.addrL.getData() * this.addrR.getData());
	}
	@Override
	public Integer getOpCode() {
		return opCode;
	}
}

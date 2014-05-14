package exception;

import memory.WordTuple;


public class MisMatchedPairException extends Exception {
	private static final long serialVersionUID = 1L;

	public MisMatchedPairException(WordTuple wt) {
		super();
		String exception = "";
		if(wt == null)
			exception += "\tNull word tuple";
		if(wt.getAddress() == null)
			exception += "\tNull address";
		if(wt.getValue() == null)
			exception += "\tNull value";
		System.err.println(exception);
		
	}


}

package memory;

public interface MemoryInterface {

	
	
	
	
	
	public void store(Word addr, Word value);
	public Word read(Word addr);
	public void dumpMemory();
	
	//Special accesses
	public void setProgramCounter(Word data);
	public void storeOperationResult(Word data);
	public Word getOperationResult();
	public Word getNextValue();
}

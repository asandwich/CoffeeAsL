package memory;

public interface MemoryInterface {

	
	
	
	
	
	public boolean store(Integer addr, Integer value);
	public Integer read(Integer addr);
	public void dumpMemory();
	
	//Special accesses
	public void setProgramCounter(Integer data);
	public void storeOperationResult(Integer data);
	public Integer getOperationResult();
	public Word getNextValue();
}

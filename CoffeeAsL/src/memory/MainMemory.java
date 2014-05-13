package memory;

import java.util.Map;
import java.util.TreeMap;


public class MainMemory implements MemoryInterface {
	private Map<Integer, Integer> memory;

	private Word startingAddress = new Word(0x00000000);
	private Word endingAddress = new Word(0xFFFFFFFF);
	
	private Word startingROMAddress = new Word(0x000000FF);
	private Word endingROMAddress = new Word(0x0FFFFFFF);
	
	
	private Word startingRAMAddress = new Word(0xF0000000);
	private Word endingRAMAddress = new Word(0xFFFFFFFF);
	
	
	//This is where the program counter will be stored
	private Word programCounterAddress = new Word(0x00000001);
	//This is where the result of all operations will be stored
	private Word operationAddress = new Word(0x00000002);
	
	
	//Default values
	private Word defaultWord = new Word(0x00000000);
    
    
	public MainMemory()
	{
		 memory = new TreeMap<Integer,Integer>();
		 
		 
		//Store default values
		this.store(operationAddress.getData(), defaultWord.getData());
		this.store(programCounterAddress.getData(), defaultWord.getData());
	}
	
	@Override
	public boolean store(Integer addr, Integer value) {
		memory.put(addr, value);
		//TODO at some point, memory checking needs to happen
		//I.e. out of bounds, stuff like that.
		return true;
	}

	@Override
	public Integer read(Integer addr) {
		return memory.get(addr);
	}

	@Override
	public void dumpMemory() {
		System.out.println("-----MEMORY DUMP-----");
		for (Map.Entry<Integer, Integer> entry : memory.entrySet()) {
		    Word a = new Word(entry.getKey());
		    Word v = new Word(entry.getValue());
		    System.out.println(a.toString() + " : " + v.toString());
		}
		System.out.println("-----MEMORY DUMP-----");

	}

	@Override
	public void setProgramCounter(Integer data) {
		this.store(programCounterAddress.getData(), data);
	}

	@Override
	public void storeOperationResult(Integer data) {
		this.store(operationAddress.getData(),data);
	}

	@Override
	public Integer getOperationResult() {
		return this.read(operationAddress.getData());
	}

	
	public Word getNextValue() {
		Integer retVal = this.read(programCounterAddress.getData());
		this.store(programCounterAddress.getData(), retVal);
		return new Word(retVal);
	}
}

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
		this.store(operationAddress, defaultWord);
		this.setProgramCounter(new Word(0x00000100));
	}
	

	@Override
	public Word read(Word address) {
		Word retVal = new Word(this.memory.get(address.getData()));
		return retVal!=null ? retVal : this.defaultWord;
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
	public void setProgramCounter(Word data) {
		this.store(programCounterAddress, data);
	}

	@Override
	public void storeOperationResult(Word data) {
		this.store(operationAddress,data);
	}

	@Override
	public Word getOperationResult() {
		return this.read(operationAddress);
	}

	
	public Word getNextValue() {
		Word pc = this.read(programCounterAddress);
		Word retVal = this.read(pc);
		this.setProgramCounter( new Word(pc.getData() + 1));
		return retVal;
	}

	public String getProgramCounter() {
		return this.read(programCounterAddress).toString();
	}

	
	@Override
	public void store(Word address, Word value) {
		memory.put(address.getData(), value.getData());
		//TODO at some point, memory checking needs to happen
		//I.e. out of bounds, stuff like that.
	}
	
	
	public void demo()
	{
		//Store default values
		this.store(operationAddress, defaultWord);
		this.setProgramCounter(new Word(0x00000100));
		
		//Store a print command with mask FFFFFFFF
		this.store(new Word(0x00000100), new Word(0x00000003));
		this.store(new Word(0x00000101), new Word(0x10000000));
		this.store(new Word(0x00000102), new Word(0xFFFFFFFF));
		//Store another print command
		this.store(new Word(0x00000103), new Word(0x00000003));
		this.store(new Word(0x00000104), new Word(0x10000001));
		this.store(new Word(0x00000105), new Word(0xFFFFFFFF));
		//Store a branch to position 0x00000100
		this.store(new Word(0x00000106), new Word(0x00000001));
		this.store(new Word(0x00000107), new Word(0x00000100));
		this.store(new Word(0x00000108), new Word(0x00000000));
		
		//Store Hello as characters
		this.store(new Word(0x10000000), new Word(0x48656C6C));
		this.store(new Word(0x10000001), new Word(0x6F21210D));
	}
	
}

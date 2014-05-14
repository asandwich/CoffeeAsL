package memory;

public class WordTuple {
	private Word address;
	private Word value;
	
	public WordTuple (Word address, Word value)
	{
		this.address = address;
		this.value = value;
	}
	
	public Word getAddress()
	{
		return this.address;
	}
	public Word getValue()
	{
		return this.value;
	}
}

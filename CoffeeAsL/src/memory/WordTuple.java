package memory;

public class WordTuple {
	private Word address;
	private Word value;
	
	public WordTuple (Word address, Word value)
	{
		this.address = new Word(address);
		this.value = new Word(value);
	}
	
	public Word getAddress()
	{
		return this.address;
	}
	public Word getValue()
	{
		return this.value;
	}


	@Override
	public String toString()
	{
		return "Address: " + this.address.toString() + "\tValue: " + this.value.toString();
	}
}

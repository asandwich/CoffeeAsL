package interpreter;

import java.util.ArrayList;
import java.util.HashSet;

import exception.MisMatchedPairException;
import exception.RepeatedAddressException;

import memory.MainMemory;
import memory.Word;
import memory.WordTuple;

public class MemoryWriter {
	//Input 
	//ArrayList<(word,word)>
	//output
	//MemoryObject with everything added to it.
	//	Verify that no address is being written to twice
	
	private MainMemory mainMemory;
	public MemoryWriter() 
	{
		//TODO This is where memory will be customized. I.e.
		//Creating a (initialization file) RAM/ROM length, stuff like that
	}
	
	public void writeToMemory(ArrayList<WordTuple> memory) throws RepeatedAddressException, MisMatchedPairException
	{
		HashSet<Word> addresses = new HashSet<>();
		
		for(WordTuple wt : memory)
		{
			if(wt == null || wt.getAddress() == null || wt.getValue() == null)
				throw new MisMatchedPairException(wt);
			if(!addresses.add(wt.getAddress()))
				throw new RepeatedAddressException(wt.getAddress());
		}
		mainMemory = new MainMemory();
		for(WordTuple wt : memory)
		{
			mainMemory.store(wt.getAddress(), wt.getValue());
		}
	}
	
	public MainMemory getMainMemory()
	{
		return mainMemory;
	}
}

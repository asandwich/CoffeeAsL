package interpreter;

import java.util.ArrayList;
import java.util.Collection;

import memory.MemoryInterface;
import memory.Word;
import memory.WordTuple;

public class Parser {
	//Input String[] 
	
	//Operation format 
	//Integer Integer Integer; <--This is an instruction
	//Integer Integer Integer; <--This is an instruction
	
	//Region
	//Region : Integer
	//End Region;
	
	//Output, ArrayList<(word, word)>
	
	private ArrayList<String> rawData;
	private ArrayList<WordTuple> output;

	public Parser(ArrayList<String> rawData)
	{
		this.output = new ArrayList<>();
		this.rawData = rawData;
	}
	
	
	//Isolate a region.
	//Throw errors if you find problems
	//return the parsed regions
	public ArrayList<WordTuple> parseData()
	{
		return output;
	}
	
	
	
	//TODO throw a LOT of errors
	private void parseRegion(ArrayList<String> rawData, Word address)
	{
		
		ArrayList<WordTuple> region = new ArrayList<>();
		for(String s : this.rawData)
		{
			region.addAll(parseLine(s, address));
		}
		output.addAll(region);
	}


	//TODO
	//Throw a SHIT load of exceptions at this point. Malformed lines, 
	//malformed words all that stuff.
	private ArrayList<WordTuple> parseLine(String line, Word address) {
		
		line = line.trim();
		//Check last character equal to ';'
		if(line.charAt(line.length() -1) != ';')
			return null;
		line = line.replace(";", "");
		String[] temp = line.split(" ");
		if(temp.length != 3)
			return null;
		
		ArrayList<WordTuple> retVal = new ArrayList<>();
		for(String s : temp)
		{
			Word w = new Word(s);
			retVal.add(new WordTuple(address,w));
			address.increment();
		}
		return retVal;
	}
	
	
	public static void main(String[] args)
	{
		String a = "0x00000000 0x000000001 0x00000002;";
		String b = "0x00000003 0x000000004 0x00000005;";
		String c = "0x00000006 0x000000007 0x00000008;";
		String d = "0x00000009 0x00000000A 0x0000000B;";
		String e = "0x0000000C 0x00000000D 0x0000000E;";
		ArrayList<String> region = new ArrayList<>();
		region.add(a);
		region.add(b);
		region.add(c);
		region.add(d);
		region.add(e);
		Parser p = new Parser(region);
		p.parseRegion(region, new Word(0x10000000));
		for(WordTuple o : p.parseData())
			System.out.println(o.toString());
	}
	
	
}

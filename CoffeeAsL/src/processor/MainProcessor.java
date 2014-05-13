package processor;

import operation.Operation;
import operation.control.CompareWord;
import operation.io.Print;
import operation.memory.StoreWordDirect;
import memory.MainMemory;
import memory.Word;

public class MainProcessor {

	public static void test(String[] args)
	{
		MainMemory main_memory = new MainMemory();
		
		StoreWordDirect store  = new StoreWordDirect(new Word(0x00000000),new Word(0x00000000));
		StoreWordDirect store1 = new StoreWordDirect(new Word(0x10000001),new Word(0x00000022));
		StoreWordDirect store2 = new StoreWordDirect(new Word(0x10000002),new Word(0x00000022));
		StoreWordDirect store3 = new StoreWordDirect(new Word(0x10000003),new Word(0x00000041));
		StoreWordDirect store4 = new StoreWordDirect(new Word(0x10000004),new Word(0x41424344));
		CompareWord compare = new CompareWord(new Word(0x10000001),new Word(0x10000002));
		Print print  = new Print(new Word(0x10000004),new Word(0xFFFFFFFF));
		Print print1 = new Print(new Word(0x00000001),new Word(0x000000FF));

		store.run(main_memory);
		store1.run(main_memory);
		store2.run(main_memory);
		store3.run(main_memory);
		store4.run(main_memory);
		compare.run(main_memory);
		print.run(main_memory);
		print1.run(main_memory);
		
		System.out.println();		
		System.out.println();		
		main_memory.dumpMemory();
		
	}
	
	public static void main(String[] args)
	{
		//test(null);
		MainProcessor mp = new MainProcessor();
		mp.run();
	}
	
	
	public void run()
	{
		MainMemory main_memory = new MainMemory();
		InstructionDecoder instruction_decoder = new InstructionDecoder();
		
		while(true)
		{
			//main_memory.dumpMemory();
			Word instruction = main_memory.getNextValue();
			Word left = main_memory.getNextValue();
			Word right = main_memory.getNextValue();
			Operation operation = instruction_decoder.decode(instruction, left, right);
			operation.run(main_memory);
		}
	}
}

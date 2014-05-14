package memory;

import java.nio.ByteBuffer;

public class Word implements WordInterface {
	private Integer data;
	
	public Word(Word w)
	{
		this.data = w.data;
	}
	public Word(Integer i) {
		data = i;
	}

	@Override
	public Integer getData() {
		return data;
	}

	@Override
	public boolean isEqual(WordInterface otherWord) {
		return this.data != null 
				&& otherWord != null 
				&& otherWord.getData() != null
				&& otherWord.getData().equals(this.data);
	}
	
	@Override
	public String toString(){
		String retVal ="";
		for (byte b : ByteBuffer.allocate(4).putInt(data).array()) {
			retVal += fixedLenthString(String.format("%x ", b),3);
		}
		return retVal;
	}
	
	private String fixedLenthString(String string, int length) {
	    return String.format("%1$" + length + "s", string);
	}

	@Override
	public boolean equals(Object object)
	{
		if (object == null)
            return false;
        if (object == this)
            return true;
        if (!(object instanceof Word))
            return false;
        
        Word other = (Word)object;
        return this.data == other.data;
        
	}
}

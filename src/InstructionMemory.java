import java.util.ArrayList;
import java.util.Vector;


public class InstructionMemory {

	private Vector <String> Instructions ;
	public static int programCounter;
	
	public InstructionMemory() {
		programCounter = 0;
		this.Instructions=Instructions;
		System.out.println("Instructions loaded");
		
	}

	public Vector <String> getInstructions() {
		return Instructions;
		
	}
	
	public void run (Vector <String> Instructions , Register_File Registers) {
     
		this.Instructions = Instructions ;
		
		String Instruction;
		
		for (int i = 0 ; i<this.Instructions.size();i++)
		{
			System.out.println("-----------------------------------------------------------------");
			System.out.println("program counter before fetching this instruction: "+this.programCounter);
		    Instruction = fetch(programCounter);
		    System.out.println(Instruction);
		    System.out.println("instruction @ index " + i+ " fetched"  );
		    
		    Registers.decode(Instruction,this);
		    this.programCounter++;
		    System.out.println("Program counter after fetching: "+ this.programCounter);
		}
	}
	public String fetch (int x)
	{
		return this.Instructions.get(x);
	}
public static void main(String[] args) {
		
	InstructionMemory m = new InstructionMemory();	
	Register_File regFile = new Register_File() ;
	Vector<String> inst = new Vector<String>();
	inst.add("00000010001100100100100000100010");
	inst.add("00000010001100100100000000100000");
	inst.add("10001110011010000000000000110100");
	inst.add("10101110011010000000000000110100");
	inst.add("00010010001100100000000000000011");
	inst.add("00001000000000000000000010000001");
	m.run(inst,regFile);
		
	}
}

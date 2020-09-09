import java.util.Vector;


public class Register_File {

  public    String [] Registers = new String[32];
  public    boolean writeFlag ;
  public	int ReadRegister1;
  public	int ReadRegister2;
  public    int WriteRegister;
  
  public Register_File() {
		this.Registers[0] = "00000000000000000000000000000000";
	}
  
  
  public void decode(String instruction,InstructionMemory instructionMemory) {
	  
	    String op = instruction.substring(0, 6);
	   
		int rt;
		int immediate;
		int rs;
		int rd;
		int func ;
		
		 
		if( op.equals("101011"))
		{
			
			rs = Integer.parseInt(instruction.substring(6, 11), 2);
			rt = Integer.parseInt(instruction.substring(11, 16), 2);
			immediate = Integer.parseInt(instruction.substring(16, 32), 2);
			
			System.out.println("store word instruction" +" op: " +op+" rs: " + rs + " rt: "+ rt + " immediate: " + immediate +" Type: I-type");
		}
		else if (op.equals("100011"))
		{
			
			rs = Integer.parseInt(instruction.substring(6, 11), 2);
			rt = Integer.parseInt(instruction.substring(11, 16), 2);
			immediate = Integer.parseInt(instruction.substring(16, 32), 2);
			
			System.out.println("load word instruction" +" op: " +op+" rs: " + rs + " rt: "+ rt + " immediate: " + immediate +" Type: I-type" );
			
			
		}
		else if (op.equals("000000"))
		{
			
			func = Integer.parseInt(instruction.substring(26, 32), 2);
			rs = Integer.parseInt(instruction.substring(6, 11), 2);
			rt = Integer.parseInt( instruction.substring(11, 16), 2);
			rd = Integer.parseInt(instruction.substring(16, 21), 2);
			
			if (func == 32) {
				
				System.out.println("addition instruction" +" op: " +op+ " fuc: " + func + " rs: " + rs + " rt: " + rt + " rd: "+rd +" Type: R-type" );
			}
			else if (func == 34 )
			{
				
				System.out.println("subtraction instruction" +" op: " +op+ " fuc: " + func + " rs: " + rs + " rt: " + rt + " rd: "+rd +" Type: R-type");
			}
			else
				System.out.println("instruction not found");
			
			
		}
		else if (op.equals("000100"))
		{
			
			rs = Integer.parseInt(instruction.substring(6, 11), 2);
			rt = Integer.parseInt(instruction.substring(11, 16), 2);
			immediate = Integer.parseInt(instruction.substring(16, 32), 2);
			System.out.println("beq instruction" +" op: " +op+ " rs: " + rs + " rt: " + rt + " immediate: " + immediate +" Type: Conditional branch");
		
			
		}
		else if (op.equals("000010"))
		{
			immediate = Integer.parseInt(instruction.substring(6, 32), 2);
			System.out.println("jump instruction" +" op: " +op+ " immediate: " + immediate + " Type: J-type branch");
			
		}
		else 
		{
			System.out.println("instruction not found");
		}
}



	
	
}

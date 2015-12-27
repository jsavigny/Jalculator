package CommandProcessor;

public class Redo implements CommandExecution{
	private String command;
	private String output;
	public Redo(String command){
		this.command = command;
	}
	public String GetOutput(){
		return output;
	}
	public void ExecuteCmd(){
		String[] cmd = new String[3];
		cmd = command.split("<|>");
		output = "Proses Redo " + cmd[1];
		System.out.println(output);
	}
}

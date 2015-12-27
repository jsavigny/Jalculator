package CommandProcessor;

public class Undo implements CommandExecution{
	private String command;
	private String output;
	public Undo(String command){
		this.command = command;
	}
	public String GetOutput(){
		return output;
	}
	public void ExecuteCmd(){
		String[] cmd = new String[3];
		cmd = command.split("<|>");
		output = "Proses Undo " + cmd[1];
		System.out.println(output);
	}
}

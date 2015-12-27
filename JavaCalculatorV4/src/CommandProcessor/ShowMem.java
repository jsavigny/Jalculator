package CommandProcessor;

public class ShowMem implements CommandExecution{
	private String command;
	private String output;
	public  ShowMem(String command){
		this.command = command;
	}
	public String GetOutput(){
		return output;
	}
	public void ExecuteCmd(){
		String[] cmd = new String[3];
		cmd = command.split("<|>");
		output = "Proses ShowMem " + cmd[1];
		System.out.println(output);
	}
}

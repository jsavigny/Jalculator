package CommandProcessor;

public class Save implements CommandExecution {
	private String command;
	private String output;
	public Save(String command){
		this.command = command;
	}
	public String GetOutput(){
		return output;
	}
	public void ExecuteCmd(){
		output = "Proses Save";
		System.out.println(output);
	}
}

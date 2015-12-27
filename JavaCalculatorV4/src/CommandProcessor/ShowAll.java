package CommandProcessor;

public class ShowAll implements CommandExecution{
	private String command;
	private String output;
	public ShowAll(String command){
		this.command = command;
	}
	public String GetOutput(){
		return output;
	}
	public void ExecuteCmd(){
		output = "Proses Show All";
		System.out.println(output);
	}
}

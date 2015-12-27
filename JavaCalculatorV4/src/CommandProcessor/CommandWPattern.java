package CommandProcessor;

/**
 *
 * @author Julio
 */
public class CommandWPattern {
	//command tanpa design pattern
	private String command;
	
    /**
     * Kelas Command dengan Pattern Design
     * @param cmd adalah String Inputan pengguna
     */
    public CommandWPattern(String cmd){
		this.command = cmd.trim();
	}
	
    /**
     * Mengeksekusi string inputan pengguna sesuai dengan commandnya
     */
    public void Execute(){
		String res="";
		String[] cmd = new String[3];
		cmd = command.split("<|>");
		switch(cmd[0].toLowerCase()){
			case "save":
				Save save = new Save(command);
				save.ExecuteCmd();
				break;
			case "undo":
				Undo undo = new Undo(command);
				undo.ExecuteCmd();
				break;
			case "redo":
				Redo redo = new Redo(command);
				redo.ExecuteCmd();
				break;
			case "showmem":
				ShowMem showmem = new ShowMem(command);
				showmem.ExecuteCmd();
				break;
			case "show all":
				ShowAll showall = new ShowAll(command);
				showall.ExecuteCmd();
				break;
		}
	}
	
	

}

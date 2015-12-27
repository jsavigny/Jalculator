package CommandProcessor;

/**
 *
 * @author Julio
 */
public class Command {
	//command tanpa design pattern
	private String command;
	
    /**
     * Kelas Command, untuk mengolah inputan yang berupa Command
     * (TANPA DESIGN PATTERN)
     * @param cmd adalah String inputan pengguna
     */
    public Command(String cmd){
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
				System.out.println("Proses Save");
				break;
			case "undo":
				System.out.println("Proses Undo " + cmd[1]);
				break;
			case "redo":
				System.out.println("Proses Redo " + cmd[1]);
				break;
			case "showmem":
				System.out.println("Proses ShowMem " + cmd[1]);
				break;
			case "show all":
				System.out.println("Proses Show All");
				break;
		}
	}
	
	

}

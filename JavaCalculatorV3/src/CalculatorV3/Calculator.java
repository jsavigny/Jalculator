package CalculatorV3;

import java.util.*;
import java.util.Scanner;
import CommandProcessor.*;

public class Calculator {
	
	public Calculator(){
		
	}
	
	
	public void use(){
		
		String input="";
		
		while(!(input.equals("quit"))){
			System.out.println("Masukkan input:");
			Scanner s  = new Scanner(System.in);
			input = s.nextLine();
                        Command Cmd = new Command(input);
					Cmd.Execute();
		}
		
	}
	
}

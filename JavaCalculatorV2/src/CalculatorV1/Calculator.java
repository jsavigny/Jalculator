package CalculatorV1;

import java.util.*;
import java.util.Scanner;
import Ekspresi.*;

public class Calculator {
	
	public Calculator(){
		
	}
	
	
	public void use(){
		
		String input="";
		
		while(!(input.equals("quit"))){
			System.out.println("Masukkan input:");
			Scanner s  = new Scanner(System.in);
			input = s.nextLine();
			Ekspresi Eks = new Ekspresi(input);
		        Eks.Execute();
                        String result = Eks.getValue();
		        System.out.println(result);
			
	        
		}
		
	}
	
}

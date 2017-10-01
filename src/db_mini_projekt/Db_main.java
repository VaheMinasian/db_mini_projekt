package db_mini_projekt;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Db_main {
		private static boolean continueProgram = true; 
		static Scanner chooseTable=new Scanner(System.in);
	public static void main(String[]args) {
		try {
		do {
			while(continueProgram) {
				System.out.print("\nselect table\n'1' for student |");
				System.out.print(" '2' for subject  |");
				System.out.print(" '3' for faculty |");
				System.out.print(" '4' for registration |");
				System.out.println(" '0' to Exit program");
				if(chooseTable.hasNextLine()) {
				String s= chooseTable.nextLine();
				switch (s) {
					
					case "0": continueProgram=false;
					break;
					
					case "1": new Student(); 				
					break;	
					
					case "2": new Subject();
					break;	
					
					case "3": new Faculty();
					break;	
					
					case "4": new Registration();
					break;	
					
					default: System.out.println("Invalid input, try again.");
					break;
					}  
				} 		
				}		
			} while (continueProgram); System.out.println("\nGood bye");
		} catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
}
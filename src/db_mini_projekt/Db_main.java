package db_mini_projekt;
import java.util.Scanner;


public class Db_main {

	public static void main(String[]args) {
		System.out.print("select table\n'1' for student |");
		System.out.print(" '2' for subject  |");
		System.out.print(" '3' for faculty |");
		System.out.println(" '4' for registration |\n");
		Scanner chooseTable = new Scanner(System.in);
		while (chooseTable.hasNext()){
			switch (chooseTable.next()) {
			
			case "1": Student student = new Student();
			break;	
			
			case "2": Subject subject = new Subject();
			break;	
			
			case "3": Faculty faculty = new Faculty();
			break;	
			
			case "4": Registration registration = new Registration();
			break;	
			
			default: System.out.println("Invalid input, try again.");
			break;		
			}
		}	chooseTable.close();
	}
}
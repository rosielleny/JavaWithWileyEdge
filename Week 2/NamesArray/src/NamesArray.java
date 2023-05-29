import java.util.Scanner;

public class NamesArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String namesArray[];
		
		System.out.println("Enter the number of names you want to store: ");
		
		int numNames = sc.nextInt();
		sc.nextLine();
		
		namesArray = new String[numNames];
		
		
		for(int index = 0; index < numNames; index++) {
			
			System.out.println("Enter Name "+(index +1)+":");
			namesArray[index] = sc.nextLine();
		}
		
		for(int index = 0; index < numNames; index++) {
			
			System.out.println("Person "+(index+1)+" is called "+namesArray[index]);
		}

	}

}

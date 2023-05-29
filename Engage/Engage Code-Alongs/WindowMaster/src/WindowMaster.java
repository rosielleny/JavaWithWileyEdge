import java.util.Scanner;
public class WindowMaster {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the height of the window (in feet): ");
		float height = sc.nextFloat();
		
		System.out.println("Enter the width of the window (in feet): ");
		float width = sc.nextFloat();
		
		float displayArea = height*width;
		float perimeter = (2*height)+(2*width);
		
		float glassCost = 3.50F;
		float trimCost = 2.25F;
				
		
		float cost = (displayArea*glassCost)+(perimeter*trimCost);
		
		System.out.println("With a display area of "+displayArea+" square feet and a perimeter of "+perimeter+" feet, the cost for the window will be £"+ cost);
		

	}

}

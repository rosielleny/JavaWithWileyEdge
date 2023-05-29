import java.util.Scanner;

public class ShopProducts {
	
	static final double PRODUCT_1 = 22.50;
	static final double PRODUCT_2 = 44.50;
	static final double PRODUCT_3 = 9.98;;
	
	public static void showMenu() {
		
		System.out.println("Select an item to buy from the list below using the corresponding number:");
		System.out.println("1. Product 1 (£"+PRODUCT_1+")\n2. Product 2 (£"+PRODUCT_2+")\n3. Product 3 (£"+PRODUCT_3+")\n4. Finish Shopping");
		
	}
	
	// Makes an array storing product number and quantity sold {{1,QS1}{2,QS2}{3,QS3}}
	
	public static int[][]arrayBuilder(){
		
		Scanner sc = new Scanner(System.in);
		
		int quantitySold1 = 0, quantitySold2 = 0, quantitySold3 = 0, choice = 0;

		
		while(choice != 4) {
			showMenu();
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				quantitySold1 += 1;
				break;
			case 2:
				quantitySold2 += 1;
				break;
			case 3:
				quantitySold3 += 1;
				break;
			case 4:
				System.out.print("\n");
				break;
			default:
				System.out.println("Invalid input.");
			}
			
		}
		
		
		int productList[][] = new int[3][2];
		
		for (int i = 0; i < productList.length; i++) {
		    productList[i][0] = i + 1; 
		    
		    if (i == 0) {
		        productList[i][1] = quantitySold1;
		    } else if (i == 1) {
		        productList[i][1] = quantitySold2;
		    } else if (i == 2) {
		        productList[i][1] = quantitySold3;
		    }
		}
		
		return productList;
		
		
	}
	
	public static double priceCalculator(int[][] productList) {
		
	    double total = 0;

	    for (int i = 0; i < productList.length; i++) {
	        int productNum = productList[i][0];
	        int quantitySold = productList[i][1];

	        switch (productNum) {
	            case 1:
	                total += quantitySold * PRODUCT_1;
	                break;
	            case 2:
	                total +=  quantitySold * PRODUCT_2;
	                break;
	            case 3:
	                total += quantitySold * PRODUCT_3;
	                break;
	        }
	    }
	    
	    return total;
	}

	public static void main(String[] args) {
		
		int array[][] = arrayBuilder(); // Makes an array storing product number and quantity sold {{1,qS1}{2,qS2}{3,qS3}}
		
		double total = priceCalculator(array); // Calculates total bill by multiplying quantity sold by relevent price
		
		System.out.println("Total cost: £"+total);

	}

}

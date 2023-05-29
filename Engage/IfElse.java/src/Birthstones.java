import java.util.Scanner;
	
public class Birthstones {
	
	static String month = "month";
	static String birthstone = "stone";
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What month's birthstone do you want to know? ");
        int monthNum = scanner.nextInt();

        switch (monthNum) {
            case 1:
                birthstone = "Garnet";
                month = "January";
                break;
            case 2:
                birthstone = "Amethyst";
                month = "February";
                break;
            case 3:
                birthstone = "Aquamarine";
                month = "March";
                break;
            case 4:
                birthstone = "Diamond";
                month = "April";
                break;
            case 5:
                birthstone = "Emerald";
                month = "May";
                break;
            case 6:
                birthstone = "Pearl";
                month = "June";
                break;
            case 7:
                birthstone = "Ruby";
                month = "July";
                break;
            case 8:
                birthstone = "Peridot";
                month = "August";
                break;
            case 9:
                birthstone = "Sapphire";
                month = "September";
                break;
            case 10:
                birthstone = "Opal";
                month = "October";
                break;
            case 11:
                birthstone = "Topaz";
                month = "November";
                break;
            case 12:
                birthstone = "Turquoise";
                month = "December";
                break;
            default:
            	System.out.println("Error: Invalid Input");
                break;
        }

       
            System.out.println(month + "'s birthstone is " + birthstone + ".");
        } 
    }



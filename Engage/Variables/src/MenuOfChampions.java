public class MenuOfChampions {
	
    public static void main(String[] args) {
        String restaurantName = "RESTAURANT NIGHT VALE";
        String separator = ".oOo.";
        String dish1 = "Slice of Big Rico Pizza";
        double price1 = 500.00;
        String dish2 = "Invisible Strawberry Pie";
        double price2 = 2.00;
        String dish3 = "Denver Omelet";
        double price3 = 1.50;
        
        System.out.println(separator.repeat(15));
        System.out.println();
        System.out.println("WELCOME TO " + restaurantName + "!");
        System.out.println("Today's Menu Is...");
        System.out.println();
        System.out.println(separator.repeat(15));
        System.out.println();
        System.out.println("$ " + price1 + " *** " + dish1);
        System.out.println("$ " + price2 + " ***** " + dish2);
        System.out.println("$ " + price3 + " ***** " + dish3);
        System.out.println();
        System.out.println(separator.repeat(15));
    }
}

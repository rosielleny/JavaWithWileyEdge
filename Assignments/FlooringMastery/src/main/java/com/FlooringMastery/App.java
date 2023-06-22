package com.FlooringMastery;

import com.FlooringMastery.ui.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import com.FlooringMastery.dto.Order;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    private static FlooringMasteryUserInterfaceImpl userInterface;

    public static void main(String[] args)
    {
    try {
        AnnotationConfigApplicationContext springContainer = new AnnotationConfigApplicationContext();
        springContainer.scan("com.FlooringMastery");
        springContainer.refresh();

        userInterface = springContainer.getBean(FlooringMasteryUserInterfaceImpl.class);

        performMainMenu();
    }
    catch(Exception e){ // There is a possibility an exception will be thrown by the file readers, it is caught here
    	System.out.println("Failed to start the application due to the following error:");
        System.out.println(e.getMessage());
    }
    }

    public static void displayMainMenu()
    {
        System.out.println("------ Main Menu ------");
        System.out.println("(1) Display Orders");
        System.out.println("(2) Add an Order");
        System.out.println("(3) Edit an Order");
        System.out.println("(4) Remove an Order");
        System.out.println("(5) Export All Orders");
        System.out.println("(6) Quit");
        System.out.println("--------------------------");
    }

    public static void performMainMenu()
    {
        boolean exitMenu = false;
        Scanner sc = new Scanner(System.in);

        List<Order> orders = new ArrayList<>();
        
        while (!exitMenu) {
            displayMainMenu();
            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    userInterface.searchOrderNumber(choice, orders);
                    exitMenu = true;
                    break;
                case 2:
                    userInterface.addOrder();
                    break;
                case 3:
                    // edit an order
                    break;
                case 4:
                    // remove an order
                    break;
                case 5:
                    // export all orders
                    break;
                case 6:
                    exitMenu = true;
                    System.out.println("Closing Application...");
                    return;
                default:
                    System.out.println("Invalid Input. Please Try Again.");
                    System.out.println(" ");
            }
        }
    }
}
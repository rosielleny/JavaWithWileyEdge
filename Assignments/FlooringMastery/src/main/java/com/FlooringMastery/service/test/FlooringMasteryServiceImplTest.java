package com.FlooringMastery.service.test;

import com.FlooringMastery.dto.Order;
import com.FlooringMastery.service.OrderServiceImpl;
import com.FlooringMastery.dao.OrderDao;
import com.FlooringMastery.ui.UserIO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlooringMasteryServiceImplTest {
    private OrderServiceImpl orderService;
    private ByteArrayOutputStream output;

    @BeforeEach
    public void setUp() {
        orderService = new OrderServiceImpl();
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testEditOrder() {
        // Prepare test data
        Order order1 = new Order(1);
        order1.setCustomerName("John Doe");
        order1.setState("CA");
        order1.setProductType("Tile");
        order1.setArea(BigDecimal.valueOf(150.0));

        LinkedList<Order> orders = new LinkedList<>();
        orders.add(order1);

        // Perform the edit
        Order editedOrder = orders.getFirst();
        editedOrder.setCustomerName("Jane Smith");
        editedOrder.setState("NY");

        // Verify the changes
        assertEquals("Jane Smith", editedOrder.getCustomerName());
        assertEquals("NY", editedOrder.getState());
        assertEquals("Tile", editedOrder.getProductType());
        assertEquals(BigDecimal.valueOf(150.0), editedOrder.getArea());

        // Prepare user input
        String userInput = "Jane Smith\n\n\n\n\nno\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // Set up mock UserIO implementation
        UserIO userIO = new UserIO() {
            @Override
            public void print(String msg) {
                System.out.println(msg);
            }

            @Override
            public String readString(String msgPrompt) {
                return new Scanner(System.in).nextLine();
            }

            @Override
            public int readInt(String msgPrompt) {
                return 0;
            }

            @Override
            public BigDecimal readBigDecimal(String msgPrompt) {
                return null; // Implement this method as needed for the test
            }

            @Override
            public LocalDate readDate(String msgPrompt) {
                return LocalDate.now();
            }
            
            @Override
            public BigDecimal readBigDecimal(String msgPrompt, BigDecimal min, BigDecimal max) {
                // Implement the logic for reading a BigDecimal value within the specified range
                // You can either return a fixed value or handle user input during testing
                return BigDecimal.ZERO; // Replace with your desired implementation
            }

			@Override
			public double readDouble(String prompt) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public double readDouble(String prompt, double min, double max) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public float readFloat(String prompt) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public float readFloat(String prompt, float min, float max) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int readInt(String prompt, int min, int max) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public long readLong(String prompt) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public long readLong(String prompt, long min, long max) {
				// TODO Auto-generated method stub
				return 0;
			}
        };

        // Set up mock OrderDao implementation
        OrderDao orderDao = new OrderDao() {
            @Override
            public LinkedList<Order> getSingleFile(LocalDate date) {
                return orders;
            }


			@Override
			public List<Order> getAllOrders() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void exportDataToFile() throws IOException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public BigDecimal calculateMaterialCost(BigDecimal area, BigDecimal costPerSqFt) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public BigDecimal calculateLaborCost(BigDecimal area, BigDecimal laborCostPerSqFt) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public BigDecimal calculateTax(BigDecimal materialCost, BigDecimal laborCost, BigDecimal taxRate) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public BigDecimal calculateTotal(BigDecimal materialCost, BigDecimal laborCost, BigDecimal tax) {
				// TODO Auto-generated method stub
				return null;
			}
        };

//        // Set the mock implementations
//        orderService.setUserIO(userIO);
//        orderService.setOrderDao(orderDao);

        // Call the method under test
        orderService.editOrder(1);

        // Assertions
        String expectedOutput = "Existing order data:\n" +
                "Order Number: 1\n" +
                "Customer Name: John Doe\n" +
                "State: CA\n" +
                "Product Type: Tile\n" +
                "Area: 150.0\n" +
                "\n" +
                "Enter new data for each field. Press Enter to leave the data unchanged.\n" +
                "Customer name (John Doe): \n" +
                "State (CA): \n" +
                "Product type (Tile): \n" +
                "Area (150.0): \n" +
                "\n" +
                "Updated order data:\n" +
                "Order Number: 1\n" +
                "Customer Name: Jane Smith\n" +
                "State: CA\n" +
                "Product Type: Tile\n" +
                "Area: 150.0\n" +
                "\n" +
                "Save changes (yes/no): ";

        assertEquals(expectedOutput, output.toString().trim());
    }
}

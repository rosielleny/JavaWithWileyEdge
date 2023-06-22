package com.FlooringMastery.dao.test;

import com.FlooringMastery.service.test.OrderDaoStubImpl;
import com.FlooringMastery.dao.NoOrdersException;
import com.FlooringMastery.dto.Order;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.FlooringMastery.dao.*;

import static org.junit.jupiter.api.Assertions.*;


public class OrderDaoImplTest {

    private OrderDaoStubImpl dao;

    @BeforeAll
    static void beforeAll() {

    }

    @AfterAll
    static void afterAll() {

    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testExportFile_NullOrders_ExceptionThrown() {
        //make sure exception is called when orders list is null
        //add no files to the testorders folder
        assertThrows(IllegalArgumentException.class, () -> dao.exportDataToFile());
    }

    @Test
    void testExportFile_EmptyOrders_ExceptionThrown() {
       //add an empty order file to the testorders folder
        assertThrows(NoOrdersException.class, () -> dao.exportDataToFile());
    }

    @Test
    void testExportFile_ValidData_UpdatesFile() throws IOException {
        dao.exportDataToFile();

        String filePath = "Data/TestDataExport.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String firstLine = reader.readLine();
        assertEquals("Expected", firstLine);

        String secondLine = reader.readLine();
        assertEquals("Expected", secondLine);

        //need to delete test files after they have been created

        reader.close();
    }
    

    // Rosie //
    @Test
    public void testGetSingleFile() throws IOException {
	// Create a temporary file with sample data for the test
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
    	LocalDate date = LocalDate.parse("01021800", formatter);
    	 
    	OrderDaoImpl orderDao = new OrderDaoImpl();

            
    	LinkedList<Order> oneDayOfOrders = orderDao.getSingleFile(date);

            // Assert
    	Assertions.assertEquals(1, oneDayOfOrders.size());

    	Order order = oneDayOfOrders.getFirst();
    	Assertions.assertEquals(1, order.getOrderNumber());
    	Assertions.assertEquals("Ada Lovelace", order.getCustomerName());
    	Assertions.assertEquals("CA", order.getState());
    	Assertions.assertEquals(new BigDecimal("25.00"), order.getTaxRate());
    	Assertions.assertEquals("Tile", order.getProductType());
    	Assertions.assertEquals(new BigDecimal("249.00"), order.getArea());
    	Assertions.assertEquals(new BigDecimal("3.50"), order.getCostPerSqFt());
    	Assertions.assertEquals(new BigDecimal("4.15"), order.getLaborCostPerSqFt());
    	Assertions.assertEquals(new BigDecimal("871.50"), order.getMaterialCost());
    	Assertions.assertEquals(new BigDecimal("1033.35"), order.getLaborCost());
    	Assertions.assertEquals(new BigDecimal("476.21"), order.getTax());
    	Assertions.assertEquals(new BigDecimal("2381.06"), order.getTotal());

        }
}

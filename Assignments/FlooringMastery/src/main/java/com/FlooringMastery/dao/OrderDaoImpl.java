package com.FlooringMastery.dao;

import com.FlooringMastery.dto.Order;
import com.FlooringMastery.dto.Product;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class OrderDaoImpl implements OrderDao {

    private final String DELIMITER = ",";

    private static final String ORDERS_FOLDER = "Orders";

    private static final String EXPORT_DATA_FILE = "Backup/DataExport.txt";

    private Map<Integer, Order> orders = new HashMap<>();
    
 

  //gets all current orders from hashmap and returns arraylist
    @Override
    public List<Order> getAllOrders() throws Exception {
        loadAllOrders();
        return new ArrayList<Order>(orders.values());
    }

    @Override
    public void exportDataToFile() throws IOException {
        List<File> orderFiles = getOrderFiles();

        for (File orderFile : orderFiles) {
            try (BufferedReader reader = new BufferedReader(new FileReader(orderFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String exportLine = processOrderLine(line, orderFile);
                    PrintWriter writer = new PrintWriter(new FileWriter(EXPORT_DATA_FILE));
                    writer.println(exportLine);
                }
            } catch (IOException e) {
                throw new IOException("Could not process order files.");
            }
        }
    }

    @Override
    public BigDecimal calculateMaterialCost(BigDecimal area, BigDecimal costPerSqFt){
        return null;
    }

    @Override
    public BigDecimal calculateLaborCost(BigDecimal area, BigDecimal laborCostPerSqFt) {
        return null;
    }

    @Override
    public BigDecimal calculateTax(BigDecimal materialCost, BigDecimal laborCost, BigDecimal taxRate) {
        return null;
    }

    @Override
    public BigDecimal calculateTotal(BigDecimal materialCost, BigDecimal laborCost, BigDecimal tax) {
        return null;
    }

    //add all order files to a list
    public List<File> getOrderFiles() {
        List<File> orderFiles = new ArrayList<>();
        Path folderPath = Paths.get(ORDERS_FOLDER);
        File folder = folderPath.toFile();
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    orderFiles.add(file);
                }
            }
        }
        return orderFiles;
    }

    //add date to order from file name
    private String processOrderLine(String orderLine, File orderFile) {
        if (orderLine.startsWith("Order Number, Customer Name, State, Tax Rate, Product Type, Area, Cost Per Square Foot, Labor Cost Per Square Foot, Material Cost, Labor Cost, Tax, Total")) {
            return null; //skip the header line
        } else {

            String orderFileName = getFileNameFromPath(orderFile);
            String orderDate = orderFileName.substring(7, 15);
            String exportLine = orderLine + DELIMITER + orderDate;

            return exportLine;
        }
    }

    //helper function for getting date from file name
    private String getFileNameFromPath(File orderFile) {
        String filePath = orderFile.getPath();
        int lastSeparatorIndex = filePath.lastIndexOf(File.separator);

        if(lastSeparatorIndex == -1) {
            return filePath;
        }
        return filePath.substring(lastSeparatorIndex + 1);
    }

    //turn order in file into an object instance
    private Order unmarshallOrder(String orderAsText) {
        if (orderAsText.startsWith("Order Number, Customer Name, State, Tax Rate, Product Type, Area, Cost Per Square Foot, Labor Cost Per Square Foot, Material Cost, Labor Cost, Tax, Total")) {
            return null; // Skip the header line
        }

        String[] orderTokens = orderAsText.split(DELIMITER);
        int orderNumber = Integer.parseInt(orderTokens[0]);
        Order orderFromFile = new Order(orderNumber);
        String customerName = orderTokens[1];
        String stateAbbrev = orderTokens[2];
        BigDecimal taxRate = new BigDecimal(orderTokens[3]);
        String productType = orderTokens[4];
        BigDecimal area = new BigDecimal(orderTokens[5]);
        BigDecimal costPerSqFt = new BigDecimal(orderTokens[6]);
        BigDecimal laborCostPerSqFt = new BigDecimal(orderTokens[7]);
        BigDecimal materialCost = new BigDecimal(orderTokens[8]);
        BigDecimal laborCost = new BigDecimal(orderTokens[9]);
        BigDecimal tax = new BigDecimal(orderTokens[10]);
        BigDecimal total = new BigDecimal(orderTokens[11]);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        String deliveryDateString = orderTokens[12]; 
        LocalDate deliveryDate = LocalDate.parse(deliveryDateString, formatter);
        
        orderFromFile.setCustomerName(customerName);
        orderFromFile.setState(stateAbbrev);
        orderFromFile.setTaxRate(taxRate);
        orderFromFile.setProductType(productType);
        orderFromFile.setArea(area);
        orderFromFile.setCostPerSqFt(costPerSqFt);
        orderFromFile.setLaborCostPerSqFt(laborCostPerSqFt);
        orderFromFile.setMaterialCost(materialCost);
        orderFromFile.setLaborCost(laborCost);
        orderFromFile.setTax(tax);
        orderFromFile.setTotal(total);
        orderFromFile.setDeliveryDate(deliveryDate);

        return orderFromFile;
    }

    //turn object instance into a line
    private String marshallOrder(Order order) {
        String orderAsText = order.getOrderNumber() + DELIMITER;
        orderAsText += order.getCustomerName() + DELIMITER;
        orderAsText += order.getState() + DELIMITER;
        orderAsText += order.getTaxRate() + DELIMITER;
        orderAsText += order.getProductType() + DELIMITER;
        orderAsText += order.getArea() + DELIMITER;
        orderAsText += order.getCostPerSqFt() + DELIMITER;
        orderAsText += order.getLaborCostPerSqFt() + DELIMITER;
        orderAsText += order.getMaterialCost() + DELIMITER;
        orderAsText += order.getLaborCost() + DELIMITER;
        orderAsText += order.getTax() + DELIMITER;
        orderAsText += order.getTotal()  + DELIMITER;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        String deliveryDateString = order.getDeliveryDate().format(formatter);
        
        orderAsText += deliveryDateString;
        
        

        return orderAsText;
    }


    //loads orders from all files and adds them to hashmap
    private void loadAllOrders() throws Exception {
        Scanner scanner;

        List<File> orderFiles = getOrderFiles();


        for (File orderFile : orderFiles) {
            try {
                scanner = new Scanner(new BufferedReader(new FileReader(orderFile)));
            } catch (FileNotFoundException e) {
                throw new Exception("Could not load data into memory.", e);
            }
            String currentLine;
            Order currentOrder;

            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                if (currentLine.startsWith("Order Number, Customer Name, State, Tax Rate, Product Type, Area, Cost Per Square Foot, Labor Cost Per Square Foot, Material Cost, Labor Cost, Tax, Total")) {
                    continue; //skip the header line
                }
                currentOrder = unmarshallOrder(currentLine);
                orders.put(currentOrder.getOrderNumber(), currentOrder);
            }
            scanner.close();
        }
    }

    //writes one order to a file
    public void writeOrder(String filePath, LocalDate date, Order order) throws Exception {
        
        String formattedDate = date.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        String fullPath = filePath + "Orders_" + formattedDate + ".txt";

        try (PrintWriter out = new PrintWriter(new FileWriter(fullPath, true))) {
            String orderAsText;

            // Check if the file is brand new and add header, if so
            File file = new File(fullPath);
            if (file.length() == 0) {
                out.println("Order Number, Customer Name, State, Tax Rate, Product Type, Area, Cost Per Square Foot, Labor Cost Per Square Foot, Material Cost, Labor Cost, Tax, Total, Delivery Date");
            }

            orderAsText = marshallOrder(order);
            out.println(orderAsText);
        } catch (IOException e) {
            throw new Exception("Could not save item data.", e);
        }
    }

    // Rosie
    // A function that allows retrieval of a single order file by date
	@Override
	public LinkedList<Order> getSingleFile(LocalDate date) throws FileNotFoundException {
		
		// Using this to transform the date into the format matching the file names
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
		String dateString = date.format(formatter);
		String fileName = "Orders/Orders_"+dateString+".txt";
		

		LinkedList<Order> oneDayOfOrders = new LinkedList<Order>();
		
		FileReader fileReader = new FileReader(fileName);
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		Scanner scanner = new Scanner(bufferedReader);
		
		 if (scanner.hasNextLine()) { // Used to skip the header line
		        scanner.nextLine();
		    }
		
		// Transforms the data in the file to a list of objects
		while (scanner.hasNextLine()) {
	        String currentLine = scanner.nextLine();
	        String[] values = currentLine.split(",");

	        int orderNumber = Integer.parseInt(values[0]);
	        String customerName = values[1];
	        String state = values[2];
	        BigDecimal taxRate = new BigDecimal(values[3]);
	        String productType = values[4];
	        BigDecimal area = new BigDecimal(values[5]);
	        BigDecimal costPerSqFt = new BigDecimal(values[6]);
	        BigDecimal laborCostPerSqFt = new BigDecimal(values[7]);
	        BigDecimal materialCost = new BigDecimal(values[8]);
	        BigDecimal laborCost = new BigDecimal(values[9]);
	        BigDecimal tax = new BigDecimal(values[10]);
	        BigDecimal total = new BigDecimal(values[11]);
	        String deliveryDateString = values[12]; 
	        LocalDate deliveryDate = LocalDate.parse(deliveryDateString, formatter);

	        Order order = new Order(orderNumber);
	        order.setCustomerName(customerName);
	        order.setState(state);
	        order.setTaxRate(taxRate);
	        order.setProductType(productType);
	        order.setArea(area);
	        order.setCostPerSqFt(costPerSqFt);
	        order.setLaborCostPerSqFt(laborCostPerSqFt);
	        order.setMaterialCost(materialCost);
	        order.setLaborCost(laborCost);
	        order.setTax(tax);
	        order.setTotal(total);
	        order.setDeliveryDate(deliveryDate);

	        oneDayOfOrders.add(order);}
		
		
		
		return oneDayOfOrders;
		
	}

}

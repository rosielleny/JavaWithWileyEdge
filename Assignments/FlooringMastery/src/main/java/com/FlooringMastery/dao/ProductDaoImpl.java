package com.FlooringMastery.dao;

import com.FlooringMastery.dto.Order;
import com.FlooringMastery.dto.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductDaoImpl {

    private final String DELIMITER = ",";
    private final String PRODUCT_FILE = "Data/Products.txt";

    private Map<String, Product> products = new HashMap<>();

    //generates product objects from product file
    private Product unmarshallProduct(String productAsText) {
        if (productAsText.startsWith("ProductType,CostPerSquareFoot,LaborCostPerSquareFoot")) {
            return null; // Skip the header line
        }

        String[] productTokens = productAsText.split(DELIMITER);
        String productType = productTokens[0];
        BigDecimal costPerSqFt = new BigDecimal(productTokens[1]);
        BigDecimal laborCostPerSqFt = new BigDecimal(productTokens[2]);
        Product productFromFile = new Product(productType, costPerSqFt, laborCostPerSqFt);

        return productFromFile;
    }

    //loads products from file into hashmap
    public Map<String, Product> loadAllProducts() throws Exception {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(PRODUCT_FILE)));
        } catch (FileNotFoundException e) {
            throw new Exception("Could not load data into memory.", e);
        }
        String currentLine;
        Product currentProduct;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            if (currentLine.startsWith("ProductType,CostPerSquareFoot,LaborCostPerSquareFoot")) {
                continue; //skip the header line
            }
            currentProduct = unmarshallProduct(currentLine);
            products.put(currentProduct.getProductType(), currentProduct);
        }
        scanner.close();
        return products;
    }
}

package com.FlooringMastery.dao;

import com.FlooringMastery.dto.Product;
import com.FlooringMastery.dto.Tax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaxDaoImpl {

    private final String DELIMITER = ",";
    private final String TAX_FILE = "Data/Taxes.txt";

    private Map<String, Tax> taxRates = new HashMap<>();

    //loads tax rates from the tax file
    private Tax unmarshallTax(String taxAsText) {
        if (taxAsText.startsWith("State,StateName,TaxRate")) {
            return null; // Skip the header line
        }

        String[] taxTokens = taxAsText.split(DELIMITER);
        String stateAbbrev = taxTokens[0];
        String stateName = taxTokens[1];
        BigDecimal taxRate = new BigDecimal(taxTokens[2]);
        Tax taxFromFile = new Tax(stateAbbrev, stateName, taxRate);

        return taxFromFile;
    }

    //puts tax rates into the taxRates hashmap
    public Map<String, Tax> loadAllTaxRates() throws Exception {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(TAX_FILE)));
        } catch (FileNotFoundException e) {
            throw new Exception("Could not load data into memory.", e);
        }
        String currentLine;
        Tax currentTax;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            if (currentLine.startsWith("State,StateName,TaxRate")) {
                continue; //skip the header line
            }
            currentTax = unmarshallTax(currentLine);
            taxRates.put(currentTax.getStateAbbrev(), currentTax);
        }
        scanner.close();
        return taxRates;
    }

}

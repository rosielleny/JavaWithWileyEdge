package com.FlooringMastery.dao;

import com.FlooringMastery.dto.Order;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public interface OrderDao {
    List<Order> getAllOrders() throws Exception;
    void exportDataToFile() throws IOException;
    LinkedList<Order> getSingleFile(LocalDate date) throws FileNotFoundException, IOException, FileNotFoundException;
    BigDecimal calculateMaterialCost(BigDecimal area, BigDecimal costPerSqFt);
    BigDecimal calculateLaborCost(BigDecimal area, BigDecimal laborCostPerSqFt);
    BigDecimal calculateTax(BigDecimal materialCost, BigDecimal laborCost, BigDecimal taxRate);
    BigDecimal calculateTotal(BigDecimal materialCost, BigDecimal laborCost, BigDecimal tax);
}

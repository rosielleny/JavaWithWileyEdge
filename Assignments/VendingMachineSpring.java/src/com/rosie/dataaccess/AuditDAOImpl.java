package com.rosie.dataaccess;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.rosie.dto.Item;
@Component("audit")
public class AuditDAOImpl implements AuditDAO{


	public boolean writeRecords(Item purchasedItem, BigDecimal money, BigDecimal change) throws IOException {
	    
		FileWriter fileWriter = new FileWriter("AuditLog.txt", true);  // Appends to the file if it already exists
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    
	    // Getting time
	    LocalDateTime currentTime = LocalDateTime.now();
	    String formattedTime = currentTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	    
	    // Converting change to be in dollars so is comparable to the money variable
	    BigDecimal amountInDollars = change.divide(BigDecimal.valueOf(100));
	    amountInDollars = amountInDollars.setScale(2, RoundingMode.HALF_UP); 
	    
	    // Concatenating
	    String record = formattedTime + ", Purchase: " + purchasedItem.getName() + ", Money in: " + money + ", Money out: " + amountInDollars;
	    printWriter.println(record);

	    printWriter.close();

	    return true;
	}

}
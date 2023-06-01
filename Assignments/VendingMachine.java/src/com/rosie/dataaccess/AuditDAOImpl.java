package com.rosie.dataaccess;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import com.rosie.dto.Item;

public class AuditDAOImpl implements AuditDAO{


	public boolean writeRecords(Item purchasedItem, BigDecimal money, BigDecimal change) throws IOException {
	    FileWriter fileWriter = new FileWriter("AuditLog.txt", true);  // Appends to the file if it already exists
	    PrintWriter printWriter = new PrintWriter(fileWriter);

	    LocalDateTime currentTime = LocalDateTime.now();
	    String formattedTime = currentTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	    BigDecimal amountInDollars = change.divide(BigDecimal.valueOf(100));
	    amountInDollars = amountInDollars.setScale(2, RoundingMode.HALF_UP); 

	    String record = formattedTime + "," + purchasedItem.getName() + "," + money + "," + amountInDollars;
	    printWriter.println(record);

	    printWriter.close();

	    return true;
	}

}

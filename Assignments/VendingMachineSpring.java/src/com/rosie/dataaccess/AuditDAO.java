package com.rosie.dataaccess;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;

import com.rosie.dto.Item;

public interface AuditDAO {
	
	public boolean writeRecords(Item purchasedItem, BigDecimal money, BigDecimal change)throws IOException;

}

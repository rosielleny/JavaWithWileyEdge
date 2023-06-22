package com.rosie.dataaccess;

import java.io.IOException;
import java.util.LinkedList;
import com.rosie.dto.Item;

public interface ItemDAO {

		public boolean writeRecords(LinkedList<Item> items)throws IOException;
		
		

	}


package com.rosie.dataaccess;

import com.rosie.dto.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.LinkedList;

import org.springframework.stereotype.Component;
@Component("dao")
public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean writeRecords(LinkedList<Item> items) throws IOException {
        FileWriter fileWriter = new FileWriter("VendingMachine.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

      //Converting items to stream
        items.stream() 
     // Mapping each Item in the items list to a string representation of the item's name, price, and inventory count
                .map(item -> item.getName() + "," + item.getPrice() + "," + item.getInventoryCount()) 
                // Using forEach to write each string representation to a new line in the file.
                .forEach(printWriter::println);

        printWriter.close();

        return true;
    }

    
    public static LinkedList<Item> readRecords() throws IOException{
        LinkedList<Item> itemList = new LinkedList<>();

        FileReader fileReader = new FileReader("VendingMachine.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        bufferedReader.lines()
        // Mapping each line to an array of values by splitting the line using the comma delimiter
                .map(line -> line.split(",")) 
                .map(values -> {
                    Item item = new Item();
                    item.setName(values[0]);
                    item.setPrice(new BigDecimal(values[1]));
                    item.setInventoryCount(Integer.parseInt(values[2]));
                    return item;
                })
                .forEach(itemList::add);

        fileReader.close();
        bufferedReader.close();

        return itemList;

}
}
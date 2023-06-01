package com.sujata.demo;

import com.sujata.entity.Book;

public class ExpensiveBookPredicate implements BookPredicate {

	@Override
	public boolean checkBook(Book book) {
		
		return book.getPrice()>2500;
		}
	}



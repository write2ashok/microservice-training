package com.fis.ms.service;

import java.util.List;

import com.fis.ms.model.Book;

public interface BooksService {

	List<Book> findAllBookById(Long id);
	
	List<Book> findAllBooks();

	Book save(Book address);
	
	Book findBookById(Long id);

	Book updateAvailability(Book book, Long id, Long incremental_count);
}

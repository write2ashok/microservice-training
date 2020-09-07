package com.fis.ms.service;

import java.util.List;

import com.fis.ms.model.Book;

public interface BooksService {

	List<Book> findAllBookByBookId(Long bookid);
	
	List<Book> findAllBooks();

	Book save(Book address);
	
	Book findBookById(Long bookid);

	Book updateAvailability(Book book);
}

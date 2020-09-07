package com.fis.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.ms.model.Book;
import com.fis.ms.repository.BookRepository;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BookRepository mBookRepository;

	@Override
	public List<Book> findAllBookById(Long id) {
		return mBookRepository.findAllBookById(id);
	}

	@Override
	public Book save(Book address) {
		return mBookRepository.save(address);
	}

	@Override
	public Book findBookById(Long id) {
		return mBookRepository.findBookById(id);
	}

	@Override
	public List<Book> findAllBooks() {
		return mBookRepository.findAll();
	}

	@Override
	public Book updateAvailability(Book book, Long id, Long incremental_count) {
		Book bookAvlble = findBookById(book.getId());
		if(bookAvlble != null)
		{
			int noOfCopies = bookAvlble.getAvailableCopies();
			book.setAvailableCopies(noOfCopies+incremental_count.intValue());
			return mBookRepository.save(book);
		}
		else
		{
			return null;
		}
		
	}

}

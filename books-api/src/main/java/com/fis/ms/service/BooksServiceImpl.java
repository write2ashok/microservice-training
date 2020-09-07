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
	public List<Book> findAllBookByBookId(Long bookid) {
		return mBookRepository.findAllBookById(bookid);
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
	public Book updateAvailability(Book book) {
		Book bookAvlble = findBookById(book.getId());
		if(bookAvlble != null)
		{
			int noOfCopies = bookAvlble.getAvailableCopies();
			book.setAvailableCopies(noOfCopies+1);
			return mBookRepository.save(book);
		}
		else
		{
			return null;
		}
		
	}

}

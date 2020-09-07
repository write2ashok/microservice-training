package com.fis.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fis.ms.controller.response.ApiResponse;
import com.fis.ms.controller.response.ConstructResponseEntity;
import com.fis.ms.model.Book;
import com.fis.ms.service.BooksService;

@RestController
public class BookController {

	@Autowired
	private BooksService bookService;

	@RequestMapping(method = RequestMethod.GET, value = "/books")
	@ResponseBody
	public ResponseEntity<ApiResponse> getAllBooks() {
		List<Book> allBooks = bookService.findAllBooks();
		if (allBooks == null || allBooks.isEmpty()) {
			return ConstructResponseEntity.getResponseEntity("Error", HttpStatus.NOT_FOUND, allBooks);
		}
		return ConstructResponseEntity.getResponseEntity("Success", HttpStatus.OK, allBooks);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/books/{bookid}")
	@ResponseBody
	public ResponseEntity<ApiResponse> getBookById(Long bookid) {
		Book book = bookService.findBookById(bookid);
		if (book == null) {
			return ConstructResponseEntity.getResponseEntity("Error", HttpStatus.NOT_FOUND, book);
		}
		return ConstructResponseEntity.getResponseEntity("Success", HttpStatus.OK, book);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/books/UpdateAvailability/{bookId}/{incremental_count}")
	@ResponseBody
	public ResponseEntity<ApiResponse> updateAvailability(Book book) {
		Book bookret = bookService.updateAvailability(book);
		if (bookret == null) {
			return ConstructResponseEntity.getResponseEntity(
					"Bookid {" + book.getId() + "} is not found in BOOK table", HttpStatus.NOT_FOUND, book);
		}
		return ConstructResponseEntity.getResponseEntity("Successful creation of subscription record", HttpStatus.OK);
	}
}

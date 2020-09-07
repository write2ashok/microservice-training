	package com.fis.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.ms.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>
{

	List<Book> findAllBookById(Long id);

	Book save(Book address);
	
	Book findBookById(Long id);
	
}

package com.shnfirat.BookStore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shnfirat.BookStore.model.Book;

public interface IBookRepository extends MongoRepository<Book, Long>{

	List<Book> findAllByAuthor(String author);

	Optional<Book> findById(String id);
	
	Optional<Book> findByName(String name);

	Optional<Book> findByAuthor(String author);

	
	
}

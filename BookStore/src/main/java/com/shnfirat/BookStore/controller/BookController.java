package com.shnfirat.BookStore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shnfirat.BookStore.dto.BookCreateDTO;
import com.shnfirat.BookStore.dto.BookUpdateDTO;
import com.shnfirat.BookStore.dto.BookViewDTO;
import com.shnfirat.BookStore.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping
	public ResponseEntity<List<BookViewDTO>> getBooks(){
		return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
	}
	
	@GetMapping("/authorName")
	public ResponseEntity<List<BookViewDTO>> getBooksWithAuthor(@RequestParam(required = false) String authorName){
		return new ResponseEntity<>(bookService.getBooksWithAuthor(authorName), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<BookViewDTO> getBookWithId(@PathVariable String id){
		return new ResponseEntity<>(bookService.getBookWithId(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BookViewDTO> createBook(@RequestBody BookCreateDTO bookCreate){
		return new ResponseEntity<>(bookService.createBook(bookCreate), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BookViewDTO> updateBookWithId(@PathVariable String id, @RequestBody BookUpdateDTO updateBook){
		return new ResponseEntity<BookViewDTO>(bookService.updateBookWithId(id, updateBook), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBookWithId(@PathVariable String id){
		bookService.deleteBookWithId(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
}

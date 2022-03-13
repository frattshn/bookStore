package com.shnfirat.BookStore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shnfirat.BookStore.dto.BookCreateDTO;
import com.shnfirat.BookStore.dto.BookUpdateDTO;
import com.shnfirat.BookStore.dto.BookViewDTO;
import com.shnfirat.BookStore.model.Book;
import com.shnfirat.BookStore.repository.IBookRepository;

@Service
public class BookService {
	
	private final IBookRepository bookRepository;

	public BookService(IBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<BookViewDTO> getBooks() {
		
		List<BookViewDTO> bookViews = new ArrayList<BookViewDTO>();
		final List<Book> books = bookRepository.findAll();
		for (Book b : books) {
			bookViews.add(BookViewDTO.of(b));
		}
		
		return bookViews;
	}

	public List<BookViewDTO> getBooksWithAuthor(String authorName) {
		
		if(authorName == null) {
			return null;
		}else {
			List<BookViewDTO> bookViews = new ArrayList<BookViewDTO>();
			final List<Book> books = bookRepository.findAllByAuthor(authorName);
			for(Book b : books) {
				bookViews.add(BookViewDTO.of(b));
			}
			return bookViews;
		}
		
	}

//	public BookViewDTO getBookWithId(Long id) {
//		return BookViewDTO.of(bookRepository.findById(id).orElseThrow(null));
//	}

	public BookViewDTO createBook(BookCreateDTO bookCreate) {
		
		Book newBook = new Book();
		newBook.setName(bookCreate.getName());
		newBook.setAuthor(bookCreate.getAuthor());
		newBook.setPageCount(bookCreate.getPageCount());

		
		bookRepository.save(newBook);
		return BookViewDTO.of(newBook);
	}

	public BookViewDTO updateBookWithId(String id, BookUpdateDTO updateBook) {
		
		Optional<Book> findBook = bookRepository.findById(id);
		if(findBook.isEmpty()) {
			return null;
		}else {
			final Book book = findBook.get();
			book.setName(updateBook.getName());
			book.setAuthor(updateBook.getAuthor());
			book.setPageCount(updateBook.getPageCount());
			
			bookRepository.save(book);
			return BookViewDTO.of(book);
		}
		
	}

	public void deleteBookWithId(String id) {
		
		Optional<Book> book = bookRepository.findById(id);
		if(book.isPresent()) {
			final Book deleteBook = book.get();
			bookRepository.delete(deleteBook);
		}else {
			//throw new Exception();
		}
		
	}
	

	
	
	
	
	
	
}

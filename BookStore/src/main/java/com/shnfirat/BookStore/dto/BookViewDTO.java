package com.shnfirat.BookStore.dto;

import java.io.Serializable;
import java.util.Date;

import com.shnfirat.BookStore.model.Book;

import lombok.Data;

@Data
public class BookViewDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String author;
	
	private int pageCount;
	
	private Date createTime;

	public BookViewDTO(String name, String author, int pageCount, Date createTime) {
		this.name = name;
		this.author = author;
		this.pageCount = pageCount;
		this.createTime = createTime;
	}
	
	
	public static BookViewDTO of(Book book) {
		return new BookViewDTO(book.getName(), book.getAuthor(), book.getPageCount(), book.getCreateTime());
	}
	
	
}

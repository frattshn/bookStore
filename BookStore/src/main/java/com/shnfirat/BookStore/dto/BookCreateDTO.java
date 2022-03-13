package com.shnfirat.BookStore.dto;


import lombok.Data;

@Data
public class BookCreateDTO {
	
	private String name;
	
	private String author;
	
	private int pageCount;


}

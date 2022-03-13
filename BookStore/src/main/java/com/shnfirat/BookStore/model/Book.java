package com.shnfirat.BookStore.model;


import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {

	@Id
	private String id;
	
	private String name;
	
	private String author;
	
	private int pageCount;
	
	private Date createTime = new Date();

	public Book(String id, String name, String author, int pageCount, Date createTime) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.pageCount = pageCount;
		this.createTime = createTime;
	}
	
	

	
	
	
	
}

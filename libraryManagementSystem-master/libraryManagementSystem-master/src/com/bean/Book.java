package com.bean;

public class Book {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String bookCategory;
	
	public int getBookId() {
		return bookId;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public String getBookAuthor() {
		return bookAuthor;
	}
	
	public String getBookCategory() {
		return bookCategory;
	}
	
	
	/* 
	 ==============================
	 	Setters (To Set the Data) 
	 ==============================
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	
	
	
}

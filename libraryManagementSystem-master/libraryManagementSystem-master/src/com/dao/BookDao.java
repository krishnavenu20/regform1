package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.bean.Book;

public class BookDao {
	
	public BookDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	private Connection conn;
	
	public boolean addBook(Book b) {
		boolean f = false;
		try {
			String query = "insert into books(bookId,bookName,bookAuthor,bookCategory) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, b.getBookId());
			ps.setString(2, b.getBookName());
			ps.setString(3, b.getBookAuthor());
			ps.setString(4, b.getBookCategory());
			
			int i = ps.executeUpdate();
			if(i==1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	public boolean editBook(Book b) {
		boolean f = false;
		try {
			PreparedStatement ps = conn.prepareStatement("update books set bookName=?,bookAuthor=?,bookCategory=? where bookId=?");
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getBookAuthor());
			ps.setString(3, b.getBookCategory());
			ps.setInt(4, b.getBookId());
			
			int i = ps.executeUpdate();
			if(i==1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteBook(int bookId) {
		boolean f = false;
		try {
			PreparedStatement ps = conn.prepareStatement("delete from books where bookId=?");
			ps.setInt(1, bookId);
			int i = ps.executeUpdate();
			if(i>=1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public Book viewBook(int bookId) {
		Book b = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select *from books where bookId=?");
			ps.setInt(1, bookId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				b = new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setBookAuthor(rs.getString(3));
				b.setBookCategory(rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public List<Book> getAllBooks(){
		List<Book> list = new ArrayList();
		Book b = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement("select *from books");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				b = new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setBookAuthor(rs.getString(3));
				b.setBookCategory(rs.getString(4));
				list.add(b);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}

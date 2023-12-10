package com.main;

import java.util.List;
import java.util.Scanner;

import com.bean.Book;
import com.bean.Student;
import com.connection.DBConnection;
import com.dao.BookDao;
import com.dao.StudentDao;

public class Application {
	
	/*
	 ============================
	 		BOOKS CODE
	 =============================
	 */
	
	public static void addBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter book id");
		int bookId = sc.nextInt();
		
		System.out.println("Enter book name");
		String bookName = sc.next();
		
		System.out.println("Enter book Author");
		String bookAuthor = sc.next();
		
		System.out.println("Enter book category");
		String bookCategory = sc.next();
		
		//Setting the data to beans
		Book b = new Book();
		b.setBookId(bookId);
		b.setBookName(bookName);
		b.setBookAuthor(bookAuthor);
		b.setBookCategory(bookCategory);
		
		//getting the method from dao.
		BookDao dao = new BookDao(DBConnection.getConnection());
		boolean f = dao.addBook(b);
		if(f) {
			System.out.println("Book added successfully");
		}else {
			System.out.println("Something went wrong");
		}
	}
	
	public static void deleteBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter book id to delete");
		int id = sc.nextInt();
		Book b = new Book();
		b.setBookId(id);
		BookDao dao = new BookDao(DBConnection.getConnection());
		boolean f = dao.deleteBook(id);
		
		if(f) {
			System.out.println("Book details deleted succesfully");
		}else {
			System.out.println("something went wrong");
		}
		
	}
	
	public static void updateBook() {
		Scanner sc = new Scanner(System.in);
		Book b = new Book();
		System.out.println("Enter book id");
		int bookId = sc.nextInt();
		System.out.println("Enter book name");
		String bookName = sc.next();
		System.out.println("Enter book Author");
		String bookAuthor = sc.next();
		System.out.println("Enter book category");
		String bookCategory = sc.next();
		b.setBookId(bookId);
		b.setBookName(bookName);
		b.setBookAuthor(bookAuthor);
		b.setBookCategory(bookCategory);
		
		BookDao dao = new BookDao(DBConnection.getConnection());
		
		boolean f = dao.editBook(b);
		if(f) {
			System.out.println("book details updated");
		}else {
			System.out.println("something went wrong");
		}
	}
	
	public static void searchBook() {
		BookDao dao = new BookDao(DBConnection.getConnection());
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		Book b = dao.viewBook(id);
		
		if(b==null) {
			System.out.println("No book with the given ID");
		}
		else {
		System.out.println("Here are the book details");
		System.out.println("Book Name = "+b.getBookName());
		System.out.println("Book Author = "+b.getBookAuthor());
		System.out.println("Book Category = "+b.getBookCategory());
		}
	}
	
	public static void viewAllBooks() {
		BookDao dao = new BookDao(DBConnection.getConnection());
		List<Book> list = dao.getAllBooks();
		for(Book b:list) {
			System.out.println("Books Details");
			System.out.println("---------------------------");
			System.out.println("Id = "+b.getBookId());
			System.out.println("Book Name = "+b.getBookName());
			System.out.println("Author = "+b.getBookAuthor());
			System.out.println("Category = "+b.getBookCategory());
			System.out.println("-----------------------------");
		}
	}
	
	/* 
	===========================
		STUDENTS CODE
	===========================
	*/
	
	public static void addStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student reg no");
		String regno = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		
		//Setting the data to beans
		Student st = new Student();
		st.setRegno(regno);
		st.setPassword(password);
		
		//getting the method from dao.
		StudentDao dao = new StudentDao(DBConnection.getConnection());
		boolean f = dao.addStudent(st);
		if(f) {
			System.out.println("Student added successfully");
		}else {
			System.out.println("Something went wrong");
		}
	}
	
	public static void deleteStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student regno to delete");
		String regno = sc.next();
		Student st = new Student();
		st.setRegno(regno);
		StudentDao dao = new StudentDao(DBConnection.getConnection());
		boolean f = dao.deleteStudent(regno);
		
		if(f) {
			System.out.println("Student details deleted succesfully");
		}else {
			System.out.println("something went wrong");
		}
	}
	
	public static void updateStudent() {
		Scanner sc = new Scanner(System.in);
		Student st = new Student();
		System.out.println("Enter student regno");
		String regno = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		st.setRegno(regno);
		st.setPassword(password);
		StudentDao dao = new StudentDao(DBConnection.getConnection());
		
		boolean f = dao.editStudent(st);
		if(f) {
			System.out.println("Student details updated");
		}else {
			System.out.println("something went wrong");
		}
	}
	
	public static void searchStudent() {
		StudentDao dao = new StudentDao(DBConnection.getConnection());
		Scanner sc = new Scanner(System.in);
		String regno = sc.next();
		Student st = dao.viewStudent(regno);
		
		if(st==null) {
			System.out.println("No book with the given ID");
		}
		else {
		System.out.println("Here are the student details");
		System.out.println("Regno = "+st.getRegno());
		System.out.println("Password = "+st.getPassword());
		}
	}
	
	public static void viewAllStudents() {
		StudentDao dao = new StudentDao(DBConnection.getConnection());
		List<Student> list = dao.getAllStudents();
		for(Student st:list) {
			System.out.println("Books Details");
			System.out.println("---------------------------");
			System.out.println("regno = "+st.getRegno());
			System.out.println("password = "+st.getPassword());
			System.out.println("-----------------------------");
		}
	}
	
	
	/*
	 ===================================
	 			Main Code - Start
	 ===================================
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("********** Login Page ****************");
		System.out.println("1.Admin Login");
		System.out.println("2.Student Login");
		System.out.println("Select option");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				System.out.println("Enter your id");
				String id = sc.next();
				System.out.println("Enter password");
				String password = sc.next();
				if(id.equals("543") && password.equals("admin")) {
					System.out.println("*******************");
					System.out.println("Login Successful");
					System.out.println("*******************");
					boolean value = true;
					while(value) {
					System.out.println("Select your choice");
					System.out.println("1.Add a Book");
					System.out.println("2.Delete a Book");
					System.out.println("3.Update book details");
					System.out.println("4.Search book details");
					System.out.println("5.view All Books");
					System.out.println("6.Add a Student");
					System.out.println("7.Delete a Student");
					System.out.println("8.Update Student Details");
					System.out.println("9.Search Student");
					System.out.println("10.view all Students");
					System.out.println("11.Logout");
					int option = sc.nextInt();
					switch(option) {
					case 1:
						System.out.println("*** Add a Book ***");
						addBook();
						break;
					case 2:
						System.out.println("*** Delete a Book ***");
						deleteBook();
						break;
					case 3:
						System.out.println("*** Update book details ***");
						updateBook();
						break;
					case 4:
						System.out.println("*** Search a book ***");
						searchBook();
						break;
					case 5:
						System.out.println("*** view all books ***");
						viewAllBooks();
						break;
					case 6:
						System.out.println("*** Add Student ***");
						addStudent();
						break;
					case 7:
						System.out.println("*** Delete Student ***");
						deleteStudent();
						break;
					case 8:
						System.out.println("*** update Student ***");
						updateStudent();
						break;
					case 9:
						System.out.println("*** Search Student ***");
						searchStudent();
						break;
					case 10:
						System.out.println("*** view all Students ***");
						viewAllStudents();
						break;
					case 11:
						System.out.println("*** Thanks for using ***");
						System.out.println("*** Logged out successfully ***");
						value = false;
						break;
					}
				}
				}else {
					System.out.println("Invalid Credentials");
				}
				break;
			case 2:
				System.out.println("Enter your id");
				id = sc.next();
				System.out.println("Enter password");
				password = sc.next();
				
				viewAllBooks();
				break;
		}
			sc.close();	
	}
	
	/*
	 ===================================
	 			Main Code - END
	 ===================================
	 */
	
}

package test;

import java.util.List;
import java.util.Scanner;

import dao.BookDao;
import dto.BookModel;

public class BookSimulator 
{
	static Scanner sc1=new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		System.out.println("SELECT MODE OF OPERATION");
		System.out.println("1: ADD NEW BOOK");
		System.out.println("2: DELETE BOOK");
		System.out.println("3: DISPLAY BOOKS");
		
		int choice=sc1.nextInt();
		
		switch(choice)
		{
		case 1: storeBooks();
				break;
				
		case 2: removeBooks();
				break;
		
		case 3: displayBooks();
				break;
		}
	}
	
	static void storeBooks()
	{
		//accept the values from end user
		System.out.println("ENTER THE BOOK NAME");
		String bookName=sc1.next();
		
		System.out.println("ENTER THE BOOK PRICE");
		double bookPrice=sc1.nextDouble();
		
		System.out.println("ENTER THE BOOK AUTHOR");
		String bookAuthor=sc1.next();
		
		System.out.println("ENTER THE BOOK QTY");
		int bookQty=sc1.nextInt();
		
		//add all the values into the DTO Object
		BookModel bm=new BookModel();
		bm.setBookName(bookName);
		bm.setBookPrice(bookPrice);
		bm.setBookAuthor(bookAuthor);
		bm.setBookQty(bookQty);
		
		
		//create object of dao class 
		BookDao bd=new BookDao();
		int count=bd.addBooks(bm);
		
		//print the output 
		System.out.println(count+" BOOK INSERTED SUCCESSFULLY");
	}
	
	static void removeBooks()
	{
		//accept the book id from user
		System.out.println("ENTER BOOK ID");
		int bookId=sc1.nextInt();
		
		//add the book id into the DTO object
		BookModel bm=new BookModel();
		bm.setBookId(bookId);
		
		//call the method of dao class
		BookDao bd=new BookDao();
		int count=bd.deleteBooks(bm);
		
		//print the output
		System.out.println(count+" BOOK DELETED SUCCESSFULLY");
	}
	
	static void displayBooks()
	{
		//get the values from DTO object
		BookDao bd=new BookDao();
		List<BookModel> booklist=bd.showBooks();
		
		//print the output
		System.out.println("ID\tNAME\tPRICE\t\tAUTHOR\tQTY");
		System.out.println("--------------------------------------------------------------------------");
		for(BookModel b:booklist)	
		{
			System.out.println(b.getBookId()+"\t"+b.getBookName()+"\t"+b.getBookPrice()+"\t"+b.getBookAuthor()+"\t"+b.getBookQty());
		}
	}
}

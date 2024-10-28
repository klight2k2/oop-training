package model;

import java.util.ArrayList;
import java.util.Date;

public class Book extends BaseModel{
//	private int bookID;
    private String title;
    private String author;
    private String type;
    private String publisher;
    private int publishYear;
    private float price;
    private  static int countID=0;
//    private static int countBook;
//    private static ArrayList<Book> lstBook = new ArrayList<>();
    
    public Book(String title, String author, String type, String publisher, int publishYear, float price){
		this.title = title;
		this.author = author;
		this.type = type;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.price = price;
		this.ID= ++countID;
	}
    public void editBook(String title, String author, String type, String publisher, int publishYear, float price) {
        if (!title.isEmpty()) this.title = title;
        if (!author.isEmpty()) this.author = author;
        if (!type.isEmpty()) this.type = type;
        if (!publisher.isEmpty()) this.publisher = publisher;
        if (publishYear > 0) this.publishYear = publishYear; // Assuming valid year
        if (price >= 0) this.price = price; // Assuming valid price
    }

	


//	public int getBookID() {
//		return bookID;
//	}
//
//	public void setBookID(int bookID) {
//		this.bookID = bookID;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


//	public Book search(String searchKey) {
//		for (Book book : lstBook) {
//            if (book.title.equalsIgnoreCase(searchKey)) {
//                return book;
//            }
//        }
//        return null; // Book not found
//	}
//	public static void add(Book obj) {
//		lstBook.add(obj);
//		
//	}
//
//	public boolean remove(int id) {
//		 for (int i = 0; i < lstBook.size(); i++) {
//	            if (lstBook.get(i).bookID == id) {
//	                lstBook.remove(i);
//	                return true; // Book removed successfully
//	            }
//	        }
//	        return false; // Book not found
//	}

	
	public void print() {
		   System.out.printf(
		            "ID: %d, Title: %s, Author: %s, Type: %s, Publisher: %s, Publish Year: %s, Price: %.2f%n \n",
		            ID, title, author, type, publisher, publishYear, price
		        );
	}
//	public static void printAll() {
//		for (Book book : lstBook) {
//           book.print();
//        }
//        return null; // Book not found
//	}

}

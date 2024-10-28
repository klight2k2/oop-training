package controllers;

import java.util.ArrayList;
import model.Book;
import model.Customer;
public class BookController extends BaseController<Book>{
	private  ArrayList<Book> lstBook = new ArrayList<>();
	public BookController() {
		lstBook= new ArrayList<>();
	}

	@Override
	public Book search(String searchKey) {
		for (Book book : lstBook) {
            if (book.getTitle().contains(searchKey)) {
                return book;
            }
        }
        return null; // Book not found
	}

	@Override
	public boolean remove(int id) {
		for (int i = 0; i < lstBook.size(); i++) {
            if (lstBook.get(i).getID() == id) {
                lstBook.remove(i);
                return true; // Book removed successfully
            }
        }
        return false; // Book not found
	}
	public Book searchByID(int id) {
		for (Book book : lstBook) {
			if (book.getID()== id) {
				return book;
			}
		}
		return null;
	}

	@Override
	public void add(Book obj) {
		lstBook.add(obj);
		System.out.print("Add book successfully!");
		
	}
	
	public  void printAll() {
	for (Book book : lstBook) {
       book.print();
    }

}
}

package controllers;

import java.util.ArrayList;

import model.Book;
import model.Customer;

public class CustomerController extends BaseController<Customer> {
	private  ArrayList<Customer> lstCustomer;
	
	public CustomerController() {
		lstCustomer =new ArrayList<>();
	}

	@Override
	public Customer search(String searchKey) {
		for (Customer customer : lstCustomer) {
			if (customer.getUserName().equals(searchKey)) {
				return customer;
			}
		}
		return null;
	}
	public Customer searchByID(int id) {
		for (Customer customer : lstCustomer) {
			if (customer.getID()== id) {
				return customer;
			}
		}
		return null;
	}
	@Override
	public boolean remove(int id) {
		for (int i = 0; i < lstCustomer.size(); i++) {
			if (lstCustomer.get(i).getID() == id) {
				lstCustomer.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public void add(Customer obj) {
		lstCustomer.add(obj);
		
	}
	
	public  void printAll() {
	for (Customer cus : lstCustomer) {
		cus.print();
    }
}
}

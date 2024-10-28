package model;

import java.util.ArrayList;

public class Customer extends BaseModel {
//	private int customerID;
	private String name;
	private String phoneNo;
	private String userName;
	private String password;
	private String shippingAddress;
	private String billingAddress;
	private boolean isAdmin = false;
	private ArrayList<Order> lstOrdered;
	private Order cart;
	private static int countID = 0;

	public Order getCart() {
		return cart;
	}

	public void setCart(Order cart) {
		this.cart = cart;
	}

	// private static ArrayList<Customer> lstCustomer = new ArrayList<>();
	// private static int countCustomer = 0;

	public Customer(String name, String phoneNo, String userName, String password, String shippingAddress,
			String billingAddress) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.userName = userName;
		this.password = password;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.lstOrdered = new ArrayList<>();
		this.cart = new Order();
		this.ID = ++countID;
	}

	public Customer(String name, String phoneNo, String userName, String password, String shippingAddress,
			String billingAddress, boolean isAdmin) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.userName = userName;
		this.password = password;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.isAdmin = isAdmin;
		this.lstOrdered = new ArrayList<>();
		this.cart = new Order();
		this.ID = ++countID;
	}

	public void addToCart(OrderItem obj) {
		cart.add(obj);
	}

	public void editCustomer(String name, String phoneNo, String userName, String shippingAddress,
			String billingAddress) {
		if (!name.isEmpty())
			this.name = name;
		if (!phoneNo.isEmpty())
			this.phoneNo = phoneNo;
		if (!userName.isEmpty())
			this.userName = userName;
		if (!shippingAddress.isEmpty())
			this.shippingAddress = shippingAddress;
		if (!billingAddress.isEmpty())
			this.billingAddress = billingAddress;
	}

	public void pay() {
		this.lstOrdered.add(cart);
		this.cart.print();
		this.cart = new Order();
	}

	public void printLstOrdered() {
		if (lstOrdered.size() < 0)
			System.out.println("List ordered is empty!");
		for (Order order : lstOrdered) {
			order.print();
		}
	}

	public void print() {
		System.out.printf("CustomerID: %d, Name: %s, phoneNo:%s, password:%s, shippingAddress:%s, billingAddress:%s \n",
				this.ID, this.name, this.phoneNo, this.password, this.shippingAddress, this.billingAddress);

	}

	public boolean checkPassword(String pass) {
		return this.password.equals(pass);
	}

//	public int getCustomerID() {
//		return customerID;
//	}
//
//	public void setCustomerID(int customerID) {
//		this.customerID = customerID;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}

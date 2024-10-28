package model;

public class OrderItem extends BaseModel{
//	private int orderItemID;
	private Book book;
	private int quantity;
	private float price;
	private int countOrder = 0;
    private  static int countID=0;

//	public int getCartID() {
//		return orderItemID;
//	}
//
//	public void setCartID(int orderID) {
//		this.orderItemID = orderID;
//	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	public void print() {
		System.out.printf("Order Item ID: %d,Book: %s, Quantity: %d, Price %f \n",ID, book.getTitle(),quantity,price);
	}

	public OrderItem(Book book, int quantity) {
		this.book = book;
		this.quantity = quantity;
		this.price = book.getPrice() * (float)quantity;
		this.ID = ++countID;

//		this.orderItemID = ++countOrder;
	}
}

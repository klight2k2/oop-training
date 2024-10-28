package model;

import java.util.ArrayList;

enum PAYMENT {
	CASH,
}
//const int SHIPPING_FEE=3;
public class Order  extends BaseModel {
	private float shippingFee;
	private float total;
	private PAYMENT paymentMethod;
	private ArrayList<OrderItem> lstOrder;
    private  static int countID=0;

//	private int orderID;
//	private static int countOrderID;
	
	public Order() {
		lstOrder= new ArrayList<>();
		this.ID = ++countID;
	}
	
	public int getOrderSize() {
		return lstOrder.size();
	}
	public void add(OrderItem obj) {
		lstOrder.add(obj);
		calc();
		
	}

	public OrderItem search(String searchKey) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean remove(int id) {
		 for (int i = 0; i < lstOrder.size(); i++) {
	            if (lstOrder.get(i).getID() == id) {
	            	lstOrder.remove(i);
	            	calc();
	            	return true; // Book removed successfully
	            }
	        }
	        return false; // Book not found
	}	

	public float getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(float shippingFee) {
		this.shippingFee = shippingFee;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public PAYMENT getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PAYMENT paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void print() {
		 System.out.printf("OrderID: %d, PaymentMethod: %s, Total: %f\n", ID,paymentMethod,total);
		
	}
	
	public void printDetail() {
		if(lstOrder.size()<=0) System.out.println("List is empty!");
		for (int i = 0; i < lstOrder.size(); i++) {
			 lstOrder.get(i).print();
	        }
	}
	public void calc() {
		shippingFee=3;
		paymentMethod=PAYMENT.CASH;
		total=shippingFee;
		for(OrderItem ord:lstOrder) {	
			total+=ord.getPrice();
		}
		
	}
	

	
	

}

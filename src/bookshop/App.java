package bookshop;

import model.*;
import java.util.*;

import controllers.BookController;
import controllers.CustomerController;

public class App {
	private static Customer loginedCustomer;
	private BookController bookControler;
	private CustomerController customerController;

	public App() {
		bookControler = new BookController();
		customerController = new CustomerController();

	}

	public static void main(String[] args) {
		App app = new App();
		app.run();

	}

	public void printLogin() {
		Scanner scanner = new Scanner(System.in);
		Customer foundCustomer;
		while (true) {
			System.out.println("BOOKSHOP MANAGEMENT:LOGIN ");
			System.out.println("------------------------------------");
			System.out.println("Enter UserName:");
			String userName = scanner.nextLine();
			foundCustomer = customerController.search(userName);
			System.out.println("Enter Password:");
			String password = scanner.nextLine();
			if (foundCustomer == null || !foundCustomer.checkPassword(password)) {
				System.out.println("User or password wrong. Please try again!");
			} else
				break;
		}
		loginedCustomer = foundCustomer;
	}

	public void showAdminMenu() {

	}

	public void showMenu() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("BOOKSHOP MANAGEMENT:Homepage ");
			System.out.println("------------------------------------");
			System.out.println("1. View bookshop");
			System.out.println("2. View current cart");
			System.out.println("3. View ordered");
			if (loginedCustomer.isAdmin()) {
				System.out.println("4. view list user");

			}
			System.out.println("0. Exit");
			System.out.println("------------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");
			int choice = scanner.nextInt();

			switch (choice) {
				case 0: {
					return;
				}
				case 1:
					viewBookShop();
					// waitEnter();
					break;
				case 2:
					viewCurrentCart();
					break;
				// waitEnter();
				case 3:
					loginedCustomer.printLstOrdered();
					waitEnter();
					break;
				case 4:
					viewListUser();
					break;
				default:
					System.out.println("Please choose again!");
			}

		}
	}

	public void viewOrdered() {
		System.out.println("BOOKSHOP MANAGEMENT:View List Ordered ");
		loginedCustomer.printLstOrdered();

	}

	public void waitEnter() {
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		return;
	}

	public void viewBookShop() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("BOOKSHOP MANAGEMENT:View List Book ");
			bookControler.printAll();
			System.out.println("------------------------------------");
			System.out.println("1. Add to cart");
			System.out.println("2. Search book by name");
			if (loginedCustomer.isAdmin()) {
				System.out.println("3. Edit book");
				System.out.println("4. Add book");
				System.out.println("5. Remove book");
				System.out.println("0. Back");
				System.out.println("------------------------------------");
				System.out.println("Please choose a number: 0-1-2-3-4-5:");
			} else {

				System.out.println("0. Back");
				System.out.println("------------------------------------");
				System.out.println("Please choose a number: 0-1-2:");
			}
			int choice = scanner.nextInt();

			switch (choice) {
				case 0:
					return;
				case 1: {
					handleAddToCart();
					break;
				}
				case 2:
					handleSearchBook();
					break;
				case 3:
					handleEditBook();
					break;
				case 4:
					handleAddBook();
					break;
				case 5:
					handleRemoveBook();
					break;
				default:
					System.out.println("Please choose again!");
			}
		}

	}

	public void viewListUser() {
		if (!loginedCustomer.isAdmin())
			return;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("BOOKSHOP MANAGEMENT:View List User ");
			customerController.printAll();
			System.out.println("------------------------------------");
			System.out.println("1. Add customer");
			System.out.println("2. Edit customer");
			System.out.println("3. Remove customer");
			System.out.println("0. Back");
			System.out.println("------------------------------------");
			System.out.println("Please choose a number: 0-1-2:");
			int choice = scanner.nextInt();

			switch (choice) {
				case 0:
					return;
				case 1: {
					handleAddCustomer();
					break;
				}
				case 2:
					handleEditCustomer();
					break;
				case 3:
					handleRemoveCustomer();
					break;
				default:
					System.out.println("Please choose again!");
			}
		}

	}

	public void handleAddCustomer() {
		if (loginedCustomer.isAdmin()) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("BOOKSHOP MANAGEMENT:Add customer ");

			System.out.print("Enter customer name: ");
			String name = scanner.nextLine();

			System.out.print("Enter phone number: ");
			String phoneNo = scanner.nextLine();

			System.out.print("Enter username: ");
			String userName = scanner.nextLine();

			System.out.print("Enter password: ");
			String password = scanner.nextLine(); // Consider hashing this in a real

			System.out.print("Enter shipping address: ");
			String shippingAddress = scanner.nextLine();

			System.out.print("Enter billing address: ");
			String billingAddress = scanner.nextLine();

			Customer newCustomer = new Customer(name, phoneNo, userName, password,
					shippingAddress, billingAddress);
			customerController.add(newCustomer);
		}
	}

	// Method to handle editing an existing customer
	public void handleEditCustomer() {
		if (loginedCustomer.isAdmin()) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("BOOKSHOP MANAGEMENT:Edit Customer ");
			System.out.print("Enter the ID of the customer to edit: ");
			String searchKey = scanner.nextLine();
			Customer foundCusCustomer = customerController.search(searchKey);
			if (foundCusCustomer == null)

				System.out.println("Customer not found.");
			else {

				System.out.print("Edit customer name (leave empty to keep current): ");
				String newName = scanner.nextLine();

				System.out.print("Edit phone number (leave empty to keep current): ");
				String newPhoneNo = scanner.nextLine();

				System.out.print("Edit username (leave empty to keep current): ");
				String newUserName = scanner.nextLine();

				System.out.print("Edit shipping address (leave empty to keep current): ");
				String newShippingAddress = scanner.nextLine();

				System.out.print("Edit billing address (leave empty to keep current): ");
				String newBillingAddress = scanner.nextLine();

				foundCusCustomer.editCustomer(
						newName,
						newPhoneNo,
						newUserName,
						newShippingAddress,
						newBillingAddress);

				System.out.print("Book updated: ");
				foundCusCustomer.print();
			}
		}
	}

	public void viewCurrentCart() {
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			Order currentCart = loginedCustomer.getCart(); 
			System.out.println("BOOKSHOP MANAGEMENT:View Current Cart");
			currentCart.printDetail();
			System.out.println("------------------------------------");
			System.out.println("1. Delete item");
			System.out.println("2. Pay");
			System.out.println("0. Back ");
			System.out.println("------------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			int choice = scanner.nextInt();

			switch (choice) {
				case 1: {
					handleAddToCart();
					break;
				}
				case 2:
					loginedCustomer.pay();
					waitEnter();
					break;
				case 0:
					return;
				default:
					System.out.println("Please choose again!");
					break;
			}
		}
	}

	public void handleDeleteOrderItem() {
		Scanner scanner = new Scanner(System.in);
		Order currentCart = loginedCustomer.getCart();
		if (currentCart.getOrderSize() <= 0) {
			System.out.println("Cart is empty!");
			return;
		}
		;
		while (true) {
			System.out.println("BOOKSHOP MANAGEMENT:Delete Order Item");
			System.out.println("------------------------------------");
			System.out.println("Enter Order ID:");
			System.out.println("0. Back ");
			System.out.println("------------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			int choice = scanner.nextInt();
			if (choice != 0) {
				currentCart.remove(choice);
				System.out.println("Remove success fully");
			} else
				return;
		}
	}

	public void handleSearchBook() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("BOOKSHOP MANAGEMENT:Search Book ");
		// System.out.println("Enter 0 to back");
		System.out.println("------------------------------------");
		System.out.println("Enter book name:");

		String searchKey = scanner.nextLine();
		Book foundBook = bookControler.search(searchKey);
		if (foundBook == null)
			System.out.println("Not found book!");
		else
			foundBook.print();
		return;
	}

	public void handleRemoveBook() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("BOOKSHOP MANAGEMENT:Remove Book ");
		System.out.println("------------------------------------");
		System.out.println("Enter book ID:");
		int removeID = scanner.nextInt();
		if (bookControler.remove(removeID)) {
			System.out.println("Remove book successfully!");
		} else
			System.out.println("Remove book fail");
		return;
	}

	public void handleRemoveCustomer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("BOOKSHOP MANAGEMENT:Remove Customer ");
		System.out.println("------------------------------------");
		System.out.println("Enter customer ID:");
		int removeID = scanner.nextInt();
		if (customerController.remove(removeID)) {
			System.out.println("Remove customer successfully!");
		} else
			System.out.println("Remove customer fail");
		return;
	}

	public void handleAddBook() {
		if (loginedCustomer.isAdmin()) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("BOOKSHOP MANAGEMENT:Add Book ");
			System.out.print("Enter book title: ");
			String title = scanner.nextLine();

			System.out.print("Enter author name: ");
			String author = scanner.nextLine();

			System.out.print("Enter book type: ");
			String type = scanner.nextLine();

			System.out.print("Enter publisher name: ");
			String publisher = scanner.nextLine();

			System.out.print("Enter publish year: ");
			int publishYear = Integer.parseInt(scanner.nextLine());

			System.out.print("Enter price: ");
			float price = Float.parseFloat(scanner.nextLine());

			Book book = new Book(title, author, type, publisher, publishYear, price);
			bookControler.add(book);
		}
	}

	public void handleEditBook() {
		if (loginedCustomer.isAdmin()) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("BOOKSHOP MANAGEMENT:Edit Book ");
			System.out.print("Enter the ID of the book to edit: ");
			String searchKey = scanner.nextLine();
			Book foundBook = bookControler.search(searchKey);
			if (foundBook == null)
				System.out.println("Not found book!");
			else {

				System.out.print("Edit book title (leave empty to keep current): ");
				String newTitle = scanner.nextLine();

				System.out.print("Edit author name (leave empty to keep current): ");
				String newAuthor = scanner.nextLine();

				System.out.print("Edit book type (leave empty to keep current): ");
				String newType = scanner.nextLine();

				System.out.print("Edit publisher name (leave empty to keep current): ");
				String newPublisher = scanner.nextLine();

				System.out.print("Edit publish year (enter 0 to keep current): ");
				int newPublishYear = Integer.parseInt(scanner.nextLine());

				System.out.print("Edit price (enter -1 to keep current): ");
				float newPrice = Float.parseFloat(scanner.nextLine());

				foundBook.editBook(newTitle, newAuthor, newType, newPublisher,
						newPublishYear > 0 ? newPublishYear : foundBook.getPublishYear(),
						newPrice >= 0 ? newPrice : foundBook.getPrice());
				System.out.print("Book updated: ");
				foundBook.print();
			}
		}
		// System.out.print("Enter price: ");
	}

	public void handleAddToCart() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("BOOKSHOP MANAGEMENT:Add to cart");
			bookControler.printAll();
			System.out.println("------------------------------------");
			System.out.println("Enter Book ID:");

			int choice = scanner.nextInt();

			if (choice == 0) {
				return;
			} else {
				Book foundBook = bookControler.searchByID(choice);
				if (foundBook == null)
					System.out.println("Not found book");
				else {
					System.out.println("Enter quantity:");
					int quantity = scanner.nextInt();
					OrderItem newItem = new OrderItem(foundBook, quantity);
					loginedCustomer.addToCart(newItem);
				}
				return;
			}

		}
	}

	public void run() {
		initDb();
		printLogin();
		showMenu();
	}

	public void initDb() {
		customerController.add(new Customer("Nguyen Van A", "0901-234-567", "nguyenvana", "passwordA",
				"123 Pho Hue, Ha Noi", "456 Duong Le Loi, Ha Noi"));
		customerController.add(new Customer("Tran Thi B", "0901-234-568", "tranthib", "passwordB",
				"789 Pho Hang Dao, Ha Noi", "101 Duong Nguyen Thi Minh Khai, Ha Noi"));
		customerController.add(new Customer("Le Van C", "0901-234-569", "levanc", "passwordC",
				"234 Pho Ba Trieu, Ha Noi", "567 Duong Tran Hung Dao, Ha Noi"));
		customerController.add(new Customer("Pham Thi D", "0901-234-570", "phamthid", "passwordD",
				"345 Pho Dinh Tien Hoang, Ha Noi", "678 Duong Phan Dinh Phung, Ha Noi"));
		customerController.add(new Customer("Ngo Van E", "0901-234-571", "ngovanE", "passwordE",
				"456 Pho Trang Tien, Ha Noi", "789 Duong Ngoc Khanh, Ha Noi"));
		customerController.add(new Customer("Do Thi F", "0901-234-572", "dothif", "passwordF",
				"567 Pho Hang Be, Ha Noi", "890 Duong Hang Bac, Ha Noi"));
		customerController.add(new Customer("Bui Van G", "0901-234-573", "buivang", "passwordG",
				"678 Pho Ly Thuong Kiet, Ha Noi", "901 Duong Pho Co, Ha Noi"));
		customerController.add(new Customer("Vu Thi H", "0901-234-574", "vuthih", "passwordH",
				"789 Pho Tay Son, Ha Noi", "012 Duong Le Duan, Ha Noi"));
		customerController.add(new Customer("Ho Van I", "0901-234-575", "hovani", "passwordI",
				"890 Pho Nguyen Trai, Ha Noi", "123 Duong Tran Quoc Toan, Ha Noi"));
		customerController.add(new Customer("Nguyen Thi J", "0901-234-576", "admin", "1", "901 Pho Hang Gai, Ha Noi",
				"234 Duong Bach Mai, Ha Noi", true));
		customerController.printAll();

		bookControler.add(new Book("Java Programming", "John Doe", "Educational", "Tech Publishers", 2022, 29));
		bookControler.add(new Book("Effective Java", "Joshua Bloch", "Programming", "Addison-Wesley", 2018, 45));
		bookControler.add(new Book("Clean Code", "Robert C. Martin", "Programming", "Prentice Hall", 2008, 39));
		bookControler.add(new Book("Design Patterns", "Erich Gamma", "Programming", "Addison-Wesley", 1994, 50));
		bookControler.add(
				new Book("The Pragmatic Programmer", "Andrew Hunt", "Programming", "Addison-Wesley", 1999, 42));
		bookControler.add(
				new Book("Introduction to Algorithms", "Thomas H. Cormen", "Educational", "MIT Press", 2009, 85));
		bookControler
				.add(new Book("The Clean Coder", "Robert C. Martin", "Programming", "Prentice Hall", 2011, 35));
		bookControler.add(new Book("Head First Java", "Kathy Sierra", "Educational", "O'Reilly Media", 2005, 29));
		bookControler.add(
				new Book("Java Concurrency in Practice", "Brian Goetz", "Programming", "Addison-Wesley", 2006, 49));
		bookControler.add(new Book("Thinking in Java", "Bruce Eckel", "Educational", "Prentice Hall", 2006, 39));
	}

}

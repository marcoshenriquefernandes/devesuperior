package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);			
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		
		System.out.println("Enter cliente data:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth date: ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(nome, email, birthDate);
		
		sc.nextLine();
		System.out.println("Enter order data:");		
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		
		
		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String name = sc.nextLine();
			
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(name, price);
			OrderItem item = new OrderItem(quantity, price, product);
			
			order.addItem(item);			
		}
		
		showOrder(order);
		
		sc.close();
	}
	
	public static void showOrder(Order order) {
		System.out.println("");
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
	}

}

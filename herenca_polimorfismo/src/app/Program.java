package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
						
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		System.out.println("");
		for (int i = 1; i <= n; i++) {			
			System.out.println("Product #" + i + " data:");
			
			System.out.print("Common, used or imported (c/u/i)? ");
			char op = sc.next().charAt(0);
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("price: ");
			double price = sc.nextDouble();
			
			if (op == 'i') {
				System.out.print("Customs fee: ");
				double customFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customFee));
			} else if (op == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				products.add(new UsedProduct(name, price, manufactureDate));
			} else {
				products.add(new Product(name, price));
			}
			System.out.println("");
		}
		
		System.out.println("PRICE TAGS:");
		
		for (Product product : products) {
			System.out.println(product.priceTag());
		}
				
		sc.close();
	}

}

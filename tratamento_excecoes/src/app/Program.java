package app;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.entities.exceptions.EntitiesException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account account;

		for (int i = 1; i <= 4; i++) {
			System.out.println(i + "o example");

			try {
				account = addAccount(sc);
				
				System.out.println("");
				System.out.print("Enter amount for withdraw: ");
				double withdraw = sc.nextDouble();
				
				account.withdraw(withdraw);
				System.out.println("New banlace: " + String.format("%.2f", account.getBalance()));		
			} catch (EntitiesException e) {
				System.out.println("Withdraw error: " + e.getMessage());
			} catch (RuntimeException e) {
				System.out.println("Unexpected error");
			}
			System.out.println("");
		}
		sc.close();
	}

	public static Account addAccount(Scanner sc) {
		sc.useLocale(Locale.US);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();

		sc.nextLine();
		System.out.print("Holder: ");
		String holder = sc.nextLine();

		System.out.print("Initial balance: ");
		double initialBalance = sc.nextDouble();

		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();

		return (new Account(number, holder, initialBalance, withdrawLimit));
	}

}

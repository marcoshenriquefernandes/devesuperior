package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);	
		List<TaxPayer> taxpayers = new ArrayList<>();
		int iterations = 0;
		TaxPayer taxPayer = null;
				
		System.out.print("Quantos contribuintes você vai digitar? ");
		iterations = sc.nextInt();
		
		System.out.println("");
		for (int i = 0; i < iterations; i++) {
			System.out.printf("Digite os dados do  %do contribuinte: %n", (i + 1));
			
			System.out.print("Renda anual com salário: ");
			double salary = sc.nextDouble();
			
			System.out.print("Renda anual com prestação de serviço: ");
			double service = sc.nextDouble();
			
			System.out.print("Renda anual com ganho de capital: ");
			double capital = sc.nextDouble();
			
			System.out.print("Gastos médicos: ");
			double health = sc.nextDouble();
			
			System.out.print("Gastos educacionais: ");
			double education = sc.nextDouble();
			
			taxPayer = new TaxPayer(salary, service, capital, health, education);
			taxpayers.add(taxPayer);
			System.out.println("");
		}
		
		int i = 1;
		for (TaxPayer taxpayer : taxpayers) {			
			System.out.printf("Resumo do %do contribuinte:%n", i++);
			System.out.println(taxpayer);
		}

		sc.close();
	}

}

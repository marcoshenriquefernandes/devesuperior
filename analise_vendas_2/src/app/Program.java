package app;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Sale;
import repository.SaleCsvHandler;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SaleCsvHandler sch = new SaleCsvHandler();
		
		System.out.print("Entre o caminho do arquivo: ");
		String path = sc.nextLine();
		
		try {
			List<Sale> list = sch.readCsvSale(path);
							
			Map<String, Double> totals = list.stream()
				    .collect(Collectors.groupingBy(Sale::getSeller, Collectors.summingDouble(Sale::getTotal)));

			System.out.println("\nTotal de vendas por vendedor:");
			totals.forEach((name, sum) -> {
		    	System.out.println(name + " - R$ " + String.format("%.2f", sum));
		    });			
		} catch (IOException e) {
			System.out.println("Erro: " + path + " (O sistema não pode encontrar o arquivo especificado)");
		}

		sc.close();
	}
}

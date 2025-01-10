package app;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
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
			
			Comparator<Sale> comp = (s1, s2) -> s1.averagePrice().compareTo(s2.averagePrice());
			List<Sale> seles = list.stream()
					.filter(s -> s.getYear() == 2016)
					.sorted(comp.reversed())
					.limit(5)
					.collect(Collectors.toList());
			
			System.out.println();
			System.out.println("Cinco primeiras vendas de 2016 de maior preço médio");		
			seles.forEach(System.out::println);

			double sumLogan = list.stream()
					.filter(s -> (s.getMonth() == 1 || s.getMonth() == 7) && s.getSeller().toUpperCase().equals("LOGAN"))
					.map(s -> s.getTotal())
					.reduce(0.0, (x, y) -> x + y);
			
			System.out.println();
			System.out.printf("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = %.2f", sumLogan);			
		} catch (IOException e) {
			System.out.println("Erro: " + path + " (O sistema não pode encontrar o arquivo especificado)");
		}
		
		sc.close();
	}
}

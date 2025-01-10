package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Sale;

public class SaleCsvHandler {
	
	public List<Sale> readCsvSale(String path) throws IOException {
		List<Sale> list = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String line;
			
			while ((line = br.readLine()) != null){
				String[] fields = line.split(",");
				int month = Integer.parseInt(fields[0]);
				int year = Integer.parseInt(fields[1]);
				String seller = fields[2];
				int items = Integer.parseInt(fields[3]);
				double total = Double.parseDouble(fields[4]);
				
				list.add(new Sale(month, year, seller, items, total));
			}			
		}
		return list;
	}
}

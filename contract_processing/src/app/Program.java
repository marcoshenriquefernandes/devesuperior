package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato:");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		
		System.out.print("Data (dd/MM/yyyy): ");
		Date date = null;
		try {
			date = sdf.parse(sc.next());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.print("Valor do contrato: ");
		double value = sc.nextDouble();
		
		System.out.print("Entre com o numero de parcelas: ");
		int months = sc.nextInt();
		
		Contract contract = new Contract(number, date, value);
		ContractService service = new ContractService(new PaypalService());
		service.processContract(contract, months);
		
		System.out.println("");
		System.out.println("Parcelas:");
		
		for (Installment installment : contract.getInstallments()) {
			System.out.println(installment);
		}
		
		sc.close();
	}

}

package model.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
		
	public void processContract(Contract contract, Integer months) {
		double installmentValue = contract.getTotalValue() / months;
		
		for (int i = 1; i <= months; i++) {
			double interestValue = this.onlinePaymentService.interest(installmentValue, i);
			double totalValue = this.onlinePaymentService.paymentFee(interestValue);
			
	        Date dueDate = contract.getDate();
	        LocalDate localDate = dueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	        LocalDate newDate = localDate.plusMonths(i);	        
	        dueDate = Date.from(newDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	        
	        Installment installment = new Installment(dueDate, totalValue);
	        
	        contract.addInstallments(installment);
		}
	}

}

package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	
	private final static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date dueDate;
	private Double amount;
	
	public Installment() {}

	public Installment(Date dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {		
		return sdf.format(this.getDueDate()) 
		           + " - " 
		           + String.format("%.2f", this.getAmount());
	}
}

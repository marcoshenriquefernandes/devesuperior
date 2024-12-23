package model.entities;

import model.entities.exceptions.EntitiesException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(Double amount) {
		this.balance = this.getBalance() + amount;
	}
	
	public void withdraw(double amount) {
		if (amount > this.getWithdrawLimit()) {
			throw (new EntitiesException("The amount exceeds withdraw limit"));
		}
		if (amount > this.getBalance()) {
			throw (new EntitiesException("Not enough balance"));
		}
		this.balance = this.getBalance() - amount;
	}

}

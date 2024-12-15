package entities;

public class TaxPayer {
	private Double salaryIncome;
	private Double serviceIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	public TaxPayer(Double salaryIncome, Double serviceIncome, Double capitalIncome, Double healthSpending, Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.serviceIncome = serviceIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}
	
	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public Double getServiceIncome() {
		return serviceIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public Double salaryTax() {
		double salary = this.getSalaryIncome() / 12;
		
		if (salary > 3000 && salary <= 5000)
			return this.getSalaryIncome() * 0.10;
		else if (salary > 5000)
			return this.getSalaryIncome() * 0.20;
		else
			return this.getSalaryIncome();
	}
	
	public Double serviceTax() {
		return (this.getServiceIncome() > 0 ? this.getServiceIncome() * 0.15 : this.getServiceIncome() * 0.0);
	}
	
	public Double capitalTax() {
		return (this.getCapitalIncome() > 0) ? this.getCapitalIncome() * 0.20 : this.getCapitalIncome() + 0.0;
	}
	
	public Double grossTax() {
		return this.salaryTax() + this.serviceTax() + this.capitalTax();
	}
	
	public Double taxRebate() {
		double spending = this.getHealthSpending() + this.getEducationSpending();
		double rebate = this.grossTax() * 0.30;
		return (spending < rebate) ? spending : rebate;
	}
	
	public Double netTax() {
		return this.grossTax() - this.taxRebate();
	}
	
	public String toString() {
		return "Imposto bruto total: " + String.format("%.2f%n", this.grossTax()) +
			   "Abatimento: " + String.format("%.2f%n", this.taxRebate()) +
			   "Imposto devido: " + String.format("%.2f%n", this.netTax());		
	}

}

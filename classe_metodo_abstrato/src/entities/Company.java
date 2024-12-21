package entities;

public class Company extends TaxPayer {

	private Integer numberOfEmployee;
	
	public Company() {
		super();
	}

	public Company(String name, Double anualIncome, Integer numberOfEmployee) {
		super(name, anualIncome);
		this.numberOfEmployee = numberOfEmployee;
	}

	public Integer getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(Integer numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

	@Override
	public Double tax() {			
		return (this.getNumberOfEmployee() > 10) ? this.getAnualIncome() * 0.14 : this.getAnualIncome() * 0.16;
	}
	
}

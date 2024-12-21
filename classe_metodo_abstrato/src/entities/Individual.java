package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;
	
	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {
		
		if (this.getAnualIncome() < 20000.00)
			return this.getAnualIncome() * 0.15 - this.healthExpenditures * 0.5;					
		else
			return this.getAnualIncome() * 0.25 - this.healthExpenditures * 0.5;
	}

}

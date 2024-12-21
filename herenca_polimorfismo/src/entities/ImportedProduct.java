package entities;

public class ImportedProduct extends Product {
	
	private Double customFee;
	
	public ImportedProduct() {}

	public ImportedProduct(String name, Double price, Double customFee) {
		super(name, price);
		this.customFee = customFee;
	}

	public Double getCustomFee() {
		return customFee;
	}

	public void setCustomFee(Double customFee) {
		this.customFee = customFee;
	}

	public String priceTag() {
		return this.getName() + " $ " + String.format("%.2f", this.getPrice()) + " (Customs fee: $ " + String.format("%.2f", this.getCustomFee()) + ")";
	}
}

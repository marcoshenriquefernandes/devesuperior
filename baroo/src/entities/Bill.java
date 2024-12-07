package entities;

public class Bill {	
	public char gender;
	public int beer;
	public int barbecue;
	public int softDrink;
	
	public double cover() {
		return 4.00;
	}
	
	public double feeding() {
		double beerValue = 5;
		double barbecueValue = 7;
		double softDrinkValue = 3;
		
		return ((beerValue * beer) + (barbecueValue * barbecue) + (softDrinkValue * softDrink));
	}
	
	public double ticket() {
		if (gender == 'F') {
			return 8.00;
		} else {
			return 10.00;
		}
	}
	
	public double total() {
		return (feeding() > 30) ? ticket() + feeding() : ticket() + feeding() + cover();
	}

}

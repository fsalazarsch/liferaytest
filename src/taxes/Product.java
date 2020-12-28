package taxes;

import java.text.DecimalFormat;

public class Product {
	
	private String name;
	private double price;
	private String type;
	private boolean imported;
	
	
	Product(String name, double price, String type, boolean imported){
		this.name = name;
		this.price = price;
		this.type = type;
		this.imported = imported;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}
	
	public double calctax() {
		String type = this.getType();
		double base = this.getPrice(); 
		double tax = 0;
		
		if ((!type.equals("book")) && (!type.equals("food")) && (!type.equals("medical")))
			tax += 0.1;
		
		if (this.isImported() == true)
			tax += 0.05;

		//return Double.parseDouble( df.format(base *tax));
		if (tax == 1)
			return base;
		return base*tax;
	}
	
	
	
	@Override
	public String toString() {
		
		DecimalFormat df = new DecimalFormat("0.00");      
		return  name+ ": " + df.format( this.getPrice() +  Math.round(this.calctax() *20.00) / 20.00);
	}
	
	
	
}

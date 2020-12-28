package taxes;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class Taxes extends TaxesTest{
	
	private double ans= 0, answtax= 0;	
	private List<Product> sale= new ArrayList<>();	

	public List<Type> bdd = new ArrayList<>();	
	
	public Taxes() {
		bdd.add( new Type("book", "book"));
		bdd.add( new Type("music CD", "other"));
		bdd.add( new Type("chocolate bar", "food"));
		bdd.add( new Type("box of chocolates", "food"));
		bdd.add( new Type("bottle of perfume", "other"));
		bdd.add( new Type("packet of headache pills", "medical"));
	}
	
	// Basic sales tax is applicable at a rate of 10% on all goods, 
	// except books, food, and medical products that are exempt. 
	//additional sales tax applicable on all imported goods 5%.
	
	public String line_to_Prod(String line) {
		//1 book at 12.49
		
		String[] l = line.split(" at ");
		double pri = Double.parseDouble(l[1]);
		Type type = new Type();
		
		boolean imp = false;
		if (l[0].contains("imported"))
			imp = true;
		
		String[] l2 = l[0].split(" ", 2);
		String tipo ="";
		
		Iterator<Type> iter = bdd.iterator(); 
		
		while (iter.hasNext()) { 
			type = iter.next();
            if (l2[1].contains(type.getNameproduct()))
            tipo = type.getNametype();
        } 
		
		//System.out.println(l2[1]+" "+pri+" "+tipo+" "+imp);
		
		Product p = new Product(l2[1], pri, tipo, imp);
		this.sale.add(p);
		
		return p.toString();
		
	}
	
	public String total(List<Product> prods) {
		
		String res = "";
		this.setAns(0);
		this.setAnswtax(0);
		
		Iterator<Product> iter = prods.iterator(); 
		while (iter.hasNext()) {
			Product ans = iter.next();
            this.setAns(this.getAns() + Math.round(ans.calctax() *20.00) / 20.00);
            this.setAnswtax(this.getAnswtax() + ans.getPrice() );
		}
				
		DecimalFormat df2 = new DecimalFormat("0.00");      
		DecimalFormat df = new DecimalFormat("0.00");      
		
		

		//res += "Sales Taxes: "+ Math.round( (this.getAns()- this.getAnswtax()) *100.0) / 100.0+ "\n";
		//res += "Total: "+ round( this.getAns(), BigDecimal.valueOf(0.05), RoundingMode.UP );

		 
		res += "Sales Taxes: "+ df2.format( Math.round( this.getAns()  *20.00) / 20.00)+"\n";	
		res += "Total: "+ df.format(this.getAnswtax() + this.getAns());	
		
		return res;
		
	}
	
	public String ejercicio(List<String> lista) {
		
		String res = "", cantidad= "", line;
		
		Iterator<String> iter = lista.iterator(); 
		while (iter.hasNext()) {
			line = iter.next();
			cantidad = line.split(" ", 2)[0];
			res += cantidad+" ";
            res += 	line_to_Prod(line)+"\n";
		}
		
		res += total(this.sale);		
		return res;
		
	}

	public static List<String> leertxt(String nombretxt){
		
		List<String> arch= new ArrayList<>();
		try {
			File myObj = new File(nombretxt);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				arch.add(data);
				}
			myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("error");
				e.printStackTrace();
				}
		return arch;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
	}

	public double getAns() {
		return ans;
	}

	public void setAns(double ans) {
		this.ans = ans;
	}

	public double getAnswtax() {
		return answtax;
	}

	public void setAnswtax(double answtax) {
		this.answtax = answtax;
	}
}

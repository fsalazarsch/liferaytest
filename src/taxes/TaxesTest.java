package taxes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TaxesTest {
	
	Taxes tax;
	
	@BeforeEach
	public void before() {
		tax = new Taxes();
	}

	@AfterEach
	public void after() {
		
		}

	@Test
	public void totaltest() {
		
		List<Product> sale = new ArrayList<>();
		
		Product p = new Product("book", Double.parseDouble("12.49"), "book", false);
		sale.add(p);
		p = new Product("music CD", Double.parseDouble("14.99"), "other", false);
		sale.add(p);
		p = new Product("chocolate bar",Double.parseDouble("0.85"), "food", false);
		sale.add(p);
				
		String esperado = tax.total(sale);
		//System.out.print(esperado);
		
		assertEquals(esperado, ("Sales Taxes: 1.50\nTotal: 29.83"));
	}

		
	@Test
	public void line_to_Prodtest() {
		
		//String line = tax.line_to_Prod("1 book at 12.49");
		//Product p = new Product("book", Double.parseDouble("12.49"), "book", false);
		
		String line = tax.line_to_Prod("1 music CD at 14.99");
		Product p = new Product("music CD", Double.parseDouble("14.99"), "other", false);
		//16.49
		
		String esperado = p.toString(); 
		//System.out.print(esperado);
		assertEquals(esperado, line);
	}
	
	@Test
	public void ejerciciotest() {
		
		List<String> input = new ArrayList<String>();
		String output = "";
		
		/*input.add("1 book at 12.49");
		input.add("1 music CD at 14.99");
		input.add("1 chocolate bar at 0.85");
		
		output = "1 book: 12.49\n" + 
				"1 music CD: 16.49\n" + 
				"1 chocolate bar: 0.85\n" + 
				"Sales Taxes: 1.50\n" + 
				"Total: 29.83";
		
		
		assertEquals(output, tax.ejercicio(input) );*/
		
		input.add("1 imported box of chocolates at 10.00"); 
		input.add("1 imported bottle of perfume at 47.50");
		
		output = "1 imported box of chocolates: 10.50\n" + 
				"1 imported bottle of perfume: 54.65\n" + 
				"Sales Taxes: 7.65\n" + 
				"Total: 65.15";
		assertEquals(output, tax.ejercicio(input) );

	}
}

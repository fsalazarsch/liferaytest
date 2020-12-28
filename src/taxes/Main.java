package taxes;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Taxes t = new Taxes();
		System.out.println("Ejercicio 1\n============");
		System.out.println(t.ejercicio(Taxes.leertxt("src/res/ejemplo1.txt")));		
		System.out.println("=========================================");
		t = new Taxes();
		System.out.println("Ejercicio 2\n============");
		System.out.println(t.ejercicio(Taxes.leertxt("src/res/ejemplo2.txt")));		
		System.out.println("=========================================");
	}

}

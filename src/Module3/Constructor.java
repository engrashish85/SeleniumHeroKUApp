package Module3;

public class Constructor {
	
	String mod;
	int price;
	static int wheels = 4;
	
	public Constructor () {
		System.out.println("in Construtor argument - no constructor called");
	}
	
	/*public Constructor (String m, int p) {
		mod = m;
		price = p;
	}*/
	
	public Constructor (String mod, int price) {
		this.mod = mod;
		this.price = price;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Constructor c1 = new Constructor ();
		Constructor c2 = new Constructor ("Lamborghini", 21333);
		System.out.println(c2.mod);
		System.out.println(c2.price);
		System.out.println(c1.mod);
		System.out.println(c1.price);
		
		
	}

}

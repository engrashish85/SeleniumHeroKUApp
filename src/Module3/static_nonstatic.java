package Module3;

public class static_nonstatic {
	
	String mod;
	int price;
	static int wheels;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		static_nonstatic objectReference1 = new static_nonstatic();
		objectReference1.mod = "Ferrari";
		objectReference1.price = 9000;
		//objectReference1.wheels = 4;
		wheels = 4;
		
		static_nonstatic objectReference2 = new static_nonstatic();
		objectReference2.mod = "Maruti";
		objectReference2.price = 8000;
		//objectReference2.wheels = 4;
		
		objectReference1.start();
		wheels = 8;
		objectReference2.start();
		objectReference1.accel();
		objectReference2.accel();
	}
	
	public void start() {
		System.out.println(wheels);
	}
	
	public void accel () {
		System.out.println(mod);
	}
}

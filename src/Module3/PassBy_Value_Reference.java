package Module3;

public class PassBy_Value_Reference {
	
	int x = 10;
	int y = 20;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		PassBy_Value_Reference p = new PassBy_Value_Reference();
		p.x = 10;
		p.y = 20;
		System.out.println(p.x + "**" + p.y);
		swapByValue (p.x, p.y);
		System.out.println(p.x + "**" + p.y);
		swapByReference (p);
		System.out.println(p.x + "**" + p.y);
	}
	
	public static void swapByValue (int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	public static void swapByReference (PassBy_Value_Reference t){
		int temp = t.x;
		t.x = t.y;
		t.y = temp;
	}
}

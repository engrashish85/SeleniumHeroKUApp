package Module4;

public class Exception_Stack {
	public static void main (String[] args) {
		clickLink ();
	}
	
	public static void clickLink () {
		loadPage ();
	}
	public static void loadPage () {
		try {
			int i[] = new int [3];
			i[3] = 102;
		} catch (Exception e) {
			System.out.println("Error message "+e.getLocalizedMessage());
		}
		
	}
	
	public void SomeMethod () {
		try {
			int i[] = new int [3];
			i[3] = 102;
		} catch (Exception e) {
			System.out.println("Error message "+e.getLocalizedMessage());
		}
		
	}

}

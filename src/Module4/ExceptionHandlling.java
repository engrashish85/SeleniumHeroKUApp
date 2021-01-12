package Module4;

public class ExceptionHandlling {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			xyz();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error 1");
			e.printStackTrace();
			}
	}
		public static void xyz() throws Exception{
			throw new Exception("Some exception");
		}
		}

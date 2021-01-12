package Module5;

public class TestBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank b = new HSBCBank();
		b.credit();
		b.debit();
		b.transferMoney();
		System.out.println("Called Overriden methods in an interface");
	}

}

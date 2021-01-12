package Module3;

public class Test {
	int i;
	int j;

	public static void main(String[] args) {
		int area = calArea1(3,4);
		System.out.println(area);
		Test t = new Test();
		area = calArea2(t);
		System.out.println(area);
		}

		public static int calArea1(int i, int j) {
		return i*j;
		}

		public static int calArea2(Test t) {
		t.i=t.i+10;
		System.out.println(t.i);
		t.j=t.i+20;
		System.out.println(t.j);
		return t.i*t.j;
		}

		}

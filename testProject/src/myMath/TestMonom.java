package myMath;



public class TestMonom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		testAdd();
		testMultiply();
		testDerivative();
		testFx();
		testEquals();
		testMonomString();

	}

	public static void testAdd() {

		System.out.println("testAdd");
		double a = 3.5;
		int b = 2;
		Monom m1 = new Monom(a,b);
		Monom m2 = new Monom(m1);

		m2.add(m1);
		System.out.println(m1+" + "+m1+" = "+m2);
	}


	public static void testMultiply() {
		System.out.println();
		System.out.println("testMultiply");

		double a = 2.5, c = 13;
		int b = 2, d = 0;
		Monom m3 = new Monom(a,b);
		Monom m4 = new Monom(c,d);
		Monom m5 = new Monom(m3);
		m5.multiply(m4);

		System.out.println(m3+" * "+m4+" = "+m5);
	}

	public static void testDerivative() {

		System.out.println();
		System.out.println("testDerivative");

		double a = 2.5, c = 13;
		int b = 2, d = 1;
		Monom m3 = new Monom(a,b);
		Monom m4 = new Monom(c,d);
		System.out.println(m3);
		m3.derivative();
		System.out.println(m3);
	}


	public static void testFx() {
		System.out.println();
		System.out.println("testFx");

		double x = Math.random()*10;
		double a = 2.5, c = 13;
		int b = 2, d = 1;
		Monom m3 = new Monom(a,b);
		Monom m4 = new Monom(c,d);

		System.out.println("if x = " + x);
		System.out.println(m3 + " = "  + m3.f(x));

		x = Math.random()*10;

		System.out.println("if x = " + x);
		System.out.println(m4 + " = "  + m4.f(x));
	}

	public static void testEquals() {
		System.out.println();
		System.out.println("testEquals");

		double a = 2.5, c = 13;
		int b = 2, d = 0;
		Monom m1 = new Monom(a,b);
		Monom m2 = new Monom(m1);
		Monom m3 = new Monom(a,b);
		Monom m4 = new Monom(c,d);

		System.out.println("if m3 equal to m4 = " + m3.equals(m4));

		System.out.println("if m1 equal to m2 = " +m1.equals(m2));

	}


	public static void testMonomString(){
		System.out.println();
		System.out.println("testMonomString");
		
		String s = "-4X";
		String s1 = "X";
		String s2 = "-4.4X";
		String s3 = "-5.6X^0";
		String s4 = "6X^5";
		String s5 = "-X";
		Monom m = new Monom(s);
		System.out.println("String s = " + s);
		System.out.println("Monom m = String s = " + m);
		Monom m1 = new Monom(s1);
		System.out.println("String s = " + s1);
		System.out.println("Monom m = String s1 = " + m1);
		Monom m2 = new Monom(s2);
		System.out.println("String s = " + s2);
		System.out.println("Monom m = String s2 = " + m2);
		Monom m3 = new Monom(s3);
		System.out.println("String s = " + s3);
		System.out.println("Monom m = String s3 = " + m3);
		Monom m4 = new Monom(s4);
		System.out.println("String s = " + s4);
		System.out.println("Monom m = String s4 = " + m4);
		Monom m5 = new Monom(s5);
		System.out.println("String s = " + s5);
		System.out.println("Monom m = String s5 = " + m5);
	}


}

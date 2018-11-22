package myMath;

public class TestPolynom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		testFx();
		testAdd();
		testSubtract();
		testMultiply();
		testEquals();
		testZero();
		testCopy();
		testDerivative();
		testRoot();
		testArea();
		testPolynomString();
		


	}

	public static void testFx(){
		System.out.println("testFx");
		Polynom p = new Polynom();
		double x = Math.random()*10;
		
		Monom a = new Monom(2.8,2);
		Monom b = new Monom(-4.5,3);
		Monom c = new Monom(-1,1);
		
		p.add(a);
		p.add(b);
		p.add(c);
		System.out.println("x = " + x);
		System.out.println(p + " = " + p.f(x) );
		
	}

	public static void testAdd(){
		System.out.println();
		System.out.println("testAdd");
		Monom a = new Monom(1.46,2);
		Monom b = new Monom(-10,0);
		Monom c = new Monom(2.4,1);

		Monom d = new Monom(-1,1);
		Monom e = new Monom(4,2);
		Monom f = new Monom(3.5,3);

		Polynom p = new Polynom();
		Polynom p1 = new Polynom();
		
		p.add(a);
		p.add(b);
		p.add(c);
		
		p1.add(d);
		p1.add(e);
		p1.add(f);
		
		System.out.println("polynomial:");
		System.out.println("p = " + p);
		System.out.println("p1 = " + p1);
		System.out.println();
		p.add(p1);
		System.out.println("p + p1 = " + p);
		
	}

	public static void testSubtract(){
		System.out.println();
		System.out.println("testSubtract");
		Monom a = new Monom(1.46,2);
		Monom b = new Monom(-10,5);
		Monom c = new Monom(2.4,4);

		Monom d = new Monom(-1,1);
		Monom e = new Monom(4,2);
		Monom f = new Monom(0,3);

		Polynom p = new Polynom();
		Polynom p1 = new Polynom();
		
		p.add(a);
		p.add(b);
		p.add(c);
		p1.add(d);
		p1.add(e);
		p1.add(f);
		
		System.out.println("polynomial:");
		System.out.println("p = " + p);
		System.out.println("p1 = " + p1);
		p.substract(f);
		p1.substract(c);
		
		System.out.println();
		System.out.println("p = " + p);
		System.out.println("p1 = " + p1);
		
		System.out.println();
		p.substract(p1);
		System.out.println("p - p1 = " + p);
	}

	public static void testMultiply(){
		System.out.println();
		System.out.println("testMultiply");
		Monom a = new Monom(1.46,2);
		Monom b = new Monom(-10,0);
		Monom c = new Monom(2.4,1);

		Monom d = new Monom(-1,1);
		Monom e = new Monom(4,2);
		Monom f = new Monom(3.5,3);

		Polynom p = new Polynom();
		Polynom p1 = new Polynom();
		
		p.add(a);
		p.add(b);
		p.add(c);
		p1.add(d);
		p1.add(e);
		p1.add(f);
		
		System.out.println("polynomial:");
		System.out.println("p = " + p);
		System.out.println("p1 = " + p1);
	
		System.out.println();
		p.multiply(p1);
		System.out.println("p * p1 = " + p);
	}

	public static void testEquals(){
		System.out.println();
		System.out.println("isZero");
		Monom a = new Monom(1.46,2);
		Monom b = new Monom(-10,0);
		Monom c = new Monom(2.4,1);

		Monom d = new Monom(-1,1);
		Monom e = new Monom(4,2);
		Monom f = new Monom(3.5,3);

		Polynom p = new Polynom();
		Polynom p1 = new Polynom();
		Polynom p2 = new Polynom();
		Polynom p3 = new Polynom();
		
		p.add(a);
		p.add(b);
		p1.add(a);
		p1.add(b);
		p2.add(c);
		p2.add(d);
		p3.add(e);
		p3.add(f);
		
		System.out.println("if p equal p1 - " + p.equals(p1));
		System.out.println("if p2 equal p3 - " + p2.equals(p3));
	}

	public static void testZero(){
		System.out.println();
		System.out.println("testZero");
		Monom a = new Monom(1.46,2);
		Monom b = new Monom(-10,0);
		Monom c = new Monom(2.4,1);
		
		Polynom p = new Polynom();
		Polynom p1 = new Polynom();
		
		p.add(a);
		p.add(b);
		p.add(c);
		
		System.out.println("if p equal 0 - " + p.isZero());
		System.out.println("if p1 equal 0 - " + p1.isZero());
	}

	public static void testCopy(){
		System.out.println();
		System.out.println("testCopy");
		Monom a = new Monom(1.46,2);
		Monom b = new Monom(-10,0);
		Monom c = new Monom(2.4,1);
		
		Polynom p = new Polynom();
		
		p.add(a);
		p.add(b);
		p.add(c);
		
		Polynom p1 = new Polynom(p);
		
		System.out.println("p = " + p);
		System.out.println("p1 = " + p1);
		System.out.println("if p equal p1 - " + p.equals(p1));
	}

	public static void testDerivative(){
		System.out.println();
		System.out.println("testDerivative");
		Monom a = new Monom(1.46,2);
		Monom b = new Monom(-10,0);
		Monom c = new Monom(-2.4,1);
		
		Polynom p3 = new Polynom();
		
		p3.add(a);
		p3.add(b);
		p3.add(c);
		
		System.out.println("p3 = " + p3);
		System.out.println("derivative of p3 = " + p3.derivative());
	}
	
	public static void testRoot(){
		System.out.println();
		System.out.println("testRoot");
		Monom a = new Monom(1.46,2);
		Monom b = new Monom(-10,0);
		Monom c = new Monom(-2.4,1);
		
		Polynom p = new Polynom();
		
		p.add(a);
		p.add(b);
		p.add(c);
		double root = p.root(0, 100, 0.001);
		
		System.out.println(root);
	}

	public static void testArea(){
		System.out.println();
		System.out.println("testArea");
		Monom a = new Monom(1,5);
		Monom b = new Monom(3,2);
		Monom c = new Monom(7,0);
		
		Polynom p = new Polynom();
		
		p.add(a);
		p.add(b);
		p.add(c);
		double area = p.area(1, 4, 1);
		
		System.out.println(area);
	}
	
	public static void testPolynomString(){
		System.out.println();
		System.out.println("testPolynomString");
		String s = "5x^6 + 3x^2 + 5x + 6";
		
		Polynom p = new Polynom(s);
		Polynom p1 = new Polynom();
		p1.add(new Monom(5,6));
		p1.add(new Monom(3,2));
		p1.add(new Monom(5,1));
		p1.add(new Monom(6,0));
		System.out.println("p = s = " + p);
		System.out.println("if p equals p1 = " + p.equals(p1));
	}
}

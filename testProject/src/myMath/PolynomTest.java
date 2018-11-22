package myMath;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomTest {

	@Test
	void testPolynomString() {
		Polynom p1=new Polynom("3x^8 + 5x^3 + 2x^4 + 1x");
		Polynom p=new Polynom();
		p.add(new Monom(3,8));
		p.add(new Monom(5,3));
		p.add(new Monom(2,4));
		p.add(new Monom(1,1));
		if(p.equals(p1))
			fail("Eror , uncorrect constractor");
	}

	@Test
	public void testF() {
		Polynom p=new Polynom();
		p.add(new Monom(2,3));
		p.add(new Monom(2,4));
		p.add(new Monom(2,2));
		p.add(new Monom(2,1));
		p.add(new Monom(2,0));
		//System.out.println(p);
		if(p.f(2)!=62)
			fail("Not yet implemented");
	}

	@Test
	public void testAddPolynom_able() {
		Monom m1 = new Monom(2,2);
		Monom m2 = new Monom(1.5,3);
		Monom m3 = new Monom(2.5,0);

		Polynom p1 = new Polynom();
		p1.add(m1);
		p1.add(m2);
		p1.add(m3);

		Polynom p2 = new Polynom();
		p2.add(m1);
		p2.add(m2);
		p2.add(m3);

		p1.add(p2);
		if(!p1.equals(p2))
			fail("Not yet implemented");
	}

	@Test
	public void testAddMonom() {
		Monom m1 = new Monom(2,2);
		Monom m2 = new Monom(1.5,3);
		Monom m3 = new Monom(2.5,0);

		Polynom p1 = new Polynom();
		p1.add(m1);
		p1.add(m2);
		p1.add(m3);

		Polynom p2 = new Polynom();
		p2.add(m1);
		p2.add(m2);
		p2.add(m3);

		if(!p1.equals(p2))
			fail("Not yet implemented");
	}

	@Test
	public void testSubstractPolynom_able() {
		double c1 = 2.5 ;
		double c2 = 1.5 ;
		int p = 3 ;
		Monom m1 = new Monom(c1,p);
		Monom m2 = new Monom(c2,p);
		m1.substract(m2);
		if(m1.get_coefficient() != c1-c2)
			fail("Error , Substract mistake");
	}

	@Test
	public void testMultiply() {
		double c1 = 5.5;
		double c2 = 2;
		int p1 = 1;
		int p2 = 3;
		Monom m1 = new Monom(c1,p1);
		Monom m2 = new Monom(c2,p2);
		m1.multiply(m2);
		if(m1.get_coefficient() != c1*c2 || m1.get_power() != p1+p2 )
			fail("Error , Multiply mistake");
	}

	@Test
	public void testEqualsPolynom_able() {
		Polynom p1=new Polynom();
		p1.add(new Monom(2,2));
		p1.add(new Monom(2,1));
		Polynom p2=new Polynom();
		p2.add(new Monom(2,2));
		p2.add(new Monom(2,1));
		if(!p1.equals(p2))
			fail("Eror , equal function not working");
	}

	@Test
	public void testIsZero() {
		Polynom p = new Polynom() ;
		if(!p.isZero())
			fail("Error , checking if Polynom empty error");
	}

	@Test
	public void testRoot() {
		Polynom p1=new Polynom();
		p1.add(new Monom(-100,0));
		p1.add(new Monom(1,3));
		double e=0.01;
		double root=p1.root(0, 100, e);
		if(Math.abs(p1.f(root))>=e)
			fail("Error , uncorrect Root");
	}

	@Test
	public void testDerivative() {
		Polynom p=new Polynom();
		p.add(new Monom(2,2));
		p.add(new Monom(2,1));
		Polynom p1=new Polynom();
		p1.add(new Monom(4,1));
		p1.add(new Monom(2,0));
		if(!p.derivative().equals(p1))
			fail("Eror , uncorrect Derivative");
	}

	@Test
	public void testArea() {
		Polynom p1=new Polynom();
		p1.add(new Monom(2,2));
		p1.add(new Monom(5,1));
		p1.add(new Monom(10,0));
		double x1 = -2;
		double x2 = 2;
		double eps = 0.001;
		double y = p1.area(x1,x2,eps);
		System.out.println(y);
		System.out.println();
		if(x1<0 && x2<0)
			fail("Not yet implemented");
	}

}

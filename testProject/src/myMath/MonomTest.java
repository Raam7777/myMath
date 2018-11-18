package myMath;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonomTest {


	@Test
	public void testF() {
		double c = 5.65 ;
		int p = 0 ;
		Monom m = new Monom(c,p);
		int x = (int)Math.random()*10 ;
		if(m.f(x) != c * Math.pow(x,p))
			fail("Error , invaild value");
	}

	@Test
	public void testDerivative() {
		double c = 5.5 ;
		int p = 5;
		Monom m = new Monom(c,p);
		m.derivative();
		if((m.get_coefficient() != c*p || m.get_power() != p-1) && m.get_power()!=0)
			fail("Error , Derivative illegal");
	}

	@Test
	public void testAdd() {
		double c1 = 5.2;
		double c2 = 6.7;
		int p = 2;
		Monom m1 = new Monom(c1,p);
		Monom m2 = new Monom(c2,p);
		m1.add(m2);
		if(m1.get_coefficient() != c1 + c2)
			fail("Error , adding illegal");
	}

	@Test
	public void testMultiply() {
		double c1 = 5.3;
		double c2 = 7.4;
		int p1 = 6;
		int p2 = 2;
		Monom m1 = new Monom(c1,p1);
		Monom m2 = new Monom(c2,p2);
		m1.multiply(m2);
		if(m1.get_coefficient() != (c1*c2) || m1.get_power() != (p1+p2) )
			fail("Eror , Multiply mistake");
	}

}

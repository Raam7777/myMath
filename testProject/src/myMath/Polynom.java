package myMath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Raam Banin
 * @version 1.0
 */
public class Polynom implements Polynom_able{


	/**
	 * ArrayList of monoms when connected to the class Monom.
	 */
	private ArrayList<Monom> poly;

	/**
	 * connect to class Monom_Comperator and make sort.
	 */
	private Monom_Comperator cmp = new Monom_Comperator();



	public Polynom(){

		poly = new ArrayList<Monom>();
	}

	/**
	 * copy constructor when "this" contains a pointer to the current object from the object activated methods.
	 * define iterator of monoms. if we did not pass the last value define monom which is equal to the next value 
	 and sum it with the original polynom.
	 * @param ot - copy polynom.
	 */
	public Polynom(Polynom other){
		this();
		Iterator<Monom> iterM = other.iteretor();
		while(iterM.hasNext()){
			Monom m = iterM.next();
			this.add(new Monom(m));
		}
	}

	/**
	 * define new polynom and array of string when do split.
	 * do loop and in loop define new monom=(copy monom) and add to polynom the monom.
	 * copy place memory. 
	 * @param s
	 */
	public Polynom(String s){
		Polynom p = new Polynom();
		String [] arr = s.split(" \\+ ");

		for(int i=0; i<arr.length; i++){
			Monom m = new Monom(arr[i]);
			p.add(m);
		}
		this.poly= p.poly;
	}

	//Getter and Setter//

	public ArrayList<Monom> getPolynom() {
		return poly;
	}

	public void set_polynom(ArrayList<Monom> poly) {
		this.poly = poly;
	}

	public Monom_Comperator getCmp() {
		return cmp;
	}

	public void setCmp(Monom_Comperator cmp) {
		this.cmp = cmp;
	}



	/**
	 * Finding the function result when y=f(x). 
	 *define monoms iterator. if we did not pass the last value, define monom which will be the next value and p will be the sum 
	 of monoms in the polynom.
	 * @param x - get the x value in polinom.
	 * @return - the sum of all monoms 
	 */
	public double f(double x) {
		double P = 0;
		Iterator<Monom> iterM = this.iteretor();
		while(iterM.hasNext()){
			Monom m = iterM.next();
			P += m.f(x);
		}
		return P;
	}

	/**
	 * addition all the arrays monoms of polynomial to one polynomial. 
	 * add to the original polynom the all monoms in p1.
	 * @param get polynom
	 */
	public void add(Polynom_able p1) {
		Iterator<Monom> iterM = p1.iteretor();
		while(iterM.hasNext()){
			Monom m = iterM.next();
			this.add(m);
		}
	}

	/**
	 * addition between monoms with equal power from arrays monoms and sort in array.
	 * define boolean = false. define monoms iterator. if we did not pass the last value, define monom which will be the next value.
	 *if the powers of the two monoms m1 and m2 are equals, do sum between the monoms and define boolean= true. 
	 * if the coefficent = 0 remove the value.
	 * if the boolean value is negative and the power of monom >=0 and coefficent != 0 do: add monom m1 original polynom.
	 * sort polynom.
	 *@param Monom m -add to the function the monom.
	 */
	public void add(Monom m1) {
		boolean FoundPower = false;
		Iterator<Monom> iterM = this.iteretor();
		while(iterM.hasNext()){
			Monom m2 = iterM.next();
			if(m1.get_power()==m2.get_power()){
				m2.add(m1);
				FoundPower = true;	
				if(m2.get_coefficient()==0)
					iterM.remove();
			}

		}
		if(FoundPower==false && m1.get_power()>=0){
			if(m1.get_coefficient()!=0)
				poly.add(m1);
			this.poly.sort(cmp);
		}
	}

	/**
	 * subtraction all the arrays monoms of polynomial to one polynomial.
	 * subtract from the original polynom the all monoms of p1.
	 * @param p1 - substruct p1 from the original polynom.
	 */
	public void substract(Polynom_able p1) {
		Iterator<Monom> iterM = p1.iteretor();
		while(iterM.hasNext()){
			Monom m = iterM.next();
			this.substract(m);;
		}

	}

	/**
	 * subtraction between monoms with equal power from arrays monoms and sort in array.
	 *  * define boolean = false. define monoms iterator. if we did not pass the last value, define monom which will be the next value.
	 *if the powers of the two monoms m1 and m2 are equals, do subtract between the monoms and define boolean= true. 
	 * if the coefficent = 0 remove the value.
	 * if the boolean value is negative and the power of monom >=0, so define two monoms, first copy monom and second defult monom.
	 * do subtract between the monoms, copy place memory. and if coefficent != 0 do: add monom m1 original polynom.
	 * sort polynom.
	 */
	public void substract(Monom m1){
		boolean FoundPower = false;
		Iterator<Monom> iterM = this.iteretor();
		while(iterM.hasNext()){
			Monom m2 = iterM.next();
			if(m1.get_power()==m2.get_power()){
				m2.substract(m1);
				FoundPower = true;	
				if(m2.get_coefficient()==0)
					iterM.remove();


			}
		}
		if(FoundPower==false && m1.get_power()>=0){
			Monom m3 = new Monom(m1);
			Monom m2 = new Monom(0,0);
			m3.substract(m2);
			m1 = m3;
			if(m1.get_coefficient()!=0){
				poly.add(m1);
			}
			this.poly.sort(cmp);
		}

	}

	/**
	 * Multiply between two polynomials.
	 * @param p1 - multiply p1 in original polynom. 
	 */
	public void multiply(Polynom_able p1) {
		Polynom p2 = Polynom.multiply(p1, this);
		this.poly = p2.poly;
	}
	/**
	 * Private function makes the multiply of two polynomials.
	 * define p3 new polynom, if p1 and p2 not equals zero, so define monoms iterator.
	 * if we did not pass the last value, define monom which will be the next value.
	 * copy p2 to p4 and multiply all value monom in p4 and add to p3 the result to get in p4.  
	 * @param p1 - first polynomial.
	 * @param p2 - second polynomial.
	 * @return polynomial of obtained after the multiplication of two polynomials.
	 */
	private static Polynom multiply(Polynom_able p1, Polynom p2){
		Polynom p3 = new Polynom();
		if(!p1.isZero()&&!p2.isZero()){
			Iterator<Monom> iterM = p1.iteretor();
			while(iterM.hasNext()){
				Monom m = iterM.next();
				Polynom p4 = new Polynom(p2);
				p4.multiply(m);
				p3.add(p4);
			}
		}
		return p3;
	}
	/**
	 * Private function that multiplies a the monom in monom.
	 * if the coefficient equals zero, so clear original polynom.
	 * else define monoms iterator. if we did not pass the last value, define monom which will be the next value
	 end multiply monom in monom. 
	 * @param m1 - Gets new monom.
	 */
	private void multiply(Monom m1) {
		if(m1.get_coefficient()==0) {
			this.poly.clear();
		}
		else {
			Iterator<Monom> iterM = this.iteretor();
			while(iterM.hasNext()) {
				Monom m = iterM.next();
				m.multiply(m1);
			}
		}
	}

	/**
	 * equals between two polynomials. 
	 * define index size of count the amount of the monom in iterator.
	 * define boolean = false. if size of original polynom equal size from iterator, so define two iterators.
	 * first itertor for original polynom and second p1.
	 * if we did not pass the last value in original polynom, define monoms m1 and m2 which will be the next value
	 * if m1 and m2 not equals, so return false.
	 * @param p1 - get polynom
	 * @return - true or false.
	 */
	public boolean equals(Polynom_able p1) {
		int size=0;
		Iterator<Monom> iterM = p1.iteretor();
		while(iterM.hasNext()){
			iterM.next();
			size++;
		}
		boolean ans = false;
		if(poly.size()==size){
			ans = true;
			Iterator<Monom> iterM1 = this.iteretor();
			Iterator<Monom> iterM2 = p1.iteretor();
			while(iterM1.hasNext()){
				Monom m1 = iterM1.next();
				Monom m2 = iterM2.next();
				if(!(m1.equals(m2))){
					ans = false;
					return ans;
				}

			}
		}
		return ans;
	}

	/**
	 * size polynom
	 * @return size polynom
	 */
	public int size(){
		return this.poly.size();
	}

	/**
	 * Checking if the polynomial equal to zero.
	 */
	public boolean isZero() {
		if(this.poly.size()==0)
			return true;
		return false;
	}

	/**
	 * root - https://en.wikipedia.org/wiki/Bisection_method
	 * define two indexes y0 and y1 - first result of f(x0) and second result of f(x1).
	 * if y0*y1>0 , so no continuous function.
	 * define two index absX and absY. if one from two indexes > eps, so define two index middleX and middleY.
	 * if y0*middleY or y1middleY < 0, so continuous function.
	 * @param x0 starting point
	 * @param x1 end point
	 * @param eps step (positive) value
	 * @return - The resulting approximation of the root according to epsilon.
	 */
	public double root(double x0, double x1, double eps) {
		double y0 = this.f(x0);
		double y1 = this.f(x1);

		if(y0*y1>0) {
			throw new RuntimeException("Error: bisection method does not converges because so no continuous function ");
		}

		double absX = Math.abs(x0-x1);
		double absY = Math.abs(y0-y1);

		if (absX>eps || absY>eps) {
			double middleX = (x0+x1)/2;
			double middleY = this.f(middleX);
			if(y0*middleY<0) {
				return root(x0,middleX, eps);
			}else if(y1*middleY<0){
				return root(middleX, x1, eps);
			}
		}
		return x0;
	}

	/**
	 * create a deep copy of this Polynomial.
	 */
	public Polynom_able copy() {
		Polynom_able p1 = new Polynom();
		Iterator<Monom> iterM = this.iteretor();
		while(iterM.hasNext()){
			Monom m = iterM.next();
			p1.add(m);
		}
		return p1;
	}

	/**
	 * Compute a new Polynom which is the derivative of this Polynom
	 */
	public Polynom_able derivative() {
		Polynom_able p1 = new Polynom();
		Iterator<Monom> iterM = this.iteretor();
		while(iterM.hasNext()){
			Monom m = iterM.next();
			Monom m1 = new Monom(m);
			m1.derivative();
			p1.add(m1);
		}
		return p1;
	}

	/**
	 * Compute Riemann's Integral over this Polynom starting from x0, till x1 using eps size steps,
	 * see: https://en.wikipedia.org/wiki/Riemann_integral
	 * see: https://www.youtube.com/watch?v=nwvJWYqMoyk
	 * define n = number of rectangles.
	 * for(i=1->n), define xi any point, if f(xi)<0 , so no calculate the area.
	 * @return the approximated area above the x-axis below this Polynom and between the [x0,x1] range.
	 */
	public double area(double x0, double x1, double eps) {

		if(f(x0)<0 && f(x1)<0){
			throw new RuntimeException("Error: f(x) under to legate the x");
		}

		int n = (int) ((x1-x0)/eps);

		double sumUp = 0;
		for(int i=1; i<=n; i++){
			double xi = x0 + eps*(i-1);
			if(f(xi)>=0){
				sumUp += this.f(xi);
			}
		}
		return sumUp*eps;
	}

	public double areaUnder(double x0, double x1, double eps) {

		if(f(x0)<0 && f(x1)<0){
			throw new RuntimeException("Error: f(x) under to legate the x");
		}

		int n = (int) ((x1-x0)/eps);

		double sumUnder = 0;
		for(int i=1; i<=n; i++){
			double xi = x0 + eps*(i-1);
			if(f(xi)<0){
				sumUnder += this.f(xi);
			}
		}
		return Math.abs(sumUnder*eps);
	}

	/**
	 * @return an Iterator (of Monoms) over this Polynom.
	 */
	public Iterator<Monom> iteretor() {
		return this.poly.iterator();

	}

	public String toString() {
		String a = "";

		if(this.isZero()) {
			return "0";
		}
		Iterator<Monom> iterM = this.iteretor();
		a += iterM.next();
		for(int i = 0; i<size()-1; i++) {
			Monom m = iterM.next();
			if(m.get_coefficient()>0)
				a += " + " + m;
			else if(m.get_coefficient()<0)
				a += m;	
		}
		return a;
	}

}

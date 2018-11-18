
package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Raam Banin
 * @version 1.0
 */
public class Monom implements function{



	private double _coefficient; // 
	private int _power;
	private static Monom init_from_string = null;

	/**
	 * Define string with non-capital letter. define two variables. if the string is empty return error message.
	 * Define index = x and index = minus and index = power.
	 * if x = -1 return a to equals number of find in string.
	 * else if x=0 or minus=0 and x=1 , so if x=0 number a=1 if minus=0 number a=-1 ,and b= 1.
	 * if p existent so b=the rest of the string, else a=(still x) and b = all other.
	 * @param s - get monom in string.
	 * @return - return a new monom.
	 */
	private Monom init_from_string(String s) {

		s=s.toLowerCase();
		double a = 0;
		int b =0;
		if(s==null){
			throw new RuntimeException("ERR can not init from string");
		}
		int x_index = s.indexOf("x");
		int minus_index = s.indexOf("-");
		int p_index = s.indexOf("^");
		if(x_index ==-1){
			a = Double.parseDouble(s);
		}else if((x_index == 0) || (minus_index==0 && x_index == 1) ){
			if(x_index == 0)
				a = 1;
			if(minus_index==0)
				a = -1;
			b = 1;
			if(p_index!=-1){
				String pow = s.substring(p_index+1,s.length());
				b = Integer.parseInt(pow);
			}

		}else{
			a = Double.parseDouble(s.substring(0, x_index));
			b = 1;
			if(p_index!=-1){
				String pow = s.substring(p_index+1,s.length());
				b = Integer.parseInt(pow);
			}
		}

		return new Monom(a,b);
	}

	/**
	 * create a new monom according to string and get it in to the original monom.
	 * @param s - monom in the string
	 */
	public Monom(String s){
		Monom m = init_from_string(s);
		this.set_coefficient(m.get_coefficient());
		this.set_power(m.get_power());
	}

	/**
	 * constructor with parameterized.
	 * @param a - coefficient.
	 * @param b - power.
	 */
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}

	/**
	 * copy constructor
	 * @param ot - copy parameterized 
	 */
	public Monom(Monom ot) {
		this._coefficient = ot._coefficient;
		this._power = ot._power;
	}

	/**
	 * The function return the y value if the power is not negative.
	 */
	public double f(double x) {
		double y=0;
		if(this.get_power()>=0){
			y = this.get_coefficient()*Math.pow(x, this.get_power());
		}else{
			throw new RuntimeException("Erorr, power cannot be negative");
		}
		return y; 
	}
	/** Monom derivative - if power is 0 return 0, else do power * monom coefficient and -1 from monom power.
	 * original monom after a derived method.
	 */

	public void derivative(){
		if(_power<0){
			throw new RuntimeException("Erorr, power cannot be negative");
		}
		if(_power==0){
			set_coefficient(0);
		}else{
			double a = this.get_coefficient()*this.get_power();
			int b = this.get_power()-1;
			this.set_coefficient(a);
			this.set_power(b);
		}
	}
	/**
	 * addition between two monom. if powers of the monoms is equal sum the monoms coefficients.
	 * @param m - the monom we want to add.
	 */
	public void add(Monom m){
		if(_power<0){
			throw new RuntimeException("Erorr, power cannot be negative");
		}
		if(this.get_power()==m.get_power())
			this.set_coefficient(this.get_coefficient()+m.get_coefficient());
		else
			throw new RuntimeException("Erorr, powers not equals");
	}
	/**
	 * subtraction between two monom - if the monoms coefficients are equal subtract between the monoms.
	 * else multiply the original monom in -1, because we are subtrahend. 
	 * @param m - the monom we want to subtract.
	 */
	public void substract(Monom m){
		if(this.get_power()==m.get_power())
			this.set_coefficient(this.get_coefficient()-m.get_coefficient());
		else{
			this.set_coefficient(-1*this.get_coefficient());
			this.set_power(this.get_power());
		}
	}
	/**
	 * multiply between two monoms and sum the powers.
	 * @param m - the monom we want to multiply.
	 */
	public void multiply(Monom m){
		if(this.get_power()>=0){
			this.set_coefficient(this.get_coefficient()*m.get_coefficient());
			this.set_power(this.get_power()+m.get_power());
		}else{
			throw new RuntimeException("Erorr, power cannot be negative");
		}
	}
	/**
	 * comparison between two monoms - if the monom is not empty and the coefficients are equal
	 and the powers are equals as well so the monoms are equal. 
	 * @param m - the monom we want to make comparison.
	 * @return - if equal or no.
	 */
	public boolean equals(Monom m) {
		if(m!=null) {
			if(this.get_coefficient() == m.get_coefficient() && this.get_power() == m.get_power()) {
				return true;
			}
		}
		return false;
	}

	public String toString(){
		if(_power<0)
			throw new RuntimeException("Error: power cannot be negative");
		else if(_coefficient>0 && _power>0){
			if(_power==1)
				return _coefficient  + "X";
			return _coefficient  + "X" + "^" + _power;
		}
		else if(_coefficient<0 && _power>0){
			if(_power==1)
				return " - " + Math.abs(_coefficient)  + "X";
			return " - " + Math.abs(_coefficient)  + "X" + "^" + _power;
		}
		else if(_coefficient>0 && _power==0)
			return _coefficient + "";
		else if(_coefficient<0 && _power==0)
			return " - " + Math.abs(_coefficient);
		else
			return 0 + "";
	}

	//**Getter and Setter**//

	public double get_coefficient() {
		return _coefficient;
	}
	public int get_power() {
		return _power;
	}
	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		this._power = p;
	}





}

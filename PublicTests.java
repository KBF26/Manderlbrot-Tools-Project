import static org.junit.Assert.*;

import org.junit.Test;


public class PublicTests {

	@Test
	public void testBasicConstructorsAndGetters() {

		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble d = new MyDouble(555.729);

		ComplexNumber x = new ComplexNumber(a, b);
		assertTrue(x.getReal().compareTo(a) == 0 && 
				x.getImag().compareTo(b) == 0);

		ComplexNumber z = new ComplexNumber(d);
		assertTrue(z.getReal().compareTo(d) == 0 && 
				z.getImag().compareTo(new MyDouble(0)) == 0);
	}
	@Test
	public void testCopyConstructor() {

		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);

		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(x);
		assertTrue(x != y);   
		assertTrue(y.getReal().compareTo(a) == 0 &&
				y.getImag().compareTo(b) == 0);
	}
	@Test
	public void testAdd() {

		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble c = new MyDouble(5.7), d = new MyDouble(-3.7);
		MyDouble e = new MyDouble(11.4), f = new MyDouble(-7.4);
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(c, d);
		ComplexNumber z = new ComplexNumber(e, f);
		assertTrue(x != y); 
		assertTrue(x.add(y).compareTo(z) == 0);
	}
	@Test
	public void testSubtract() {

		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble c = new MyDouble(5.7), d = new MyDouble(-3.7);
		MyDouble e = new MyDouble(0), f = new MyDouble(0);
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(c, d);
		ComplexNumber z = new ComplexNumber(e, f);
		assertTrue(x != y); 
		assertTrue(x.subtract(y).compareTo(z) == 0);	
	}
	@Test
	public void testMult() {

		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble c = new MyDouble(5.7), d = new MyDouble(-3.7);
		MyDouble e = new MyDouble(18.8), f = new MyDouble(-42.18);
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(c, d);
		ComplexNumber z = new ComplexNumber(e, f);
		assertTrue(x != y); 
		assertTrue(x.multiply(y).compareTo(z) == 0);		

	}
	@Test
	public void testDiv() {

		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble c = new MyDouble(5.7), d = new MyDouble(-3.7);
		MyDouble e = new MyDouble(1.0), f = new MyDouble(1.0);
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(c, d);
		ComplexNumber z = new ComplexNumber(e, f);
		assertTrue(x != y); 
		assertTrue(x.getReal().equals(y.getReal()));
		assertTrue(x.getImag().equals(y.getImag()));
	}
	@Test
	public void testEqComp() {

		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble c = new MyDouble(5.7), d = new MyDouble(-3.7);
		MyDouble e = new MyDouble(3.5), f = new MyDouble(-4.5);

		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(c, d);
		ComplexNumber z = new ComplexNumber(e, f);
		assertTrue(x.equals(y));     
		assertTrue(z.compareTo(x) < 0);
	}
	@Test
	public void testNorm() {

		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble c = new MyDouble(3), d = new MyDouble(4);
		MyDouble e = new MyDouble(5);

		ComplexNumber x = new ComplexNumber(c, d);
		assertTrue(ComplexNumber.norm(x).equals(e));   
	}
	@Test
	public void testParse() {

		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		String string = new String ("5.7 - 3.7i");

		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = ComplexNumber.parseComplexNumber(string);
		assertTrue(x.equals(y));   

		MyDouble c = new MyDouble(5.7), d = new MyDouble(3.7);
		String string2 = new String ("5.7 + 3.7i");

		ComplexNumber e = new ComplexNumber(c, d);
		ComplexNumber f = ComplexNumber.parseComplexNumber(string2);
		assertTrue(e.equals(f)); 
	}
}
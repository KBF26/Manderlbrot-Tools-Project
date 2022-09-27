
public class ComplexNumber {

	/* This class represents the mathematical concept of complex numbers. 
	 * In math, complex numbers have a real part and an imaginary part and this 
	 * implements that concept. */
	private final MyDouble real;  
	private final MyDouble imag;   


	/* The 1st constructor represents the real and imaginary part in the 
	 * parameter. Real and Imaginary are initialized with values. */
	public ComplexNumber(MyDouble real, MyDouble imag) {
		this.real = real;
		this.imag = imag;
	}
	/*The 2nd constructor represents the real part in the parameter. Real part 
	 * is initialized with a value. Imaginary part will be set to zero. 
	 * are initialized with values.   */
	public ComplexNumber(MyDouble real) {
		this.real = real;
		this.imag = new MyDouble(0);
	}
	/*This is the copy constructor and making "another" constructor*/
	public ComplexNumber(ComplexNumber anotherComplexNumber) {
		this.real = anotherComplexNumber.real;
		this.imag = anotherComplexNumber.imag;
	}
	/*Get the value of the Real part*/
	public MyDouble getReal() {
		return this.real;
	}
	/*Get the value of the Imaginary part */
	public MyDouble getImag() {
		return this.imag;
	}
	/*This method has one parameter. It will return a complex number that's
	 * equal to the sum of the object and parameter. */
	public ComplexNumber add(ComplexNumber otherComplexNumber){
		MyDouble realPart = this.getReal().add(otherComplexNumber.getReal());
		MyDouble imagPart = this.getImag().add(otherComplexNumber.getImag());

		ComplexNumber returnValue =  new ComplexNumber(realPart, imagPart);
		return returnValue;
	}
	/*This method has one parameter. It will return a complex number that's
	 * being put in by subtracting the parameter from the object*/
	public ComplexNumber subtract(ComplexNumber otherComplexNumber){
		MyDouble realPart = this.getReal().subtract
				(otherComplexNumber.getReal());
		MyDouble imagPart = this.getImag().subtract
				(otherComplexNumber.getImag());

		ComplexNumber returnValue = new ComplexNumber(realPart, imagPart);
		return returnValue;
	}
	/*This method has one parameter. It will return a complex number that's
	 * equal to the product of the object and parameter.*/
	public ComplexNumber multiply(ComplexNumber otherComplexNumber){

		MyDouble realFirst = new MyDouble(this.getReal().multiply
				(otherComplexNumber.getReal()));
		MyDouble realSecond = new MyDouble(this.getImag().multiply
				(otherComplexNumber.getImag()));
		MyDouble realPart = new MyDouble(realFirst.subtract(realSecond));

		MyDouble imagFirst = new MyDouble(this.getReal().multiply
				(otherComplexNumber.getImag()));
		MyDouble imagSecond = new MyDouble(this.getImag().multiply
				(otherComplexNumber.getReal()));
		MyDouble imagPart = new MyDouble(imagFirst.add(imagSecond));

		ComplexNumber returnValue = new ComplexNumber(realPart, imagPart);
		return returnValue;

	}
	/*This method has one parameter. It will return a complex number that's
	 * being put in by dividing the object from the parameter*/
	public ComplexNumber divide(ComplexNumber otherComplexNumber){
		ComplexNumber current = new ComplexNumber(this.getReal(), 
				this.getImag());

		ComplexNumber conjugate = new ComplexNumber
				(otherComplexNumber.getReal(), 
						convertToNegative(otherComplexNumber.getImag()));

		ComplexNumber denom = new ComplexNumber(otherComplexNumber.
				multiply(conjugate));

		MyDouble denomRealPart = new MyDouble(denom.getReal());

		ComplexNumber theNumerator = new ComplexNumber(current.
				multiply(conjugate));


		MyDouble realPart = theNumerator.getReal().divide(denomRealPart);

		MyDouble imagPart = theNumerator.getImag().divide(denomRealPart);

		ComplexNumber returnValue = new ComplexNumber(realPart, imagPart);

		return returnValue;

	}
	/*This method returns true if get Real and get Imaginary are equal to the 
	 * other get Real and get Imaginary */
	public boolean equals(ComplexNumber otherComplexNumber){
		return (this.getReal().equals(otherComplexNumber.getReal()) 
				&& this.getImag().equals(otherComplexNumber.getImag()));
	}
	/*This method compares the norm of complex number to the 
	 * other complex number*/
	public int compareTo(ComplexNumber otherComplexNumber){
		MyDouble currentComplexValue = norm(this);

		int complexValue = currentComplexValue.compareTo
				(norm(otherComplexNumber));

		int result = 0;

		if(complexValue < 0) result = -1;

		if(complexValue > 0) result = 1;

		return result;
	}
	/*The method will return a string. Returning a real part + imaginary part*/
	public String toString(){
		MyDouble zero = new MyDouble(0);
		MyDouble realPart = this.getReal();
		MyDouble imagPart = this.getImag();

		int realCompareResult = realPart.compareTo(zero);
		int imagCompareResult = imagPart.compareTo(zero);

		if(realCompareResult > 0 &&  imagCompareResult > 0)
		{
			return realPart + "+" + imagPart +"i";
		}else if(realCompareResult < 0 && imagCompareResult > 0)
		{
			return realPart +"+"+ imagPart +"i";
		}else if(realCompareResult > 0 && imagCompareResult < 0)
		{
			return realPart +imagPart.toString()+"i";
		}else if(realCompareResult < 0 && imagCompareResult < 0)
		{
			return realPart +imagPart.toString()+"i";
		}

		return null;
	}
	/*This method will return the real Imaginary square root. This method does
	 * a squared + b squared. */
	public static MyDouble norm(ComplexNumber otherComplexNumber){
		MyDouble realPart = otherComplexNumber.getReal().
				multiply(otherComplexNumber.getReal());
		MyDouble imagPart = otherComplexNumber.getImag().
				multiply(otherComplexNumber.getImag());

		MyDouble realImaginerySum = realPart.add(imagPart);

		MyDouble realImaginerySqrt = realImaginerySum.sqrt();

		return realImaginerySqrt;

	}
	/*This method will return either a complex number(real, imaginary) that 
	 * contains a (+) else returning a complex number(real, imaginary that
	 * contains a (-). */
	public static ComplexNumber parseComplexNumber(String stringInput){
		String complexNumberString = removeAllWhiteSpace(stringInput);

		int indexOfI = complexNumberString.indexOf("i");

		if(complexNumberString.contains("+")){
			int positionOfPlus = complexNumberString.indexOf("+");

			String realText = complexNumberString.substring(0, positionOfPlus);
			String imagText = complexNumberString.substring
					(positionOfPlus, indexOfI);

			double realDouble = Double.parseDouble(realText);
			double imagDouble = Double.parseDouble(imagText);

			MyDouble real = new MyDouble(realDouble);
			MyDouble imag = new MyDouble(imagDouble);

			return new ComplexNumber(real,imag);

		}else{
			int positionOfMinus = complexNumberString.lastIndexOf("-");

			String realText = complexNumberString.substring(0, positionOfMinus);
			String imagText = complexNumberString.substring
					(positionOfMinus, indexOfI);

			double realDouble = Double.parseDouble(realText);
			double imagDouble = Double.parseDouble(imagText);

			MyDouble real = new MyDouble(realDouble);
			MyDouble imag = new MyDouble(imagDouble);

			return new ComplexNumber(real,imag);
		}
	}
	/*This method the value to a negative number.*/
	private MyDouble convertToNegative(MyDouble input){
		MyDouble negativeOne = new MyDouble(-1.0);
		MyDouble returnValue = input.multiply(negativeOne);
		return returnValue;
	}
	/*This method removes white space from the input string.*/
	private static String removeAllWhiteSpace(String inputString){
		return inputString.replaceAll("\\s", "");
	}
}

